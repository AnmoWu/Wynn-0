import java.io.*;

public class Writer {
    public static void main(String[] args) {
        String[] str= {"鸡声茅店月,","人迹板桥霜,","槲叶落山路,","枳花明驿墙。"};
        //File file=new File("src\\cc.txt");//我们在该类的位置创建一个新文件
        FileWriter f=null;//创建文件写入对象
        BufferedWriter f1=null;//创建字符流写入对象

        try {
            //这里把文件写入对象和字符流写入对象分开写了
            f=new FileWriter("src\\test.txt");
            f1=new BufferedWriter(f);
            //通过循环遍历上面的String 数组中的元素
            for (String s : str) {
                f1.write(s);//把String中的字符写入文件
                f1.newLine();//换行操作
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {//如果没有catch 异常，程序最终会执行到这里
            try {
                f1.close();
                f.close();//关闭文件
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }
}
