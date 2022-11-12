//int a = 10; a++ + a++ +a++ ，   ++a + ++a + ++a 的值是多少

public class HW02 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a++ + a++ +a++);   //33
        System.out.println(++a + ++a + ++a);  //36
    }
}
