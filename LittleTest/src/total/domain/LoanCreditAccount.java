package total.domain;

public class LoanCreditAccount extends CreditAccount implements Loan {
	private double loan;

	@Override
	public void requestLoan(double loan) {
		if(loan < 0) {
			System.out.println("贷款金额不正确！");
		}
		this.loan+=loan;
	}

	@Override
	public void payLoan(double loan) {
		if(loan < 0) {
			System.out.println("还贷金额不正确！");
			return;
		}
		if(balance + ceiling < loan) {
			System.out.println("存款余额和信用额度不足还贷！");
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
