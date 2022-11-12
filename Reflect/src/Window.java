import java.awt.*;
import java.awt.event.*;
import static java.awt.Toolkit.getDefaultToolkit;

public class Window {
    public static void main(String[] args) {
        Frame f = new Frame("File Manager");
        f.setBounds(400, 200, 600, 500);
        f.setLayout(new FlowLayout());

        Toolkit toolkit= getDefaultToolkit();
        Image icon = getDefaultToolkit().getImage("D:\\Java\\Reflect\\src\\文件夹文件.png");
        f.setIconImage(icon);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Button redButton = new Button("Red");
        Button greenButton = new Button("Green");
        Button buleButton = new Button("Blue");

        // 添加按钮
        f.add(redButton);
        f.add(greenButton);
        f.add(buleButton);

        // 对按钮添加鼠标的进入事件
        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.RED);
            }
        });

        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });

        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.GREEN);
            }
        });

        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });

        buleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.BLUE);
            }
        });

        buleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });

        f.setVisible(true);
    }
}