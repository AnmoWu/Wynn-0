/*键盘录入10个数字，完成下面的要求，请定义方法完成
    (1)	找出最大值、最小值和平均值。
    (2)	返回一个数组，该数组是录入顺序的倒序数组。
    (3)	数组中是否存在重复的数字。
    (4)	找出某个数字是否在数组中出现，返回出现的次数。
    (5)	打印数组中出现次数最多的数字。*/

//5 1 4 3 8 9 4 6 7 0

import java.util.Arrays;
import java.util.Scanner;

public class HW08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tes = new int[10];
        for(int i = 0;i < 10;i++){
            tes[i]= sc.nextInt();
        }
        sc.close();
        System.out.println("数组最大值为："+tes[findMax(tes)]);
        System.out.println("数组最小值为："+findMin(tes));
        System.out.println("数组平均值为："+findAverage(tes));
        System.out.println("关键字出现次数为："+findKey(tes,4));
        System.out.println("数组倒序输出为："+Arrays.toString(orderReverse(tes)));
        System.out.println("数组中是否存在重复数字："+repeatNumber(tes));
        System.out.println("数组中出现次数最多的数字为："+frequentOccur(tes));
    }

    //寻找最大值
    public static int findMax(int[] tes){
        int max=0;
        for(int i=1;i<tes.length;i++)
            if(tes[i]>tes[max])
                max=i;
        return max;
    }

    //寻找最小值
    public static int findMin(int[] tes){
        int min=tes[0];
        for(int i=1;i<tes.length;i++)
            if(tes[i]<min)
                min=tes[i];
        return min;
    }

    //求平均值
    public static int findAverage(int[] tes){
        int sum=tes[0];
        for(int i=1;i<tes.length;i++)
            sum+=tes[i];
        return sum/tes.length;
    }

    //数组倒序
    public static int[] orderReverse(int[] tes){
        int[] res=new int[tes.length];
        for(int i=tes.length-1;i>=0;i--)
            res[tes.length-i-1]=tes[i];
        return res;
    }

    //是否存在重复数字
    public static boolean repeatNumber(int[] tes){
        Arrays.sort(tes);
        for(int i=0;i<tes.length-2;i++)
            if (tes[i] == tes[i + 1])
                return true;
        return false;
    }

    //寻找关键字是否出现并返回出现次数
    public static int findKey(int[] tes,int key){
        int count=0;
        for(int i=0;i<tes.length;i++)
            if(tes[i]==key)
                count++;
    return count;
    }

    //打印出现次数最多的数字
    public static int frequentOccur(int[] tes){
        int[] count=new int[10];
        for(int i=0;i<tes.length;i++)
            count[tes[i]]++;
        return findMax(count);
    }

}
