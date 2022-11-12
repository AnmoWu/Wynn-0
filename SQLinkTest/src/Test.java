import java.sql.*;
public class Test {
    public static void main(String[] args) {
        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//固定
            System.out.println("加载驱动成功！");
            //2.连接
            //connection= null;//连接对象（注意与java不同，创建对象不用new）
            String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=master";//ip地址、端口、数据库名
            Connection connection= DriverManager.getConnection(dbURL, "AllForIDEA", "123456");
            System.out.println("连接数据库成功！");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }
    }
}