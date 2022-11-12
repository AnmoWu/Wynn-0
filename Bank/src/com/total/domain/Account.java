package com.total.domain;

public abstract class Account {
	public static long no = 100000;
	// id:账户号码 长整数
	private long id;
	// password:账户密码
	private String password;
	// name:真实姓名
	private String name;
	// personId:身份证号码 字符串类型
	private String personId;
	// email:客户的电子邮箱
	private String email;
	// balance:账户余额
	//int balance// int 精确到分，来代表钱
	// BigDecimal balance// 现实中，涉及到大额的金钱，用BigDecimal来代替
	protected double balance; // 正式环境不用浮点数代表金钱

	public Account() {
//		this.id = ++no;
	}

	public Account(long id, String password, String name, String personId, String email, double balance) {
		this.id = id;
//		this();
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.email = email;
		this.balance = balance;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * deposit: 存款方法,参数是double型的金额
	 */
	public final void deposit(double amount) {
		balance += amount;
	}

	/**
	 * withdraw:取款方法,参数是double型的金额
	 */
	public abstract void withdraw(double amount);

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", personId=" + personId + ", email=" + email + ", balance="
				+ balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return id == other.id;
	}
	
	
	
}
