//输入一个分数，要求在0~100之间，超出范围就打印非法数据，90~100分 打印A，80-89打印B，
//70~79打印C,60-69打印D ，其他打印不及格 (分别用if 和 switch 完成)

import java.util.Scanner;

public class HW03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int income=sc.nextInt();
        if (income<0||income>100){
            System.out.println("非法数据");
        }
        else if(income>=90){
            System.out.println("A");
        }
        else if(income>=80){
            System.out.println("B");
        }
        else if(income>=70){
            System.out.println("C");
        }
        else if(income>=60){
            System.out.println("D");
        }
        else{
            System.out.println("不及格");
        }
        sc.close();
    }
}
