/*猜数字
    随机生成1-100之间的随机数(提示：Math.random()方法可以生成0~1之间的一个随机数)，
    用户键盘录入猜数字
    如果猜对了，打印“答对了”
    如果猜错了
    猜大了：打印“大了!”
    猜小了：打印“小了!”
    直到数字猜到为止
    打印出用户猜的次数*/

import java.util.Scanner;

public class HW10 {
    public static void main(String[] args) {
        int key=(int)(Math.random()*99+1);
        Scanner sc= new Scanner(System.in);
        int num,i;
        for(i=1;(num=sc.nextInt())!=key;i++){
            if(num>key)
                System.out.println("大了！");
            else if(num<key)
                System.out.println("小了！");
        }
        sc.close();
        System.out.println("答对了");
        System.out.println("一共猜了"+i+"次");
    }
}
