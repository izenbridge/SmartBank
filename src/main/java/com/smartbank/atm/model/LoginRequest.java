package com.smartbank.atm.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 8343394922010170114L;

	private String debitCardNumber;
	
	private String atmPin;

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public String getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(String atmPin) {
		this.atmPin = atmPin;
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Debit Card#=")
		.append(debitCardNumber)
		.append(", ATM PIN=")
		.append(atmPin).toString();
	}
}
