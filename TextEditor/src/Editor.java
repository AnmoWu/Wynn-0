import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.UIManager.getColor;

public class Editor extends JFrame implements ActionListener,MouseListener{

    private JComboBox<String> combox_name;
    protected JComboBox<Integer> combox_size;
    private JCheckBox[] checkbox;
    private JComboBox combox_color;
    private String[] colors = {"black","red","green","blue","white","lightgrey","grey",
    "darkgrey","pink","orange","yellow","magenta","cyan"};
    protected JTextArea  text;
    protected JPopupMenu popupmenu;
    protected JMenu[] menus;
    protected JToolBar toolBar;

    public Editor() {
        super("文本编辑器");
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit= getDefaultToolkit();
        Image icon = getDefaultToolkit().getImage("D:\\Java\\TextEditor\\src\\符号-文本.png");
        this.setIconImage(icon);

        this.toolBar = new JToolBar();
        this.getContentPane().add(this.toolBar, "North");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontsName = ge.getAvailableFontFamilyNames();
        this.combox_name = new JComboBox<>(fontsName);
        this.combox_name.setRenderer(new FontNameListRenderer());
        this.combox_name.addActionListener(this);
        this.toolBar.add(this.combox_name);

        Integer[] sizes = {20, 30, 40, 50, 60, 70};
        this.combox_size = new JComboBox<>(sizes);
        this.combox_size.setEditable(true);
        this.combox_size.setRenderer(new SizeListRenderers());
        this.combox_size.addActionListener(this);
        this.toolBar.add(this.combox_size);

        String[] stylestr = {"粗体", "斜体"};
        this.checkbox = new JCheckBox[stylestr.length];
        for (int i = 0; i < stylestr.length; i++) {
            this.toolBar.add(this.checkbox[i] = new JCheckBox(stylestr[i]));
            this.checkbox[i].addActionListener(this);
        }

        this.combox_color = new JComboBox<>(this.colors);
        //this.radios.setEditable(true);
        this.combox_color.setRenderer(new ColorListRenderer());
        this.combox_color.addActionListener(this);
        this.toolBar.add(this.combox_color);

        JButton bopen = new JButton("打开");
        bopen.addActionListener(this);
        this.toolBar.add(bopen);
        JButton bsave = new JButton("保存");
        bsave.addActionListener(this);
        this.toolBar.add(bsave);

        this.text = new JTextArea("Welcome~");
        this.text.addMouseListener(this);
        this.getContentPane().add(new JScrollPane(this.text));
        this.text.setForeground(Color.BLACK);
        this.addMenu();
        this.setVisible(true);
    }

    private void addMenu () {
        String[] menustr = {"文件", "编辑", "插入", "格式", "工具", "窗口", "帮助"};
        String[][] menuItems = {{"新建", "打开", "保存", "另存为", "|", "退出"},
                {"撤销", "恢复", "|", "剪切", "复制", "粘贴", "查找", "替换"},
                {"日期", "文本"}, {"字体"}, {"字数统计", "自动更正", "拼写检查"}, {}, {}};
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        this.menus = new JMenu[menustr.length];
        JMenuItem[][] menuitems = new JMenuItem[menuItems.length][];
        for (int i = 0; i < menuItems.length; i++) {
            this.menus[i] = new JMenu(menustr[i]);
            menuBar.add(this.menus[i]);
            menuitems[i] = new JMenuItem[menuItems[i].length];
            for (int j = 0; j < menuItems[i].length; j++) {
                if (menuItems[i][j].equals("|"))
                    this.menus[i].addSeparator();
                else {
                    menuitems[i][j] = new JMenuItem(menuItems[i][j]);
                    this.menus[i].add(menuitems[i][j]);
                    menuitems[i][j].addActionListener(this);
                }
            }
        }
        JMenu menu_styles = new JMenu("字形");
        menus[3].add(menu_styles);
        String[] stylestr = {"粗体","斜体"};
        JCheckBoxMenuItem[] cbmenus = new JCheckBoxMenuItem[stylestr.length];
        for (int i = 0; i < stylestr.length; i++) {
            cbmenus[i] = new JCheckBoxMenuItem(stylestr[i]);
            menu_styles.add(cbmenus[i]);
            cbmenus[i].addActionListener(this);
        }
        //快捷菜单
        this.popupmenu = new JPopupMenu();
        String[] menucut = {"剪切", "复制", "粘贴"};
        JMenuItem[] popupMenu = new JMenuItem[menucut.length];
        for (int i = 0; i < popupMenu.length; i++) {
            popupMenu[i] = new JMenuItem(menucut[i]);
            this.popupmenu.add(popupMenu[i]);
            popupMenu[i].addActionListener(this);
        }
        popupMenu[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        popupMenu[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        popupMenu[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        this.text.add(this.popupmenu);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JMenuItem) {
            switch (event.getActionCommand()) {
                case "退出":
                    if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？", "确认",
                            JOptionPane.YES_NO_OPTION) == 0)
                        System.exit(0);
                case "剪切":
                    this.text.cut();
                    break;
                case "复制":
                    this.text.copy();
                    break;
                case "粘贴":
                    this.text.paste();
            }
        }
        else if (event.getSource() instanceof JComboBox<?> || event.getSource() instanceof JCheckBox) {
            int size = 0;
            String fontname = (String) this.combox_name.getSelectedItem();
            Object obj = this.combox_size.getSelectedItem();
            if(obj != null){
                try{
                    if(obj instanceof Integer)
                        size = (Integer) obj;
                    else if(obj instanceof String)
                        size = Integer.parseInt((String)obj);
                    if(size<20||size>200)
                        try {
                            throw new Exception(size+"字号超出范围。");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    java.awt.Font font =this.text.getFont();
                    int style = font.getStyle();
                    switch (event.getActionCommand()) {
                        case "粗体" -> style ^= 1;
                        case "斜体" -> style ^= 2;
                    }
                    this.text.setFont(new Font(fontname, style,size));
                    insert(this.combox_size,size);
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage()+"不能转换为整数。");
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(this,ex.toString());
                }
            }

            Color colorset = Color.BLACK;
            String fontcolor =(String)this.combox_color.getSelectedItem();
            Object colorobj = this.combox_color.getSelectedItem();
            if(colorobj!=null){
                try{
                    if(colorobj instanceof Color)
                        colorset = (Color)colorobj;
                    else if (colorobj instanceof String)
                        colorset=getColor(colorobj);
                    if(ColorExists(fontcolor)){
                        try {
                            throw new Exception(size+"颜色不存在。");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    this.text.setForeground(colorset);
                }
                catch (ClassCastException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage()+"颜色输入错误。");
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(this,ex.toString());
                }
            }
        }
    }

    public <T extends Comparable<? super T>> void insert(JComboBox<T> combox,T x){
        int begin = 0,end = combox.getItemCount()-1,mid;
        while(begin <= end){
            mid = (begin+end)/2;
            if(x.compareTo(combox.getItemAt(mid))==0)
                return;
            if(x.compareTo(combox.getItemAt(mid))<0)
                end = mid-1;
            else
                begin = mid+1;
        }
        combox.insertItemAt(x,begin);
    }

    public boolean ColorExists(String colorname){
        for (String color : colors) {
            return colorname.equals(color);
        }
        return false;
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==3)
            this.popupmenu.show(this.text,e.getX(),e.getY());
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public static void main(String[] args) {
        new Editor();
    }
}
