package com.smartbank.atm.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePageController {
	private static final Logger logger = LogManager.getLogger(HomePageController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		logger.trace("index: request received");
		return "index";
	}

}
