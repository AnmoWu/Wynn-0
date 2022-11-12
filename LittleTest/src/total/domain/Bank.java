package total.domain;

public class Bank {
//	1.��ǰ���е��˻�����ļ���,�����������
	private Account[] accounts; // has a ��ϵ �������֮��Ĺ�ϵ
//	2.��ǰ�˻�����
	private int count;

	//����ģʽ û��֮ǰ����ǰ���
//	private static final Bank INSTANCE = new Bank();
//	public static final Bank getBank() {
//		return INSTANCE;

	
	//����ģʽ ʲôʱ���õ�ʲôʱ����
	private static Bank INSTANCE ;
	public static final Bank getBank() {
		if(INSTANCE == null) {
			INSTANCE = new Bank();
		}
		return INSTANCE;
	}
	
	private Bank() {
		accounts = new Account[10];
	}

	/**
	 * 1.�û�����,��Ҫ�Ĳ���:id,����,����ȷ��,����,���֤����,����,�˻�����(int),�����´�����Account����
	 */
	public Account openAccount(long id, String password, String confirm, String name, String personId, String email,
			int accountType) {
		if (!password.equals(confirm)) {
			System.out.println("�������벻һ�£�");
			return null;
		}
		Account acc = null;
		// 1. SavingAccount 2. CreditAccount
		if (accountType == 1) {
			acc = new SavingAccount(id, password, name, personId, email, 0);
		} else if (accountType == 2) {
			acc = new CreditAccount(id, password, name, personId, email, 0, 0);
		}
		accounts[count++] = acc;
		return acc;
	}

	public Account getAccount(long id) {
		for (Account account : accounts) {
			if (account != null && account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	/**
	 * �û���¼,����:id,���� ����Account����,��ʾ ��s1.equals(s2)�ж�s1��s2�����ַ��������Ƿ����
	 */
	public Account login(long id, String password) {
		Account acc = getAccount(id);
		if (acc != null && acc.getPassword().equals(password)) {
			return acc;
		}
		System.out.println("ID���������������������!");
		return null;
	}

	/**
	 * �û����,����:id,�������,�����޸Ĺ���Account����
	 */
	public Account deposit(long id, double amount) {
		Account acc = getAccount(id);
		acc.deposit(amount);
		return acc;
	}

	/**
	 * �û�ȡ��,����:id,ȡ������,�����޸Ĺ���Account����
	 */
	public Account withdraw(long id, double amount) {
		Account acc = getAccount(id);
		acc.withdraw(amount); //��̬
		return acc;
	}
	/**
	 * ����͸֧��� ����:id,�µĶ��  ,�����޸Ĺ���Account����.���������Ҫ��֤�˻��Ƿ��������˻�
	 */
	public Account setCeiling(long id, double ceiling) {
		Account acc = getAccount(id);
		if(!(acc instanceof CreditAccount)) {
			System.out.println("ֻ�������˻������������ö");
			return null;
		}
		((CreditAccount) acc).setCeiling(ceiling);
		return acc;
	}
	
	/**
	 * ����:���� id,�����,�����޸Ĺ���Account����
	 */
	public Account requestLoan(long id, double loan) {
		Account acc = getAccount(id);
		if(!(acc instanceof Loan)) {
			System.out.println("���˻��ǿɴ����˻���");
			return null;
		}
		((Loan) acc).requestLoan(loan);
		return acc;
	}
	
	/**
	 * ������:���� id,�����,�����޸Ĺ���Account����
	 */
	public Account payLoan(long id, double loan) {
		Account acc = getAccount(id);
		if(!(acc instanceof Loan)) {
			System.out.println("���˻��ǿɴ����˻���");
			return null;
		}
		((Loan) acc).payLoan(loan);
		return acc;
	}
	
	
	/**
	 * 1.ͳ�����������˻��������
	 */
	public double calcTotalBalance() {
		double sum = 0;
		for (Account account : accounts) {
			if (account != null) {
				sum += account.getBalance();
			}
		}
		return sum;
	}
	
	/**
	 * ͳ�����������˻�͸֧�������
	 */
	public double calcTotalCeiling() {
		double sum = 0;
		for (Account account : accounts) {
			if (account != null && (account instanceof CreditAccount)) {
				sum += ((CreditAccount) account).getCeiling();
			}
		}
		return sum;
	}
	
	/**
	 * ͳ�������˻����������
	 */
	public double calcTotalLoan() {
		double sum = 0;
		for (Account account : accounts) {
			if (account != null && (account instanceof Loan)) {
				sum += ((Loan) account).getLoan();
			}
		}
		return sum;
	}
	
}
