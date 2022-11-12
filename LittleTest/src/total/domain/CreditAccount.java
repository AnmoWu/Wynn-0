package total.domain;

public class CreditAccount extends Account {

	protected double ceiling;

	public CreditAccount() {
		super();
	}

	public CreditAccount(long id, String password, String name, String personId, String email, double balance, double ceiling) {
		super(id, password, name, personId, email, balance);
		this.ceiling = ceiling;
	}

	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("��������ȷ��ȡ���");
			return;
		}
		if(balance + ceiling < amount) {
			System.out.println("����������ö�Ȳ��㣡");
			return;
		} 
		balance -= amount;
	}

}
