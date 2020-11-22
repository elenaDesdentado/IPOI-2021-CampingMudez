package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelFormularioActividadesInicio extends JPanel {
	private JLabel lblEspacioVacio;
	private JLabel lblMensajeEspacioVacio;
	
	private Color colorFondo = new Color(255, 255, 255);

	/**
	 * Create the panel.
	 */
	public PanelFormularioActividadesInicio() {
		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{419, 0};
		gridBagLayout.rowHeights = new int[]{57, 234, 166, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblEspacioVacio = new JLabel("");
		lblEspacioVacio.setIcon(new ImageIcon(PanelFormularioActividadesInicio.class.getResource("/presentacion/emptyState.png")));
		GridBagConstraints gbc_lblEspacioVacio = new GridBagConstraints();
		gbc_lblEspacioVacio.anchor = GridBagConstraints.NORTH;
		gbc_lblEspacioVacio.insets = new Insets(0, 0, 5, 0);
		gbc_lblEspacioVacio.gridx = 0;
		gbc_lblEspacioVacio.gridy = 1;
		add(lblEspacioVacio, gbc_lblEspacioVacio);
		
		lblMensajeEspacioVacio = new JLabel("Oops, ¡no encontramos nada aquí! \nPor favor elige un elemento de la lista.");
		lblMensajeEspacioVacio.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblMensajeEspacioVacio = new GridBagConstraints();
		gbc_lblMensajeEspacioVacio.gridx = 0;
		gbc_lblMensajeEspacioVacio.gridy = 2;
		add(lblMensajeEspacioVacio, gbc_lblMensajeEspacioVacio);

	}

}
