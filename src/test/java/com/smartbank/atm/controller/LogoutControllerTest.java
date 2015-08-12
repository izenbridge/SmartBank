package com.smartbank.atm.controller;

import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogoutControllerTest {

	@Mock
	HttpSession httpSession;

	@Mock
	HttpServletRequest httpServletRequest;

	@Test
	public void testLogout() throws Exception {
		LogoutController controller = new LogoutController();
		when(httpServletRequest.getSession()).thenReturn(httpSession);
		String actual = controller.logout(httpServletRequest);
		Assert.assertEquals("index", actual);

	}

}
