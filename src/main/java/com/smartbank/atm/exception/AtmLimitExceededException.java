package com.smartbank.atm.exception;


public class AtmLimitExceededException extends Exception {

	private static final long serialVersionUID = 1431977457648477203L;

	public AtmLimitExceededException()
	{

	}

	public AtmLimitExceededException(String message)
	{
		super(message);
	}

	public AtmLimitExceededException(Throwable cause)
	{
		super(cause);
	}

	public AtmLimitExceededException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public AtmLimitExceededException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
