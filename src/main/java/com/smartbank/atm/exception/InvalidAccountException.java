package com.smartbank.atm.exception;

public class InvalidAccountException extends RuntimeException {

	private static final long serialVersionUID = 4121537573401143391L;

	public InvalidAccountException() {
		super();
	}

	public InvalidAccountException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidAccountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidAccountException(String arg0) {
		super(arg0);
	}

	public InvalidAccountException(Throwable arg0) {
		super(arg0);
	}

	
}
