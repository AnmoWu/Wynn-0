package total.test;

public class TestStatic {
	
	int i = 10; //成员变量   sb.i
	
	static int j = 20;  //sb.j   TestStatic.j  类名.静态变量

	void f() {
		System.out.println(i); //a
		System.out.println(j); //b
//		g();
	}
	
	static void g() { //TestStatic.g()
//		f();
//		System.out.println(i) //c  静态的方法不可以访问非静态的
		System.out.println(j); //d
	}
	
	public static void main(String[] args) {
		TestStatic ts1 = new TestStatic();
		TestStatic ts2 = new TestStatic();
	}

}
