package com.smartbank.atm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogoutController {
	private static final Logger logger = LogManager.getLogger(LogoutController.class);

	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest httpRequest) {
		logger.trace("logout: request received");
		logger.info("logout: invalidating session...");
		httpRequest.getSession().invalidate();
		return "index";
	}

}
