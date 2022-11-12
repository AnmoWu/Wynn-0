import java.awt.*;
import javax.swing.*;

public class ColorListRenderer extends JCheckBox implements ListCellRenderer<Object>{
    Color[] colors = {Color.BLACK,Color.RED, Color.GREEN, Color.BLUE,Color.WHITE,Color.lightGray,
            Color.GRAY,Color.darkGray,Color.PINK,Color.ORANGE,Color.YELLOW,Color.MAGENTA,Color.CYAN};

    public Component getListCellRendererComponent(JList<?>jlist, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        this.setText(value.toString());
        this.setFont(new Font(value.toString(), Font.BOLD, 16));
        if(index != -1) {
            this.setForeground(colors[index]);
        }
        this.setSelected(isSelected);
        this.setBackground(isSelected ? Color.lightGray: Color.WHITE);
        return this;
    }
}

