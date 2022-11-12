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
			System.out.println("�������ȷ!");
			return;
		}
		this.loan += loan;
	}

	@Override
	public void payLoan(double loan) {
		if(loan < 0) {
			System.out.println("��������ȷ��");
			return;
		}
		if(loan > balance) {
			System.out.println("������㻹����");
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
