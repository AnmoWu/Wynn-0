import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class Register extends JFrame {
    private JTextField username;
    private JPasswordField password, passwordagain;
    private JRadioButton sexfemale, sexmale;
    private JPanel sex, birth, fav;
    private JTextField year;
    private JComboBox<Integer> month, day;
    private JCheckBox f1, f2, f3;
    private JButton register, cancel;
    private JTextArea remmond;
    private JScrollPane scroll;

    public Register(){
        super();
        this.setSize(500, 400);
        this.setTitle("Login");
        this.setLocationRelativeTo(getOwner());//居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit= getDefaultToolkit();
        Image icon = getDefaultToolkit().getImage("D:\\Java\\MySwing\\src\\苗期管理-计划详情.png");
        this.setIconImage(icon);

        //设置布局
        Container contain= getContentPane();
        contain.setLayout(new BoxLayout(contain, BoxLayout.Y_AXIS));

        //添加组件
        //begin
        JPanel cont= new JPanel(new GridLayout(6, 2));

        //用户名
        cont.add(new JLabel("用户名"));
        username= new JTextField(10);
        cont.add(username);

        //密码
        cont.add(new JLabel("密码"));
        password= new JPasswordField(10);
        cont.add(password);

        //二次验证
        cont.add(new JLabel("再输入一次密码"));
        passwordagain= new JPasswordField(10);
        cont.add(passwordagain);

        //性别
        cont.add(new JLabel("性别"));
        sexmale= new JRadioButton("男");
        sexfemale= new JRadioButton("女");
        JRadioButton sexmix = new JRadioButton("两者都不",true);
        ButtonGroup bg= new ButtonGroup();
        bg.add(sexmale);
        bg.add(sexfemale);
        bg.add(sexmix);
        sex= new JPanel(new GridLayout(1, 3));
        sex.add(sexmale);
        sex.add(sexfemale);
        sex.add(sexmix);
        cont.add(sex);

        //出生日期
        cont.add(new JLabel("出生日期"));
        year= new JTextField(4);
        month= new JComboBox<>();
        int i;
        for(i= 1; i<= 12; i++)
            month.addItem(i);
        day= new JComboBox<>();
        for(i= 1; i<= 31; i++)
            day.addItem(i);
        birth= new JPanel();
        birth.add(year);
        birth.add(new JLabel("-"));
        birth.add(month);
        birth.add(new JLabel("-"));
        birth.add(day);
        cont.add(birth);

        //爱好
        cont.add(new JLabel("爱好"));
        f1= new JCheckBox("运动");
        f2= new JCheckBox("看电影");
        f3= new JCheckBox("听音乐");
        fav= new JPanel();
        fav.add(f1);
        fav.add(f2);
        fav.add(f3);
        cont.add(fav);

        //简历
        JPanel cont1= new JPanel(new GridLayout(1, 2));
        cont1.add(new JLabel("简历"));
        remmond= new JTextArea(5, 10);
        scroll= new JScrollPane(remmond);
        cont1.add(scroll);

        //按钮
        JPanel cont2= new JPanel(new GridLayout(1, 2));
        register= new JButton("注册");
        register.setIcon(new ImageIcon("src\\注册.png"));
        cancel= new JButton("取消");
        cancel.setIcon(new ImageIcon("src\\取消.png"));
        cont2.add(register);
        cont2.add(cancel);

        //加入面板
        contain.add(cont);
        contain.add(cont1);
        contain.add(cont2);

        //注册监听器
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String pass = new String(password.getPassword());
                String passagain = new String(passwordagain.getPassword());
                if (passagain.equals(pass)) {
                    String s;
                    s = "用户名：" + username.getText() + "\n";
                    s += "密码：" + pass + "\n";
                    s += "性别：" + (sexmix.isSelected() ?sexmix.getText():(sexmale.isSelected() ? sexmale.getText() : sexfemale.getText())) + "\n";
                    s += "出生日期：" + year.getText() + "-" + (month.getSelectedIndex()+1) + "-" + (day.getSelectedIndex()+1) + "\n";
                    s += "爱好：" + (f1.isSelected() ? f1.getText() : "") + (f2.isSelected() ? f2.getText() : "")
                            + (f3.isSelected() ? f3.getText() : "") + "\n";
                    s += "简历：" + remmond.getText();
                    JOptionPane.showMessageDialog(null, s);
                }
                else
                    JOptionPane.showMessageDialog(null, "密码不一致！");
            }
        });
    }

    public static void main(String[] args) {
        Register w = new Register();
        w.setVisible(true);
    }



}
