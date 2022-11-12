package com.total.test;

import com.total.domain.Account;
import com.total.domain.Bank;

public class TestBank {
	public static void main(String[] args) {
		Bank bank = Bank.getBank();
		bank.openAccount(100001L,"123456", "123456", "Ñî³¬Ô½", "123342138214324", "chaoyue@163.com", 1);
		System.out.println(bank.login(100001L, "888888"));
		Account acc = bank.login(100001L, "123456");
		bank.deposit(100001L, 20000);
		bank.withdraw(100001L, 30000);
		acc = bank.withdraw(100001L, 5000);
		System.out.println(acc.getBalance());
		
		bank.openAccount(100002L, "123456", "123456", "Ò×ìÈÇ§çô", "1232131213", "yiyangqianxi@163.com", 2);
		bank.deposit(100002L, 5000);
		bank.setCeiling(100002L, 10000000);
		acc = bank.withdraw(100002L, 50000);
		System.out.println(acc.getBalance());
		
	}

}
