package com.total.domain;

public abstract class Account {
	public static long no = 100000;
	// id:�˻����� ������
	private long id;
	// password:�˻�����
	private String password;
	// name:��ʵ����
	private String name;
	// personId:���֤���� �ַ�������
	private String personId;
	// email:�ͻ��ĵ�������
	private String email;
	// balance:�˻����
	//int balance// int ��ȷ���֣�������Ǯ
	// BigDecimal balance// ��ʵ�У��漰�����Ľ�Ǯ����BigDecimal������
	protected double balance; // ��ʽ�������ø����������Ǯ

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
	 * deposit: ����,������double�͵Ľ��
	 */
	public final void deposit(double amount) {
		balance += amount;
	}

	/**
	 * withdraw:ȡ���,������double�͵Ľ��
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
