package com.total.test;

public class TestFinal {
	//���α��� ���������ֵֻ�ܸ�ֵһ��
	final int i; //final��û��Ĭ�ϳ�ʼ��
	public TestFinal() {
		i = 10;
	}
	
	void f(final int j) {
//		j++;
	}
	
	final void g( ) { //������������Ա�������д
		
	}
	
	public static void main(String[] args) {
		//���α���
		final int j;
		j = 10;
//		j = 20;
		TestFinal tf = new TestFinal();
//		tf.i = 20;
	}

}
