package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.bean.Account;
import com.smartbank.atm.exception.InvalidAccountException;

public class AccountAccessServiceTest {

	private AccountAccessService accountAccessService;
	
	@Before
	public void setup() {
		accountAccessService = new AccountAccessService();
	}
	
	@Test
	public void testCreateAccountFromString() {
		String accountString = "12345,1234567890123456,1234,10000";
		
		Account account = accountAccessService.createAccountFromString(accountString);
		
		Assert.assertEquals("12345", account.getAccountNumber());
		Assert.assertEquals("1234567890123456", account.getDebitCardNumber());
		Assert.assertEquals("1234", account.getDebitCardPin());
		Assert.assertEquals(10000, account.getBalance());
	}

	@Test
	public void testCreateAccountFromString_Null() {
		Account account = accountAccessService.createAccountFromString(null);
		Assert.assertNull(account);
	}

	@Test
	public void testCreateAccountFromString_EmptyString() {
		Account account = accountAccessService.createAccountFromString("");
		Assert.assertNull(account);
	}

	@Test(expected=InvalidAccountException.class)
	public void testCreateAccountFromString_IncompleteString() {
		String accountString = "12345,1234567890123456,1234";
		accountAccessService.createAccountFromString(accountString);
	}
	
}
