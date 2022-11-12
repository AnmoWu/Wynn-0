/*1.有一个二维数组
{
 {8,3,6,12,0,9},
 {7,15,4,5,8,10,11},
 {13,1,1}
}
找出最大值和最小值，平均值和总和
*/

public class HW01 {
    public static void main(String[] args) {
        int[][] exm = new int[][]{
                {8, 3, 6, 12, 0, 9},
                {7, 15, 4, 5, 8, 10, 11},
                {13, 1, 1}
        };
        findMax(exm);
        findMin(exm);
        findAverage(exm);
    }

    public static void findMax(int[][] exm) {
        int max = exm[0][0];
        for (int[] ints : exm) {
            for (int anInt : ints) {
                if (max < anInt)
                    max = anInt;
            }
        }
        System.out.println("最大值为："+max);
    }

    public static void findMin(int[][] exm) {
        int min = exm[0][0];
        for (int[] ints : exm) {
            for (int anInt : ints) {
                if (min > anInt)
                    min = anInt;
            }
        }
        System.out.println("最小值为："+min);
    }

    public static void findAverage(int[][] exm) {
        int sum = exm[0][0];
        for (int[] ints : exm) {
            for (int anInt : ints)
                sum += anInt;
        }
        int lens=0;
        for (int[] ints : exm) lens += ints.length;
        System.out.println( "平均值为：" + (double)sum / lens);
        System.out.println("总和为："+sum);
    }
}