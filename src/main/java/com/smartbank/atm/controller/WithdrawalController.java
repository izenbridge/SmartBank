package com.smartbank.atm.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartbank.atm.exception.AtmLimitExceededException;
import com.smartbank.atm.exception.InsufficientFundsException;
import com.smartbank.atm.exception.InvalidAmountException;
import com.smartbank.atm.model.Account;
import com.smartbank.atm.model.WithdrawalRequest;
import com.smartbank.atm.service.AccountAccessService;
import com.smartbank.atm.service.AtmTransactionService;

@Controller
public class WithdrawalController {
	private static final Logger logger = LogManager.getLogger(WithdrawalController.class.getName());
	
	@Autowired
	private AtmTransactionService atmTransactionService;

	@Autowired
	private AccountAccessService accountAccessService;

	private static Pattern PATTERN_VALID_AMOUNT = Pattern.compile("^[1-9](\\d){0,2}(0){2}$");
	
	@RequestMapping(value="/withdrawal", method = RequestMethod.GET)
	public String load(
			HttpServletRequest httpRequest,
			Model model) {
		logger.trace("load: request received");
		String debitCardNumber = getDebitCardNumberFromSession(httpRequest);
		if (StringUtils.isEmpty(debitCardNumber)) {
			model.addAttribute("errorMsg", "User session has timed out. Please login again.");
			return "login";
		}

		WithdrawalRequest withdrawalRequest = new WithdrawalRequest();
		withdrawalRequest.setDebitCardNumber(debitCardNumber);

		model.addAttribute("withdrawalRequest", withdrawalRequest);
		return "withdrawal";
	}

	private String getDebitCardNumberFromSession(HttpServletRequest httpRequest) {
		return (String) httpRequest.getSession().getAttribute("DebitCardNumber");
	}

	@RequestMapping(value="/withdrawal", method = RequestMethod.POST)
	public String withdrawMoney(
			WithdrawalRequest withdrawalRequest,
			Errors errors,
			Model model) 
	{
		logger.trace("withdrawMoney: request received..."+withdrawalRequest);
		if (!isRequestedAmountValid(withdrawalRequest.getRequestedAmount())) {
			logger.info("withdrawMoney: Invalid amount requested.");
			model.addAttribute("errorMsg", "Requested amount is invalid. Please try again.");
			return "withdrawal";
		}
		
		withdrawalRequest.setAmountToWithdraw(Integer.parseInt(withdrawalRequest.getRequestedAmount()));
		Account userAccount = accountAccessService.getUserAccount(withdrawalRequest.getDebitCardNumber());
		if (userAccount == null) {
			logger.info("withdrawMoney: Unidentifiable user..."+withdrawalRequest);
			model.addAttribute("errorMsg", "User session timed out. Please login again.");
			return "login";
		}
		
		try {
			logger.info("withdrawMoney: Withdrawing money from user account.");
			atmTransactionService.withdraw(userAccount, withdrawalRequest.getAmountToWithdraw());
		} 
		catch (InvalidAmountException e) {
			model.addAttribute("errorMsg", "Invalid amount specified. Please select amount in the multiples of 100.");
			return "withdrawal";
		} 
		catch (InsufficientFundsException e) {
			model.addAttribute("errorMsg", "You do not have enough funds to withdraw requested amount. Please enter a lower amount.");
			return "withdrawal";
		}
		catch (AtmLimitExceededException e2) {
			model.addAttribute("errorMsg", "The amount exceeds current ATM limit. Please select lower amount.");
			return "withdrawal";
		}
		return "withdrawalSuccess";
	}

	boolean isRequestedAmountValid(String requestedAmount) {
		return PATTERN_VALID_AMOUNT.matcher(requestedAmount).matches();
	}
}
