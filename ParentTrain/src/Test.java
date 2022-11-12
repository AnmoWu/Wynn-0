import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test extends JFrame implements ActionListener, MouseListener{
        private JTextArea text;// 文本内容
        private JComboBox comboxName, comboxSize;// 字体名称，字体大小
        private JCheckBox chkBold, chkItalic;// 粗体，斜体
        private JRadioButton radioColor[]; // 颜色单选按钮数组
        private String colorStr[]={"黑","红","绿","蓝"};
        private JButton btncolor;
        private JCheckBoxMenuItem[] chkMenuItems;
        private Font font=null;
        private JRadioButtonMenuItem[] radiobtnColor;
        JPopupMenu popMenu;
        public Test()  {
            super("文本编辑器");
            Dimension dim=getToolkit().getScreenSize();
            this.setBounds(dim.width/4, dim.height/4, dim.width/2, dim.height/2);
            text=new JTextArea("Welcome 欢迎");
            this.getContentPane().add(new JScrollPane(text));
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JToolBar toolbar=new JToolBar();//工具栏
            this.getContentPane().add(toolbar,BorderLayout.NORTH);

            GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();//添加本地的字体
            String[] fontsName=ge.getAvailableFontFamilyNames();
            comboxName=new JComboBox(fontsName);
            comboxName.addActionListener(this);//事件监听1
            toolbar.add(comboxName);
            String sizeStr[]={"20", "30", "40", "50", "60", "70","80"};
            comboxSize=new JComboBox(sizeStr);
            comboxSize.addActionListener(this);//事件监听2
            comboxSize.setEditable(true);
            toolbar.add(comboxSize);
//Icon ic=new ImageIcon("F:\\myEclipse\\qq.jpg");
//chkBold=new JCheckBox("粗体",ic);
            chkBold=new JCheckBox("粗体");
            chkBold.setActionCommand("bold");
            chkBold.addActionListener(this);//事件监听3
            toolbar.add(chkBold);
            chkItalic = new JCheckBox("斜体");
            chkItalic.setActionCommand("italic");
            chkItalic.addActionListener(this);//事件监听4
            toolbar.add(chkItalic);
            ButtonGroup group=new ButtonGroup();

            radioColor=new JRadioButton[colorStr.length];
            for(int i=0;i<colorStr.length;i++){
                radioColor[i]=new JRadioButton(colorStr[i]);
                group.add(radioColor[i]);
                toolbar.add(radioColor[i]);
                radioColor[i].setActionCommand(colorStr[i]);
                radioColor[i].addActionListener(this);//事件监听
            }
            radioColor[0].setSelected(true);
//设置菜单栏
            addMyMenu();
//右击快捷菜单2
            popMenu=new JPopupMenu();
            String menuitemsStr[]={"复制","剪切","粘贴"};
            JMenuItem menupopitem[]=new JMenuItem[menuitemsStr.length];
            for(int i=0;i<menuitemsStr.length;i++){
                menupopitem[i]=new JMenuItem(menuitemsStr[i]);
                popMenu.add(menupopitem[i]);
                menupopitem[i].addActionListener(this);
            }
            text.add(popMenu);
            text.addMouseListener(this);
//快捷菜单7 ----为菜单项设置快捷键
            menupopitem[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
            menupopitem[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
            menupopitem[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
            this.setVisible(true);
        }

        private void addMyMenu() {
//菜单栏
            JMenuBar menubar=new JMenuBar();
            this.setJMenuBar(menubar);
            String menuStr[]={"文件", "编辑", "帮助"};
            JMenu menu[]=new JMenu[menuStr.length];
            for(int i=0;i<menuStr.length;i++){
                menu[i]=new JMenu(menuStr[i]);
                menubar.add(menu[i]);
            }

//菜单1
            JMenuItem menuFileOpen=new JMenuItem("打开");
            menu[0].add(menuFileOpen);
            menu[0].addSeparator();
            JMenuItem menuFileSave=new JMenuItem("保存");
            menu[0].add(menuFileSave);
            menu[0].addSeparator();
            JMenuItem menuFileClose=new JMenuItem("关闭");
            menuFileClose.addActionListener(this);//事件监听
            menuFileClose.setActionCommand("close");
            menu[0].add(menuFileClose);
            menuFileClose.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_F4,InputEvent.CTRL_MASK));
//menuFileClose.setAccelerator(KeyStroke.getKeyStroke('T'));
//菜单2：编辑
            JMenu menuStyle=new JMenu("字形");
            menu[1].add(menuStyle);
            String styleStr[] = {"粗体","斜体"};
            chkMenuItems=new JCheckBoxMenuItem[styleStr.length];
            for(int i=0;i<styleStr.length;i++){
                chkMenuItems[i]=new JCheckBoxMenuItem(styleStr[i]);
                menuStyle.add(chkMenuItems[i]);
            }
            chkMenuItems[0].setActionCommand("bold");
            chkMenuItems[0].addActionListener(this);
            chkMenuItems[1].setActionCommand("italic");
            chkMenuItems[1].addActionListener(this);
            JMenu menuColor=new JMenu("颜色");
            menu[1].add(menuColor);
            radiobtnColor =new JRadioButtonMenuItem[colorStr.length];
            ButtonGroup group=new ButtonGroup();
            for(int i=0;i<colorStr.length;i++){
                radiobtnColor[i]=new JRadioButtonMenuItem(colorStr[i]);
                group.add(radiobtnColor[i]);
                menuColor.add(radiobtnColor[i]);
                radiobtnColor[i].setActionCommand(colorStr[i]);
                radiobtnColor[i].addActionListener(this);
            }
            radiobtnColor[0].setSelected(true);
        }

        private boolean boo=false,state1,state2;
        String str="";
        public void actionPerformed(ActionEvent e) {
            if(boo&&e.getSource()==comboxSize){
                boo=false;
                return;
            }
            if(e.getSource() instanceof JComboBox ||
                    e.getSource() instanceof JCheckBox  ){
                String fontName = (String) comboxName.getSelectedItem();
                int fontSize=0;
                String strSize=(String)comboxSize.getSelectedItem();
                try {
                    fontSize=Integer.parseInt(strSize);
                } catch (NumberFormatException e1) {
                    String message="\""+strSize+"不能换成整数";
                    JOptionPane.showMessageDialog(this, message);
                    if(!strSize.equals(str)){
                        str=strSize;
                        boo=true;

                    }
                    return;

                }

                int style=changeStyle(e);
                font=text.getFont();
/*int style = font.getStyle();
 if(chkBold.isSelected()){
style=Font.BOLD;
state1=true;
chkMenuItems[0].setSelected(state1);
}else{
state1=false;
chkMenuItems[0].setSelected(state1);
}
if(chkItalic.isSelected()){
style=font.ITALIC;
System.out.println("dasd");
}else{
style=style^2;
}*/
                font =new Font(fontName, style, fontSize);
                text.setFont(font);
            }
            if (e.getSource() instanceof JMenuItem ||e.getSource() instanceof JRadioButton){
                Color c=setcolor(e);
                text.setForeground(c);
                if(e.getActionCommand().equalsIgnoreCase("bold") ||
                        e.getActionCommand().equalsIgnoreCase("italic")  ){
                    int style = changeStyle(e); //调用所抽取的方法
                    font = new Font(text.getFont().getName(), style, text.getFont().getSize());
                    text.setFont(font);
                }
                if(e.getActionCommand().equalsIgnoreCase("close")){
                    int i=JOptionPane.showConfirmDialog(this,"真的要退出吗？");
                    if(i==JOptionPane.NO_OPTION){
                        System.out.println("s ");
                        System.exit(0);
                    }
                    if(i==JOptionPane.CANCEL_OPTION){
                        return;
                    }
                    if(i==JOptionPane.OK_OPTION){
                        System.exit(0);
                    }
                }
//快捷菜单6  ----菜单项的响应动作
                if(e.getActionCommand().equals("剪切")){
                    text.cut();
                }
                if(e.getActionCommand().equals("复制")){
                    text.copy();
                }
                if(e.getActionCommand().equals("粘贴")){
                    text.paste();
                }
            }
            if (e.getSource()==comboxSize){
                String strSize = (String) comboxSize.getSelectedItem();
                int size = Integer.parseInt(strSize);
                int i = 0, n = comboxSize.getItemCount();
                while(i<n){
                    int iSize=Integer.parseInt((String)comboxSize.getItemAt(i));
                    if(size>iSize){
                        i++;
                    }else if(size==iSize){
                        return;
                    }else{
                        break;
                    }
                }
                comboxSize.insertItemAt(strSize, i);


            }


/*if(chkMenuItems[0].isSelected()){
int fontSize=0;
String strSize=(String)comboxSize.getSelectedItem();
fontSize=Integer.parseInt(strSize);
text.setFont(new Font(text.getName(),Font.BOLD,fontSize));
System.out.println(fontSize);
state1=true;
chkBold.setSelected(state1);
}else{
int fontSize=0;
String strSize=(String)comboxSize.getSelectedItem();
fontSize=Integer.parseInt(strSize);
text.setFont(new Font(text.getName(),Font.PLAIN,fontSize));
state1=false;
chkBold.setSelected(state1);
}*/



        }

        private Color setcolor(ActionEvent e) {
            Color color=null;
            if(e.getActionCommand().equalsIgnoreCase("黑")){
                color=Color.black;
            }
            if(e.getActionCommand().equalsIgnoreCase("红")){
                color=Color.red;
            }
            if(e.getActionCommand().equalsIgnoreCase("绿")){
                color=new Color(0, 255, 0);
            }
            if(e.getActionCommand().equalsIgnoreCase("蓝")){
                color=new Color(0,0,255);
            }
//  if (e.getSource() == radioColor[0]) {
//  color = new Color(0, 0, 0);
//  }
//  if (e.getSource() == radioColor[1]) {
//  color = new Color(255, 0, 0);
//  }
//  if (e.getSource() == radioColor[2]) {
//  color = new Color(0, 255, 0);
//  }
//  if (e.getSource() == radioColor[3]) {
//  color = new Color(0, 0, 255);
//  }
            common2(e);
            return color;
        }

        private void common2(ActionEvent e) {
            if(e.getSource() instanceof JRadioButton||e.getSource() instanceof JRadioButtonMenuItem){
                for(int i=0;i<radioColor.length;i++){
                    if(e.getActionCommand().equalsIgnoreCase(colorStr[i])){
                        radioColor[i].setSelected(true);
                        radiobtnColor[i].setSelected(true);
                    }
                }
            }
//  for(int i=0;i<radioColor.length;i++){
//    if(radioColor[i].isSelected()){
//   radiobtnColor[i].setSelected(true);
//    }else if(!radioColor[i].isSelected()){
//    radiobtnColor[i].setSelected(false);
//    }else if(radiobtnColor[i].isSelected()){
//    radioColor[i].setSelected(true);
//    }else if(!radiobtnColor[i].isSelected()){
//    radioColor[i].setSelected(false);
//    }
//  }



        }

        private int changeStyle(ActionEvent e) {
            int style=text.getFont().getStyle();
            if(e.getActionCommand().equalsIgnoreCase("bold")){
                style^=1;
            }
            if(e.getActionCommand().equalsIgnoreCase("italic")){
                style^=2;
            }
            common(style);
            return style;
        }

        private void common(int style) {
            state1 = ( (style & 1) ==1 );  // 1 0  ** 00
            state2 = ( (style & 2) ==2 ); // 2 0
            chkMenuItems[0].setSelected(state1);
            chkBold.setSelected(state1);
            chkMenuItems[1].setSelected(state2);
            chkItalic.setSelected(state2);
//  //点击图标按钮时，用按钮的状态去 同步 菜单项
//  chkMenuItems[0].setSelected( chkBold.isSelected() );
//  //点击菜单项时，用菜单项状态去 同步 按钮的状态
//  chkBold.setSelected( chkMenuItems[0].isSelected() );
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getModifiers()==MouseEvent.BUTTON3_MASK){
                popMenu.show(text, e.getX(), e.getY());
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
// TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub

        }

        public static void main(String[] args) {
            new Test();
        }
    }
