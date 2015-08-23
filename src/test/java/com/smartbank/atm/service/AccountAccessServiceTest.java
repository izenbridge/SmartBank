package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.model.Account;
import com.smartbank.atm.model.LoginRequest;

public class AccountAccessServiceTest {
	
	private AccountAccessService accountAccessService;
	private LoginRequest loginReq;
	
	@Before
	public void init(){
		loginReq = new LoginRequest();
		accountAccessService = new AccountAccessService();
	}
	
	@Test
	public void testAuthenticateSuccess(){
		String debitCardNo = "3333333333333333";
		loginReq.setDebitCardNumber(debitCardNo);
		Account account = accountAccessService.getUserAccount(debitCardNo);
		loginReq.setAtmPin(account.getDebitCardPin());
		
		Assert.assertEquals("Welcome " + account.getAccountNumber(), accountAccessService.authenticate(loginReq));
	}
	
	@Test
	public void testAuthenticateFailInvalidDebitCard(){
		loginReq.setDebitCardNumber("3452368598592384");
		loginReq.setAtmPin("3333");
		Assert.assertEquals("Invalid Debit Card number! Please enter a valid 16-digit Debit Card number.", accountAccessService.authenticate(loginReq));
	}
	
	@Test
	public void testAuthenticateFailInvalidPin(){
		loginReq.setDebitCardNumber("3333333333333333");
		loginReq.setAtmPin("6666");
		Assert.assertEquals("Invalid PIN! Please enter your 4-digit ATM PIN to access your account.", accountAccessService.authenticate(loginReq));
	}
}
