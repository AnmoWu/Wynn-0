import java.io.*;

public class Test{
    public static void main(String[] args) {
        File f1=new File("src\\test.txt");
        if(f1.exists()) {
            System.out.println("文件已经存在");
        }else {
            try {
                f1.createNewFile();
                System.out.println("文件创建成功");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("文件已经存在:"+f1.exists());
        System.out.println("文件名:"+f1.getName());
        System.out.println("路径:"+f1.getPath());
        System.out.println("绝对路径:"+f1.getAbsolutePath());
        System.out.println("是否为目录:"+f1.isDirectory());
        System.out.println("文件大小:"+f1.length());
    }
}