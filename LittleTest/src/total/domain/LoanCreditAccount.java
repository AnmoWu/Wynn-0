package total.domain;

public class LoanCreditAccount extends CreditAccount implements Loan {
	private double loan;

	@Override
	public void requestLoan(double loan) {
		if(loan < 0) {
			System.out.println("�������ȷ��");
		}
		this.loan+=loan;
	}

	@Override
	public void payLoan(double loan) {
		if(loan < 0) {
			System.out.println("��������ȷ��");
			return;
		}
		if(balance + ceiling < loan) {
			System.out.println("����������ö�Ȳ��㻹����");
			return;
		}
		balance -= loan;
		this.loan -= loan;
		
	}

	@Override
	public double getLoan() {
		return loan;
	}

}
