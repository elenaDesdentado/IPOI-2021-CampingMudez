package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ModeloIdiomaCB extends DefaultListCellRenderer {

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        ImageIcon icon = new ImageIcon((String) value);
        setIcon(icon);
        return this;
    }
}
