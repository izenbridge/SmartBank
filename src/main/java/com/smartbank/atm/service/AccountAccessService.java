package com.smartbank.atm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.smartbank.atm.model.Account;
import com.smartbank.atm.model.LoginRequest;

@Service
public class AccountAccessService {

	private static Map<String, Account> mapCardNumAndAccount = new HashMap<String, Account>();
	static {
		mapCardNumAndAccount.put("3333333333333333", 
				new Account("33333333", "3333333333333333", "3333", 30000));
		mapCardNumAndAccount.put("4444444444444444", 
				new Account("44444444", "4444444444444444", "4444", 40000));
		mapCardNumAndAccount.put("5555555555555555", 
				new Account("55555555", "5555555555555555", "5555", 50000));
		mapCardNumAndAccount.put("6666666666666666", 
				new Account("66666666", "6666666666666666", "6666", 60000));
		mapCardNumAndAccount.put("7777777777777777", 
				new Account("77777777", "7777777777777777", "7777", 70000));
		mapCardNumAndAccount.put("8888888888888888", 
				new Account("88888888", "8888888888888888", "8888", 80000));
		mapCardNumAndAccount.put("9999999999999999",
				new Account("99999999", "9999999999999999", "9999", 90000));
	};
	
	public String authenticate(LoginRequest loginRequest) {
		Account userAccount = getUserAccount(loginRequest.getDebitCardNumber());
		if (userAccount == null) {
			return "Invalid Debit Card number! Please enter a valid 16-digit Debit Card number.";
		}

		if (!userAccount.getDebitCardPin().equals(loginRequest.getAtmPin())) {
			return "Invalid PIN! Please enter your 4-digit ATM PIN to access your account.";
		}
		
		return null;
	}

	public Account getUserAccount(String debitCardNumber) {
		return mapCardNumAndAccount.get(debitCardNumber);
	}
	
}
