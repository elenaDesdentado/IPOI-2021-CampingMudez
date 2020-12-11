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
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;

public class PanelFormularioActividadesInicio extends JPanel {
	private JLabel lblEspacioVacio;
	private JLabel lblMensajeEspacioVacio;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Component verticalStrut;

	/**
	 * Create the panel.
	 */
	public PanelFormularioActividadesInicio() {
		setBackground(colorFondo);
		setLayout(new GridLayout(3, 1, 0, 0));
		
		verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
		
		lblEspacioVacio = new JLabel("");
		lblEspacioVacio.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspacioVacio.setIcon(new ImageIcon(PanelFormularioActividadesInicio.class.getResource("/presentacion/emptyState.png")));
		add(lblEspacioVacio);
		
		lblMensajeEspacioVacio = new JLabel("Oops, ¡no encontramos nada aquí! \nPor favor elige un elemento de la lista.");
		lblMensajeEspacioVacio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeEspacioVacio.setForeground(Color.BLACK);
		add(lblMensajeEspacioVacio);

	}

}
