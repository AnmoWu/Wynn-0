import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.NumberFormat;

public class Dir {
    static int CountFile = 0;
    static int CountDir = 0;

    //格式化时间为 年月日 时分（y-year M-mouth d-date or day? H-hour m-minute)
    public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("C:\\Users\\lenovo>");
        String input = sc.nextLine();
        String path = input.substring(input.lastIndexOf(" ") + 1);  //读取输入中的绝对路径
        File file = new File(path);
        sc.close();
        dir(file, 0);  //递归遍历文件，输出信息（格式为win的dir命令）
        System.out.println(CountFile + "个文件");
        System.out.println(CountDir + "个文件夹");
    }

    static String getFormatString(String s) {
        int num = 12 - s.length();
        StringBuilder sb = new StringBuilder();
        if (num > 0)
            sb.append("".repeat(num + 1));
        return sb.append(s).toString();
    }

    static void dir(File file, int level) {
        FileComparator fc = new FileComparator();
        if (file.exists()) {
            if (file.isDirectory()) {
                CountDir++;
                for (int i = 0; i < level; i++)
                    System.out.print("    ");
                FilePrint(file);
                level++;
                File[] list = file.listFiles();
                if (list != null) {
                    for (File f : list)
                        dir(f, level);
                }
            }
            else if (file.isFile()) {
                CountFile++;
                for (int i = 0; i < level; i++)
                    System.out.print("    ");
                FilePrint(file);
            }
        }
    }

    static void FilePrint(File f) {
        String time = df.format(new Date(f.lastModified()));
        if (f.isDirectory())
            System.out.print(time + " <DIR>             ");
        else {
            System.out.print(time + "         ");
            System.out.printf("%-10s", getFormatString(NumberFormat.getInstance().format(f.length())));
        }
        System.out.println(" " + f.getName());
    }
}