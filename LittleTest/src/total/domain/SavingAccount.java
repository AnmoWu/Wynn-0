package total.domain;

public class SavingAccount extends Account {

	public SavingAccount() {
		super();
	}

	public SavingAccount(long id, String password, String name, String personId, String email, double balance) {
		super(id, password, name, personId, email, balance);
	}

	@Override
	public void withdraw(double amount) {

		if (amount <= 0) {
			System.out.println("��������ȷ��ȡ���");
			return;
		}
		if (amount > balance) {
			System.out.println("������㣡");
			return;
		}
		balance -= amount;

	}

}
