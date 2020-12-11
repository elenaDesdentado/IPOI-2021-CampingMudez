package presentacion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class MonitorRenderer implements ListCellRenderer {
	
	private Color colorSeleccionadoFondo = new Color(192, 196, 193);

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel renderer = (JPanel) value;
        renderer.setBackground(isSelected ? colorSeleccionadoFondo : list.getBackground());
        return renderer;
    }
}