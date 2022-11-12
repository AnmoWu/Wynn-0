import java.util.Scanner;

public class HW04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入日期：");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        sc.close();
        int ret;
        if(b<2){
            ret=c;
        }
        else if(b==2){
            ret=c+31;
        }
        else{
            ret=59+c;
            for(int i=3;i<b;i++){
                if(i<8&&i%2==1||i>7&&i%2==0){
                    ret+=31;
                }
                else
                    ret+=30;
            }
            if(isLeapYear(a)){
                ret+=1;
            }
        }
        System.out.println("此日期是"+a+"年的第"+ret+"天");
    }

    public static boolean isLeapYear(int year){
        return year%4==0&&year%100!=0||year%400==0;
    }
}

