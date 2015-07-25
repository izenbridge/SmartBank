package com.smartbank.atm.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartbank.atm.service.AccountAccessService;

@Controller
public class TxnOptionsController {
	private static final Logger logger = LogManager.getLogger(TxnOptionsController.class.getName());
	
	@Autowired
	private AccountAccessService authenticationService;
	
	@RequestMapping(value="/options", method = RequestMethod.GET)
	public String options() {
		logger.trace("options: request received");
		return "options";
	}

}
