import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {
        //封装好需要复制的文件原路径
        FileInputStream fis=new FileInputStream("D:\\Java\\Reflect\\src\\test.txt");
        //将文件复制到指定路径下
        FileOutputStream fos=new FileOutputStream("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\Copy\\test.txt");
        byte[] lsy=new byte[fis.available()];//定义字节数组用来当作缓冲区
        fis.read(lsy);//将文件以字节流形式读入缓冲区字节数组
        fos.write(lsy);//从缓冲区字节数组中以字节流形式取出
        fos.close();
        fis.close();
        File file=new File("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\Copy\\test.txt");
        if(file.exists()){
            System.out.println("文件成功复制到指定路径下");
        }
        else{
            System.out.println("文件复制失败");
        }
    }
}
