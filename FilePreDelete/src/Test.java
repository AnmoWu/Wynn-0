import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\下载\\abUu7xjwh8GwozkQvUgm2MLmck - 副本");
        System.out.println(file.getAbsolutePath());
        File[] files = file.listFiles();
        //加上前缀
        /*for (File file1 : files) {
            String prefix = "0.";
            addPrefix("0.", file1);
        }*/
        //删除前缀
        for (File file1 : files) {
            String prefix = "10.";
            deletePrefix(prefix, file1);
        }
    }

    /*public static void addPrefix(String prefix, File file1) {
        String name = file1.getName();
        File file2 = new File(file1.getParent() + "\\" + prefix + name);
        file1.renameTo(file2);

    }*/

    public static void deletePrefix(String prefix, File file1) {
        int length = prefix.length();
        String name = file1.getName();
        File file2 = new File(file1.getParent() + "\\" + name.substring(length));
        file1.renameTo(file2);
    }
}

