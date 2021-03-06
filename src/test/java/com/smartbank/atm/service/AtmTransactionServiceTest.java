package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.bean.Account;
import com.smartbank.atm.exception.InsufficientFundsException;
import com.smartbank.atm.exception.InvalidAmountException;

public class AtmTransactionServiceTest {

	private AtmTransactionService atmTransactionService;
	private Account account;
	private long initialAtmBalance = 1000000;
	
	@Before
	public void initialize() {
		atmTransactionService = new AtmTransactionService();
		atmTransactionService.setAtmBalance(initialAtmBalance);
		account = getUserAccountWithBalance(10000);
	}

	@Test
	public void validWithdrawalOf1000DebitsAccount() throws Exception {
		atmTransactionService.withdraw(account, 1000);
		
		Assert.assertEquals(9000, account.getBalance());
	}

	@Test
	public void validWithdrawalOf1000DebitsAtmBalance() throws Exception {
		atmTransactionService.withdraw(account, 1000);
		
		Assert.assertEquals(999000, atmTransactionService.getAtmBalance());
	}

	@Test (expected=InvalidAmountException.class)
	public void invalidMultipleOfHundredThrowsError_123() throws Exception {
		atmTransactionService.withdraw(account, 123);
	}

	@Test (expected=InvalidAmountException.class)
	public void invalidMultipleOfHundredThrowsError_0() throws Exception {
		atmTransactionService.withdraw(account, 0);
	}

	@Test (expected=InvalidAmountException.class)
	public void invalidMultipleOfHundredThrowsError_Minus100() throws Exception {
		atmTransactionService.withdraw(account, -100);
	}

	@Test (expected=InsufficientFundsException.class)
	public void withdrawingMoreThanAccountBalanceThrowsError() throws Exception {
		atmTransactionService.withdraw(account, 10100);
	}

	@Test (expected=InsufficientFundsException.class)
	public void withdrawingEqualToAccountBalanceThrowsError() throws Exception {
		atmTransactionService.withdraw(account, 10000);
	}

	@Test
	public void withdrawingMoreThanAtmTxnLimitThrowsError() throws Exception {
		int withdrawalAmount = atmTransactionService.getSingleTxnLimit();
		account.setBalance(withdrawalAmount+100);

		atmTransactionService.withdraw(account, withdrawalAmount);
	}
	
	@Test
	public void withdrawingEqualToAtmTxnLimitIsFine() throws Exception {
		int withdrawalAmount = atmTransactionService.getSingleTxnLimit();
		account.setBalance(withdrawalAmount+1000);
		
		atmTransactionService.withdraw(account, withdrawalAmount);
		
		Assert.assertEquals(1000000-withdrawalAmount, (int)atmTransactionService.getAtmBalance());
		Assert.assertEquals(1000, (int)account.getBalance());
	}

	private Account getUserAccountWithBalance(int seedMoney) {
		Account account = new Account("12345678", "0000000000000000", "1234", seedMoney);
		return account;
	}

}
