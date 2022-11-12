package com.total.domain;

public class LoanSavingAccount extends SavingAccount implements Loan {

	private double loan;
	
	public LoanSavingAccount() {
		super();
	}

	public LoanSavingAccount(long id, String password, String name, String personId, String email, double balance, double loan) {
		super(id, password, name, personId, email, balance);
		this.loan = loan;
	}

	@Override
	public void requestLoan(double loan) {
		if(loan < 0) {
			System.out.println("贷款金额不正确!");
			return;
		}
		this.loan += loan;
	}

	@Override
	public void payLoan(double loan) {
		if(loan < 0) {
			System.out.println("还贷金额不正确！");
			return;
		}
		if(loan > balance) {
			System.out.println("存款余额不足还贷！");
			return;
		}
		this.balance -= loan;
		this.loan -= loan;
		

	}

	@Override
	public double getLoan() {
		return loan;
	}

}
