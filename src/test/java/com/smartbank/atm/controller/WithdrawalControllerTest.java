package com.smartbank.atm.controller;

import org.junit.Assert;
import org.junit.Test;

public class WithdrawalControllerTest {

	@Test
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
	}
}
