import java.awt.*;
import javax.swing.*;

public class SizeListRenderers extends JCheckBox implements ListCellRenderer<Object>{
    Integer[] sizes = {20, 30, 40, 50, 60, 70};
    public Component getListCellRendererComponent(JList<?>jlist, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        this.setText(value.toString());
        if(index != -1) {
            this.setFont(new Font(value.toString(), Font.BOLD, sizes[index]));
        }
        this.setSelected(isSelected);
        this.setBackground(isSelected ? Color.lightGray : Color.WHITE);
        return this;
    }
}
