import java.awt.*;
import javax.swing.*;

public class FontNameListRenderer extends JCheckBox implements ListCellRenderer<Object> {
    public Component getListCellRendererComponent(JList<?>jlist,Object value,int index,
                                         boolean isSelected,boolean cellHasFocus) {
        this.setText(value.toString());
        this.setFont(new Font(value.toString(),Font.BOLD,16));
        this.setSelected(isSelected);
        //this.setForeground(isSelected?Color.BLUE:Color.BLACK);
        this.setBackground(isSelected?Color.lightGray:Color.WHITE);
        return this;
    }
}
