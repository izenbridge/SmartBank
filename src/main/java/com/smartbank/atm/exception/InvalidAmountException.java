package com.smartbank.atm.exception;

public class InvalidAmountException extends Exception {

	private static final long serialVersionUID = -5318678928638339952L;

	public InvalidAmountException() {
		super();
	}

	public InvalidAmountException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidAmountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidAmountException(String arg0) {
		super(arg0);
	}

	public InvalidAmountException(Throwable arg0) {
		super(arg0);
	}

	
}
