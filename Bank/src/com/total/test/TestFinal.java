package com.total.test;

public class TestFinal {
	//修饰变量 这个变量的值只能赋值一次
	final int i; //final后没有默认初始化
	public TestFinal() {
		i = 10;
	}
	
	void f(final int j) {
//		j++;
	}
	
	final void g( ) { //这个方法不可以被子类重写
		
	}
	
	public static void main(String[] args) {
		//修饰变量
		final int j;
		j = 10;
//		j = 20;
		TestFinal tf = new TestFinal();
//		tf.i = 20;
	}

}
