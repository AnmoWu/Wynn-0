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
			System.out.println("请输入正确的取款金额！");
			return;
		}
		if (amount > balance) {
			System.out.println("存款余额不足！");
			return;
		}
		balance -= amount;

	}

}
