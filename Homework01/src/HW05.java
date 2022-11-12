//打印出1~100之间，所有不能被7整除，或者不含有数字7的比如17，70的数字

public class HW05 {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            if(i%7!=0&&i%10!=7&&i/10!=7)
                System.out.println(i);
        }
    }
}
