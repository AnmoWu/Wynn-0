import java.awt.*;
import javax.swing.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class HelloWorld extends JFrame {
    private JMenuBar menubar;
    private JMenu menu1;
    private JMenuItem m11;
    private JMenuItem m12;
    private JMenu menu2;
    private JMenuItem m21;
    private JMenuItem m22;
    private JMenuItem m23;
    private JMenuItem m24;

    private JButton b1;
    private JButton b2;
    private JToolBar tool;

    public HelloWorld() {
        super();
        this.setSize(400,300);
        this.setTitle("HelloWorld");
        this.setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit= getDefaultToolkit();
        Image icon = getDefaultToolkit().getImage("D:\\Java\\MySwing\\src\\苗期管理-计划详情.png");
        this.setIconImage(icon);
        //begin
        //创建系统菜单
        menu1 = new JMenu("系统");
        m11= new JMenuItem("用户管理");
        m12 = new JMenuItem();
        m12.setText("退出");
        menu1.add(m11);
        menu1.add(m12);

        //创建“数据操作菜单”菜单
        menu2 = new JMenu("数据操作");
        m21 = new JMenuItem("查询");
        m22 = new JMenuItem("添加");
        m23 = new JMenuItem("修改");
        m24 = new JMenuItem("删除");
        menu2.add(m21);
        menu2.add(m22);
        menu2.add(m23);
        menu2.add(m24);

        //创建菜单栏，添加“系统”菜单、“数据操作”菜单
        menubar = new JMenuBar();
        menubar.add(menu1);
        menubar.add(menu2);

        //添加菜单栏到窗口
        setJMenuBar(menubar);

        //创建“查询”、“添加”按钮
        b1 = new JButton("查询");
        b1.setToolTipText("查询");
        b1.setIcon(new ImageIcon("D:\\Java\\MySwing\\src\\查询.png"));
        b1.setFocusable(false);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setVerticalAlignment(SwingConstants.BOTTOM);
        b2 = new JButton("添加");
        b2.setToolTipText("添加");
        b2.setIcon(new ImageIcon("D:\\Java\\MySwing\\src\\增加.png"));
        b2.setFocusable(false);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setVerticalAlignment(SwingConstants.BOTTOM);


        //创建工具栏，添加按钮
        tool=new JToolBar();
        tool.add(b1);
        tool.add(b2);
        tool.setRollover(true);

        //添加工具栏
        getContentPane().add(tool,BorderLayout.PAGE_START);

        //end
    }

    public static void main(String[] args) {
        HelloWorld w = new HelloWorld();
        w.setVisible(true);
    }

}
