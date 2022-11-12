package com.total.test;

import com.total.domain.SavingAccount;

public class TestObject {

	public static void main(String[] args) {
		SavingAccount sa1 = new SavingAccount(100001L,"123456", "杨超越", "123342138214324", "chaoyue@163.com", 10000);
		SavingAccount sa2 = new SavingAccount(100001L,"123456", "杨超越", "123342138214324", "chaoyue@163.com", 10000);
		
		System.out.println(sa1);
		System.out.println(sa2);
		
		System.out.println(sa1 == sa2); // 对对象来说，== 比较的就是地址
		// equals方法在object类中等同于==
		System.out.println(sa1.equals(sa2)); 
		
		System.out.println(sa1.hashCode());
		System.out.println(sa2.hashCode());
		
	}

}
