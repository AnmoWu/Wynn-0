package com.total.domain;

public interface Loan {
	//requestLoan:贷款
	void requestLoan(double loan);
	//payLoan:还贷
	void payLoan(double loan);
	//getLoan:获取用户贷款总额
	double getLoan();
}
