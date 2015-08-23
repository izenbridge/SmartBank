package com.smartbank.atm.exception;

public class InvalidDebitCardNumberException extends Exception{
	
	private static final long serialVersionUID = -3183828579261923362L;

	public InvalidDebitCardNumberException(){
		super("Invalid Debit Card number! Please enter a valid 16-digit Debit Card number.");
	}
}
