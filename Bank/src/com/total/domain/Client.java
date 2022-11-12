package com.total.domain;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Bank bank = Bank.getBank();
		
		Scanner sc = new Scanner(System.in);
		int cmd;
		do {
			System.out.println("1. 开户，2. 登录， 3. 取款， 4. 存款， 5. 退出");
			cmd = sc.nextInt();
			if(cmd == 1) {
				System.out.println("请输入ID:");
				long id = sc.nextLong();
				System.out.println("请输入密码:");
				String password = sc.next();
				System.out.println("请再次确认密码:");
				String confirm = sc.next();
				System.out.println("请输入真实姓名:");
				String name = sc.next();
				System.out.println("请输入身份证号码:");
				String personId = sc.next();
				System.out.println("请输入Email:");
				String email = sc.next();
				System.out.println("请输入账户类型");
				int accountType = sc.nextInt();
				bank.openAccount(id, password, confirm, name, personId, email, accountType);
				
			}else if(cmd == 3) {
				System.out.println("请输入id:");
				long id = sc.nextLong();
				System.out.println("请输入取款金额:");
				double amount = sc.nextDouble();
				bank.withdraw(id, amount);
			}
			
		}while(cmd!=5);
		
		
		
	}
}
