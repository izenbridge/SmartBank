package com.smartbank.atm.exception;


public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 9145162034681495890L;
	
	public InsufficientFundsException()
	{

	}

	public InsufficientFundsException(String message)
	{
		super(message);
	}

	public InsufficientFundsException(Throwable cause)
	{
		super(cause);
	}

	public InsufficientFundsException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InsufficientFundsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
