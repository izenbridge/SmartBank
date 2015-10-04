package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.bean.Account;
import com.smartbank.atm.bean.LoginRequest;
import com.smartbank.atm.exception.InvalidAccountException;

public class AccountAccessServiceTest {

	private AccountAccessService accountAccessService;
	private LoginRequest loginRequest;
	private String INVALID_PIN_MESSAGE = "Invalid PIN! Please enter your 4-digit ATM PIN to access your account.";
	private String INVALID_DEBIT_CARD_MESSAGE = "Invalid Debit Card number! Please enter a valid 16-digit Debit Card number.";
	
	@Before
	public void setup() {
		accountAccessService = new AccountAccessService();
		loginRequest = new LoginRequest();
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

	@Test
	public void testGetUserAccountByDebitCardNumber() {
		String debitCardNumber = "3333333333333333";
		Account account = accountAccessService.getUserAccount(debitCardNumber);
		Assert.assertNotNull(account);
	}
	
	@Test
	public void testAuthenticateRequest_Successful() {
		loginRequest.setDebitCardNumber("3333333333333333");
		loginRequest.setAtmPin("3333");
		String message = accountAccessService.authenticate(loginRequest);
		Assert.assertNull(message);
	}
	
	@Test
	public void testAuthenticateRequest_InvalidPin() {
		loginRequest.setDebitCardNumber("3333333333333333");
		loginRequest.setAtmPin("3331");
		String message = accountAccessService.authenticate(loginRequest);
		Assert.assertEquals(INVALID_PIN_MESSAGE,message);
	}
	
	@Test
	public void testAuthenticateRequest_InvalidDebitCard() {
		loginRequest.setDebitCardNumber("3333333333333331");
		loginRequest.setAtmPin("3333");
		String message = accountAccessService.authenticate(loginRequest);
		Assert.assertEquals(INVALID_DEBIT_CARD_MESSAGE,message);
	}
	
	@Test(expected=InvalidAccountException.class)
	public void testCreateAccountFromString_IncompleteString() {
		String accountString = "12345,1234567890123456,1234";
		accountAccessService.createAccountFromString(accountString);
	}
	
}
