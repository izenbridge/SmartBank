package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.exception.InvalidDebitCardNumberException;
import com.smartbank.atm.exception.InvalidDebitPinNumberException;
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
	public void testAuthenticateSuccess() throws InvalidDebitCardNumberException, InvalidDebitPinNumberException
	{
		String debitCardNo = "3333333333333333";
		loginReq.setDebitCardNumber(debitCardNo);
		loginReq.setAtmPin("3333");
		Account account = accountAccessService.authenticate(loginReq);
		
		Assert.assertEquals(debitCardNo, account.getDebitCardNumber());
	}
	
	@Test(expected = InvalidDebitCardNumberException.class)
	public void testAuthenticateFailInvalidDebitCard() throws InvalidDebitCardNumberException, InvalidDebitPinNumberException
	{
		loginReq.setDebitCardNumber("3452368598592384");
		loginReq.setAtmPin("3333");
		
		accountAccessService.authenticate(loginReq);
	}
	
	@Test(expected = InvalidDebitPinNumberException.class)
	public void testAuthenticateFailInvalidPin() throws InvalidDebitCardNumberException, InvalidDebitPinNumberException
	{
		loginReq.setDebitCardNumber("3333333333333333");
		loginReq.setAtmPin("6666");
		
		accountAccessService.authenticate(loginReq);
	}
}
