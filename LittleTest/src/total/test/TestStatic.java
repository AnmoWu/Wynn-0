package total.test;

public class TestStatic {
	
	int i = 10; //��Ա����   sb.i
	
	static int j = 20;  //sb.j   TestStatic.j  ����.��̬����

	void f() {
		System.out.println(i); //a
		System.out.println(j); //b
//		g();
	}
	
	static void g() { //TestStatic.g()
//		f();
//		System.out.println(i) //c  ��̬�ķ��������Է��ʷǾ�̬��
		System.out.println(j); //d
	}
	
	public static void main(String[] args) {
		TestStatic ts1 = new TestStatic();
		TestStatic ts2 = new TestStatic();
	}

}
