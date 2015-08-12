package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.model.LoginRequest;

public class AccountAccessServiceTest {

	private AccountAccessService accountAccessService;
	LoginRequest loginRequest;

	@Before
	public void initialize() {
		accountAccessService = new AccountAccessService();
	}

	@Test
	public void authenticateInvalidDebitCarrdNumber() throws Exception {
		loginRequest = new LoginRequest();
		loginRequest.setDebitCardNumber("");
		Assert.assertNotEquals(null,accountAccessService.authenticate(loginRequest));
	}

	@Test
	public void authenticateInvalidPinNumber() {
		loginRequest = new LoginRequest();
		loginRequest.setDebitCardNumber("3333333333333333");
		loginRequest.setAtmPin("XXXX");
		Assert.assertNotEquals(null,accountAccessService.authenticate(loginRequest));
	}

	@Test
	public void authenticateWithCorrectDetails() {
		loginRequest = new LoginRequest();
		loginRequest.setDebitCardNumber("3333333333333333");
		loginRequest.setAtmPin("3333");
		Assert.assertEquals(null,accountAccessService.authenticate(loginRequest));
	}
}
