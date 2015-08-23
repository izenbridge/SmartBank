package com.smartbank.atm.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;
	
	@Before
	public void doBeforeExecutingTestMethods(){
		account = new Account("33333333", "3333333333333333", "3333", 10000);
	}
	
	@Test
	public void testDebitAccount(){
		account.debit(1000);
		Assert.assertEquals(9000, account.getBalance());
	}

}
