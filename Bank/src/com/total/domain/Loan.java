package com.total.domain;

public interface Loan {
	//requestLoan:����
	void requestLoan(double loan);
	//payLoan:����
	void payLoan(double loan);
	//getLoan:��ȡ�û������ܶ�
	double getLoan();
}
