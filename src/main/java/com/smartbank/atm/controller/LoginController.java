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

import com.smartbank.atm.model.LoginRequest;
import com.smartbank.atm.service.AccountAccessService;


@Controller
public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class.getName());

	private Pattern PATTERN_DEBIT_CARD_NUMBER = Pattern.compile("[3-9][0-9]{15}");
	
	@Autowired
	private AccountAccessService authenticationService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		logger.trace("login: request received");
		model.addAttribute("loginRequest", new LoginRequest());
		return "/login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String authenticate(
			HttpServletRequest httpRequest,
			LoginRequest loginRequest,
			Errors errors,
			Model model)
	{
		logger.trace("authenticate: request received");

		String error = validateRequest(loginRequest);
		if (!StringUtils.isEmpty(error)) {
			logger.info("authenticate: invalid request data..."+loginRequest);
			model.addAttribute("errorMsg", error);
			return "/login";
		}

		error = authenticationService.authenticate(loginRequest);
		if (!StringUtils.isEmpty(error)) {
			logger.info("authenticate: login request failed ("+loginRequest+"):"+error);
			model.addAttribute("errorMsg", "Authentication failed - " + error);
			return "/login";
		} 
		else {
			logger.info("authenticate: login successful..."+loginRequest);
			httpRequest.getSession().setAttribute("DebitCardNumber", loginRequest.getDebitCardNumber());
			return "redirect:/options";
		}

	}

	private String validateRequest(LoginRequest loginRequest) {
		if (loginRequest == null) 
			return "Invalid login request!";
		
		if (!validateDebitCardNumber(loginRequest.getDebitCardNumber()))
			return "Invalid Debit Card number! Please enter a valid 16-digit Debit Card number.";
		
		if (!validateAtmPin(loginRequest.getAtmPin()))
			return "Invalid ATM PIN! Please enter a valid 4-digit PIN.";
		
		return null;
	}

	public boolean validateDebitCardNumber(String debitCardNumber) {
		return (!StringUtils.isEmpty(debitCardNumber)
				&& PATTERN_DEBIT_CARD_NUMBER.matcher(debitCardNumber).matches());
	}

	public boolean validateAtmPin(String atmPin) {
		return !StringUtils.isEmpty(atmPin)
				&& (atmPin.length() == 4);
	}

}
