package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelFormularioReservaBungalow extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JProgressBar progressBar;
	private JLabel lblFoto;
	private JLabel lblBungalow;
	private JTextArea tADescripcion;
	private JLabel lblValoracionCliente;
	private JLabel lblEstrellas;
	private JCalendar calendar;
	private JLabel lblServiciosOfertados;
	private JCheckBox chckbxGolf;
	private JCheckBox chckbxCarbon;
	private JCheckBox chckbxGarage;
	private JCheckBox chckbxCama;
	private JCheckBox chckbxLimpieza;
	private JCheckBox chckbxLavavajillas;
	private JButton btnSiguiente;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblEuros;
	private JLabel lblNombre;

	/**
	 * Create the panel.
	 */
	public PanelFormularioReservaBungalow() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 157, 31, 0, 0, 0, 42, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridwidth = 7;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		panel.add(progressBar, gbc_progressBar);
		
		lblNombre = new JLabel("");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		lblFoto = new JLabel("New label");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridwidth = 2;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 3;
		panel.add(lblFoto, gbc_lblFoto);
		
		lblBungalow = new JLabel("Bungalow: ");
		GridBagConstraints gbc_lblBungalow = new GridBagConstraints();
		gbc_lblBungalow.anchor = GridBagConstraints.EAST;
		gbc_lblBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_lblBungalow.gridx = 3;
		gbc_lblBungalow.gridy = 2;
		panel.add(lblBungalow, gbc_lblBungalow);
		
		calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 7;
		gbc_calendar.gridy = 3;
		panel.add(calendar, gbc_calendar);
		
		tADescripcion = new JTextArea();
		GridBagConstraints gbc_tADescripcion = new GridBagConstraints();
		gbc_tADescripcion.gridheight = 2;
		gbc_tADescripcion.gridwidth = 3;
		gbc_tADescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_tADescripcion.fill = GridBagConstraints.BOTH;
		gbc_tADescripcion.gridx = 3;
		gbc_tADescripcion.gridy = 3;
		panel.add(tADescripcion, gbc_tADescripcion);
		
		lblValoracionCliente = new JLabel("Valoración media de los clientes:");
		GridBagConstraints gbc_lblValoracionCliente = new GridBagConstraints();
		gbc_lblValoracionCliente.anchor = GridBagConstraints.EAST;
		gbc_lblValoracionCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblValoracionCliente.gridx = 3;
		gbc_lblValoracionCliente.gridy = 5;
		panel.add(lblValoracionCliente, gbc_lblValoracionCliente);
		
		lblEstrellas = new JLabel("");
		GridBagConstraints gbc_lblEstrellas = new GridBagConstraints();
		gbc_lblEstrellas.gridwidth = 2;
		gbc_lblEstrellas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstrellas.gridx = 4;
		gbc_lblEstrellas.gridy = 5;
		panel.add(lblEstrellas, gbc_lblEstrellas);
		
		lblServiciosOfertados = new JLabel("Servicios ofertados:");
		GridBagConstraints gbc_lblServiciosOfertados = new GridBagConstraints();
		gbc_lblServiciosOfertados.anchor = GridBagConstraints.WEST;
		gbc_lblServiciosOfertados.gridwidth = 3;
		gbc_lblServiciosOfertados.insets = new Insets(0, 0, 5, 5);
		gbc_lblServiciosOfertados.gridx = 1;
		gbc_lblServiciosOfertados.gridy = 7;
		panel.add(lblServiciosOfertados, gbc_lblServiciosOfertados);
		
		chckbxGolf = new JCheckBox("Acceso pista de golf (50€)");
		GridBagConstraints gbc_chckbxGolf = new GridBagConstraints();
		gbc_chckbxGolf.anchor = GridBagConstraints.WEST;
		gbc_chckbxGolf.gridwidth = 3;
		gbc_chckbxGolf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGolf.gridx = 1;
		gbc_chckbxGolf.gridy = 8;
		panel.add(chckbxGolf, gbc_chckbxGolf);
		
		chckbxCarbon = new JCheckBox("Bolsa de carbón (5€)");
		GridBagConstraints gbc_chckbxCarbon = new GridBagConstraints();
		gbc_chckbxCarbon.anchor = GridBagConstraints.WEST;
		gbc_chckbxCarbon.gridwidth = 3;
		gbc_chckbxCarbon.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCarbon.gridx = 1;
		gbc_chckbxCarbon.gridy = 9;
		panel.add(chckbxCarbon, gbc_chckbxCarbon);
		
		chckbxGarage = new JCheckBox("Acceso a garaje (15€)");
		GridBagConstraints gbc_chckbxGarage = new GridBagConstraints();
		gbc_chckbxGarage.anchor = GridBagConstraints.WEST;
		gbc_chckbxGarage.gridwidth = 3;
		gbc_chckbxGarage.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGarage.gridx = 1;
		gbc_chckbxGarage.gridy = 10;
		panel.add(chckbxGarage, gbc_chckbxGarage);
		
		chckbxCama = new JCheckBox("Cama extra (10€)");
		GridBagConstraints gbc_chckbxCama = new GridBagConstraints();
		gbc_chckbxCama.anchor = GridBagConstraints.WEST;
		gbc_chckbxCama.gridwidth = 3;
		gbc_chckbxCama.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCama.gridx = 1;
		gbc_chckbxCama.gridy = 11;
		panel.add(chckbxCama, gbc_chckbxCama);
		
		lblPrecio = new JLabel("Precio por noche:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 7;
		gbc_lblPrecio.gridy = 11;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setMinimumSize(new Dimension(0, 20));
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 8;
		gbc_txtPrecio.gridy = 11;
		panel.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		lblEuros = new JLabel("€");
		GridBagConstraints gbc_lblEuros = new GridBagConstraints();
		gbc_lblEuros.anchor = GridBagConstraints.WEST;
		gbc_lblEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblEuros.gridx = 9;
		gbc_lblEuros.gridy = 11;
		panel.add(lblEuros, gbc_lblEuros);
		
		chckbxLimpieza = new JCheckBox("Servicio de limpieza (15€)");
		GridBagConstraints gbc_chckbxLimpieza = new GridBagConstraints();
		gbc_chckbxLimpieza.anchor = GridBagConstraints.WEST;
		gbc_chckbxLimpieza.gridwidth = 3;
		gbc_chckbxLimpieza.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLimpieza.gridx = 1;
		gbc_chckbxLimpieza.gridy = 12;
		panel.add(chckbxLimpieza, gbc_chckbxLimpieza);
		
		chckbxLavavajillas = new JCheckBox("Lavavajillas (10€)");
		GridBagConstraints gbc_chckbxLavavajillas = new GridBagConstraints();
		gbc_chckbxLavavajillas.anchor = GridBagConstraints.WEST;
		gbc_chckbxLavavajillas.gridwidth = 3;
		gbc_chckbxLavavajillas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLavavajillas.gridx = 1;
		gbc_chckbxLavavajillas.gridy = 13;
		panel.add(chckbxLavavajillas, gbc_chckbxLavavajillas);
		
		btnSiguiente = new JButton("Siguiente");
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridwidth = 2;
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSiguiente.gridx = 8;
		gbc_btnSiguiente.gridy = 13;
		panel.add(btnSiguiente, gbc_btnSiguiente);

	}
}
