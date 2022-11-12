package total.domain;

public class Bank {
//	1.当前所有的账户对象的集合,存放在数组中
	private Account[] accounts; // has a 关系 类和属性之间的关系
//	2.当前账户数量
	private int count;

	//饿汉模式 没用之前就提前造好
//	private static final Bank INSTANCE = new Bank();
//	public static final Bank getBank() {
//		return INSTANCE;

	
	//懒汉模式 什么时候用到什么时候造
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
	 * 1.用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象
	 */
	public Account openAccount(long id, String password, String confirm, String name, String personId, String email,
			int accountType) {
		if (!password.equals(confirm)) {
			System.out.println("两次密码不一致！");
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
	 * 用户登录,参数:id,密码 返回Account对象,提示 用s1.equals(s2)判断s1和s2两个字符串内容是否相等
	 */
	public Account login(long id, String password) {
		Account acc = getAccount(id);
		if (acc != null && acc.getPassword().equals(password)) {
			return acc;
		}
		System.out.println("ID或者密码错误，请重新输入!");
		return null;
	}

	/**
	 * 用户存款,参数:id,存款数额,返回修改过的Account对象
	 */
	public Account deposit(long id, double amount) {
		Account acc = getAccount(id);
		acc.deposit(amount);
		return acc;
	}

	/**
	 * 用户取款,参数:id,取款数额,返回修改过的Account对象
	 */
	public Account withdraw(long id, double amount) {
		Account acc = getAccount(id);
		acc.withdraw(amount); //多态
		return acc;
	}
	/**
	 * 设置透支额度 参数:id,新的额度  ,返回修改过的Account对象.这个方法需要验证账户是否是信用账户
	 */
	public Account setCeiling(long id, double ceiling) {
		Account acc = getAccount(id);
		if(!(acc instanceof CreditAccount)) {
			System.out.println("只有信用账户才能设置信用额！");
			return null;
		}
		((CreditAccount) acc).setCeiling(ceiling);
		return acc;
	}
	
	/**
	 * 贷款:参数 id,贷款额,返回修改过的Account对象
	 */
	public Account requestLoan(long id, double loan) {
		Account acc = getAccount(id);
		if(!(acc instanceof Loan)) {
			System.out.println("该账户非可贷款账户！");
			return null;
		}
		((Loan) acc).requestLoan(loan);
		return acc;
	}
	
	/**
	 * 还贷款:参数 id,还款额,返回修改过的Account对象
	 */
	public Account payLoan(long id, double loan) {
		Account acc = getAccount(id);
		if(!(acc instanceof Loan)) {
			System.out.println("该账户非可贷款账户！");
			return null;
		}
		((Loan) acc).payLoan(loan);
		return acc;
	}
	
	
	/**
	 * 1.统计银行所有账户余额总数
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
	 * 统计所有信用账户透支额度总数
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
	 * 统计所有账户贷款的总数
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
