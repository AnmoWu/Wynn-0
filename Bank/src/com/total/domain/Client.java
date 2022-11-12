package com.total.domain;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Bank bank = Bank.getBank();
		
		Scanner sc = new Scanner(System.in);
		int cmd;
		do {
			System.out.println("1. ������2. ��¼�� 3. ȡ� 4. �� 5. �˳�");
			cmd = sc.nextInt();
			if(cmd == 1) {
				System.out.println("������ID:");
				long id = sc.nextLong();
				System.out.println("����������:");
				String password = sc.next();
				System.out.println("���ٴ�ȷ������:");
				String confirm = sc.next();
				System.out.println("��������ʵ����:");
				String name = sc.next();
				System.out.println("���������֤����:");
				String personId = sc.next();
				System.out.println("������Email:");
				String email = sc.next();
				System.out.println("�������˻�����");
				int accountType = sc.nextInt();
				bank.openAccount(id, password, confirm, name, personId, email, accountType);
				
			}else if(cmd == 3) {
				System.out.println("������id:");
				long id = sc.nextLong();
				System.out.println("������ȡ����:");
				double amount = sc.nextDouble();
				bank.withdraw(id, amount);
			}
			
		}while(cmd!=5);
		
		
		
	}
}
