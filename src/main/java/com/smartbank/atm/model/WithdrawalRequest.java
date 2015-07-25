package com.smartbank.atm.model;

import java.io.Serializable;

public class WithdrawalRequest implements Serializable {

	private static final long serialVersionUID = 5846488529445725460L;

	private String debitCardNumber;
	private String requestedAmount;
	private int amountToWithdraw;

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public int getAmountToWithdraw() {
		return amountToWithdraw;
	}

	public void setAmountToWithdraw(int amountToWithdraw) {
		this.amountToWithdraw = amountToWithdraw;
	}

	
	public String getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(String requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Debit Card#=")
		.append(debitCardNumber)
		.append(", Amount requested=")
		.append(requestedAmount).toString();
	}
}
