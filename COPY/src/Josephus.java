import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总人数N：");
        int total = scanner.nextInt();
        System.out.print("请输入报数K：");
        int count = scanner.nextInt();
        Jose(total, count);
    }

    public static void Jose(int total, int count) {
        List<Integer> first = new ArrayList<Integer>();
        for (int i = 1; i <= total; i++) {
            first.add(i);
        }
        //从第m人开始计数
        int m = 0;
        while (first.size() >0) {
            m = m + count;
            m = m % (first.size()) - 1;    //第k人的位置
            // 判断是否到队尾
            if (m < 0) {
                System.out.println(first.get(first.size()-1));
                first.remove(first.size() - 1);
                m = 0;
            }
            else {
                System.out.println(first.get(m));
                first.remove(m);
            }
        }
    }
}
