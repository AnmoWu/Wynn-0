import java.io.*;

public class Move {
    public static void main(String[] args)throws IOException  {
        File file1=new File("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\Copy\\test.txt");
        FileInputStream fis=new FileInputStream(file1);
        FileOutputStream fos=new FileOutputStream("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\Move\\test.txt");
        byte[] lsy=new byte[fis.available()];//定义字节数组用来当作缓冲区
        fis.read(lsy);//将文件以字节流形式读入缓冲区字节数组
        fos.write(lsy);//从缓冲区字节数组中以字节流形式取出
        fos.close();
        fis.close();
        file1.delete();//删除源文件
        File file2=new File("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\Move\\test.txt");
        if(file2.exists()){
            System.out.println("文件成功移动到指定路径下");
        }
        else{
            System.out.println("文件移动失败");
        }

    }
}
