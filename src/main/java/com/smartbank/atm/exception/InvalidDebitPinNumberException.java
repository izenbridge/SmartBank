package com.smartbank.atm.exception;

public class InvalidDebitPinNumberException extends Exception{

	private static final long serialVersionUID = 1726328180075501004L;

	public InvalidDebitPinNumberException(){
		super("Invalid PIN! Please enter your 4-digit ATM PIN to access your account.");
	}
}
