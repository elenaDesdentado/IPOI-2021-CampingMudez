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

public class PanelFormularioReservaParcela extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JProgressBar progressBar;
	private JLabel lblFoto;
	private JLabel lblParcela;
	private JTextArea tADescripcion;
	private JLabel lblValoracionCliente;
	private JLabel lblEstrellas;
	private JCalendar calendar;
	private JLabel lblServiciosOfertados;
	private JCheckBox chckbxGolf;
	private JCheckBox chckbxCorrienteElectrica;
	private JCheckBox chckbxParking;
	private JCheckBox chckbxWifi;
	private JCheckBox chckbxTiendaAcampada;
	private JCheckBox chckbxMascotas;
	private JButton btnSiguiente;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblEuros;
	private JLabel lblNombre;

	/**
	 * Create the panel.
	 */
	public PanelFormularioReservaParcela() {
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
		
		lblParcela = new JLabel("Parcela: ");
		GridBagConstraints gbc_lblParcela = new GridBagConstraints();
		gbc_lblParcela.anchor = GridBagConstraints.EAST;
		gbc_lblParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblParcela.gridx = 3;
		gbc_lblParcela.gridy = 2;
		panel.add(lblParcela, gbc_lblParcela);
		
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
		
		chckbxCorrienteElectrica = new JCheckBox("Acceso corriente eléctrica (20€)");
		GridBagConstraints gbc_chckbxCorrienteElectrica = new GridBagConstraints();
		gbc_chckbxCorrienteElectrica.anchor = GridBagConstraints.WEST;
		gbc_chckbxCorrienteElectrica.gridwidth = 3;
		gbc_chckbxCorrienteElectrica.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCorrienteElectrica.gridx = 1;
		gbc_chckbxCorrienteElectrica.gridy = 9;
		panel.add(chckbxCorrienteElectrica, gbc_chckbxCorrienteElectrica);
		
		chckbxParking = new JCheckBox("Parking para autocaravana (15€)");
		GridBagConstraints gbc_chckbxParking = new GridBagConstraints();
		gbc_chckbxParking.anchor = GridBagConstraints.WEST;
		gbc_chckbxParking.gridwidth = 3;
		gbc_chckbxParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParking.gridx = 1;
		gbc_chckbxParking.gridy = 10;
		panel.add(chckbxParking, gbc_chckbxParking);
		
		chckbxWifi = new JCheckBox("Zona WiFi (10€)");
		GridBagConstraints gbc_chckbxWifi = new GridBagConstraints();
		gbc_chckbxWifi.anchor = GridBagConstraints.WEST;
		gbc_chckbxWifi.gridwidth = 3;
		gbc_chckbxWifi.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWifi.gridx = 1;
		gbc_chckbxWifi.gridy = 11;
		panel.add(chckbxWifi, gbc_chckbxWifi);
		
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
		
		chckbxTiendaAcampada = new JCheckBox("Tienda de acampada (18€)");
		GridBagConstraints gbc_chckbxTiendaAcampada = new GridBagConstraints();
		gbc_chckbxTiendaAcampada.anchor = GridBagConstraints.WEST;
		gbc_chckbxTiendaAcampada.gridwidth = 3;
		gbc_chckbxTiendaAcampada.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTiendaAcampada.gridx = 1;
		gbc_chckbxTiendaAcampada.gridy = 12;
		panel.add(chckbxTiendaAcampada, gbc_chckbxTiendaAcampada);
		
		chckbxMascotas = new JCheckBox("Admisión animales (5€)");
		GridBagConstraints gbc_chckbxMascotas = new GridBagConstraints();
		gbc_chckbxMascotas.anchor = GridBagConstraints.WEST;
		gbc_chckbxMascotas.gridwidth = 3;
		gbc_chckbxMascotas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMascotas.gridx = 1;
		gbc_chckbxMascotas.gridy = 13;
		panel.add(chckbxMascotas, gbc_chckbxMascotas);
		
		btnSiguiente = new JButton("Siguiente");
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridwidth = 2;
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSiguiente.gridx = 8;
		gbc_btnSiguiente.gridy = 13;
		panel.add(btnSiguiente, gbc_btnSiguiente);

	}
}
