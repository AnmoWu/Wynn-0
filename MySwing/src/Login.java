import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class Login extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Login()
    {
        super();
        this.setSize(300, 200);
        this.setTitle("登录");
        this.setLocationRelativeTo(getOwner());//居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit= getDefaultToolkit();
        Image icon = getDefaultToolkit().getImage("D:\\Java\\MySwing\\src\\苗期管理-计划详情.png");
        this.setIconImage(icon);

        //设置组件布局--3行2列表格
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(3, 2));

        //begin
        //添加“用户名”、“密码”
        cont.add(new JLabel("用户名 /uesrname"));
        username = new JTextField(10);
        cont.add(username);
        cont.add(new JLabel("密码 /password"));
        password = new JPasswordField();
        cont.add(password);

        //添加“登录”、“注册”按钮
        login = new JButton( "登录");
        login.setIcon(new ImageIcon("D:\\Java\\MySwing\\src\\登录.png"));
        register = new JButton( "注册");
        register.setIcon(new ImageIcon("D:\\Java\\MySwing\\src\\密码.png"));
        cont.add(login);
        cont.add(register);

        //注册监听器
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String pass = new String(password.getPassword());
                if (username.getText().equals("ding") && pass.equals("12345")) {
                    HelloWorld helloWorld = new HelloWorld();
                    helloWorld.setVisible(true);
                    dispose();
                } else
                    JOptionPane.showMessageDialog(null, "密码错误");
            }
        });
        //end
    }

    public static void main(String[] args) {
        Login w = new Login();
        w.setVisible(true);
    }

}
