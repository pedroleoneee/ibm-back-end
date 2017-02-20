package br.com.ibm.model;

public class Transfer {

	private Long creditAccount;
	private Long debitAccount;
	private Float valueTransfer;

	public Long getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(Long creditAccount) {
		this.creditAccount = creditAccount;
	}

	public Long getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Long debitAccount) {
		this.debitAccount = debitAccount;
	}

	public Float getValueTransfer() {
		return valueTransfer;
	}

	public void setValueTransfer(Float valueTransfer) {
		this.valueTransfer = valueTransfer;
	}

}
