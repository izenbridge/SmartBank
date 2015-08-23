package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.controller.WithdrawalController;
import com.smartbank.atm.exception.InsufficientFundsException;
import com.smartbank.atm.exception.InvalidAmountException;
import com.smartbank.atm.model.Account;

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
	
	
	
	@Test (expected=InvalidAmountException.class)
	public void invalidAmountThrowsError_0() throws Exception {
		atmTransactionService.withdraw(account, "Aasc");
	}
	
	@Test (expected=InvalidAmountException.class)
	public void invalidAmountThrowsError_1() throws Exception {
		atmTransactionService.withdraw(account, "AJHD786");
	}
	
	@Test (expected=InvalidAmountException.class)
	public void invalidAmountThrowsError_2() throws Exception {
		atmTransactionService.withdraw(account, "-1000");
	}
	
	
	@Test (expected=InvalidAmountException.class)
	public void invalidAmountThrowsError_3() throws Exception {
		atmTransactionService.withdraw(account, "00000");
	}
	
	

	/*@Test
	public void testIsRequestedAmountValid_ValidAmounts() throws Exception {
		WithdrawalController controller = new WithdrawalController();

		Assert.assertTrue(controller.isRequestedAmountValid("100"));
		Assert.assertTrue(controller.isRequestedAmountValid("900"));
		Assert.assertTrue(controller.isRequestedAmountValid("1000"));
		Assert.assertTrue(controller.isRequestedAmountValid("1100"));
		Assert.assertTrue(controller.isRequestedAmountValid("9900"));
		Assert.assertTrue(controller.isRequestedAmountValid("10000"));
		Assert.assertTrue(controller.isRequestedAmountValid("10100"));
		Assert.assertTrue(controller.isRequestedAmountValid("99000"));
		Assert.assertTrue(controller.isRequestedAmountValid("99900"));
	}

	@Test
	public void testIsRequestedAmountValid_InvalidAmounts() throws Exception {
		WithdrawalController controller = new WithdrawalController();

		Assert.assertFalse(controller.isRequestedAmountValid("ABC"));
		Assert.assertFalse(controller.isRequestedAmountValid("-100"));
		Assert.assertFalse(controller.isRequestedAmountValid("1"));
		Assert.assertFalse(controller.isRequestedAmountValid("10"));
		Assert.assertFalse(controller.isRequestedAmountValid("0"));
		Assert.assertFalse(controller.isRequestedAmountValid("00000"));
		Assert.assertFalse(controller.isRequestedAmountValid("100000"));
	}*/

}
