package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;

import persistencia.Actividades;
import persistencia.Alojamientos;

import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

public class PanelFormularioReservaParcela extends JPanel {
	public JScrollPane scrollPane;
	public JPanel panel;
	public JLabel lblFoto;
	public JLabel lblParcela;
	public JLabel lblValoracionCliente;
	public JLabel lblEstrellas;
	public JCalendar calendar;
	public JLabel lblServiciosOfertados;
	public JCheckBox chckbxGolf;
	public JCheckBox chckbxCorrienteElectrica;
	public JCheckBox chckbxParking;
	public JCheckBox chckbxWifi;
	public JCheckBox chckbxTiendaAcampada;
	public JCheckBox chckbxMascotas;
	public JButton btnSiguiente;
	public JLabel lblPrecioNoche;
	public JLabel lblEuros;
	public JLabel lblNombre;
	public JTextPane tPDescripcion;
	private JProgressBar progressBar;
	public JLabel lblPrecio;

	/**
	 * Create the panel.
	 */
	public PanelFormularioReservaParcela(JList lstAlojamientos, Alojamientos db, int indice) {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 70, 40, 10, 157, 31, 10, 115, 159, 25, 10, 20, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 20, 0, 70, 0, 10, 0, 40, 0, 0, 0, 0, 0, 0, 0, 45, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(600,15));
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridwidth = 10;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		panel.add(progressBar, gbc_progressBar);
		
		lblNombre = new JLabel("");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 3;
		panel.add(lblNombre, gbc_lblNombre);
		
		lblFoto = new JLabel("");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridwidth = 2;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 4;
		panel.add(lblFoto, gbc_lblFoto);
		
		lblParcela = new JLabel("Parcela: ");
		GridBagConstraints gbc_lblParcela = new GridBagConstraints();
		gbc_lblParcela.anchor = GridBagConstraints.EAST;
		gbc_lblParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblParcela.gridx = 1;
		gbc_lblParcela.gridy = 3;
		panel.add(lblParcela, gbc_lblParcela);
		
		tPDescripcion = new JTextPane();
		tPDescripcion.setContentType("text/html");
		GridBagConstraints gbc_tPDescripcion = new GridBagConstraints();
		gbc_tPDescripcion.gridheight = 2;
		gbc_tPDescripcion.gridwidth = 3;
		gbc_tPDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_tPDescripcion.fill = GridBagConstraints.BOTH;
		gbc_tPDescripcion.gridx = 4;
		gbc_tPDescripcion.gridy = 4;
		panel.add(tPDescripcion, gbc_tPDescripcion);
		
		calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 8;
		gbc_calendar.gridy = 4;
		panel.add(calendar, gbc_calendar);
		
		lblValoracionCliente = new JLabel("Valoración media de los clientes:");
		GridBagConstraints gbc_lblValoracionCliente = new GridBagConstraints();
		gbc_lblValoracionCliente.anchor = GridBagConstraints.EAST;
		gbc_lblValoracionCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblValoracionCliente.gridx = 4;
		gbc_lblValoracionCliente.gridy = 7;
		panel.add(lblValoracionCliente, gbc_lblValoracionCliente);
		
		lblEstrellas = new JLabel("");
		GridBagConstraints gbc_lblEstrellas = new GridBagConstraints();
		gbc_lblEstrellas.gridwidth = 2;
		gbc_lblEstrellas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstrellas.gridx = 5;
		gbc_lblEstrellas.gridy = 7;
		panel.add(lblEstrellas, gbc_lblEstrellas);
		
		lblServiciosOfertados = new JLabel("Servicios ofertados:");
		GridBagConstraints gbc_lblServiciosOfertados = new GridBagConstraints();
		gbc_lblServiciosOfertados.anchor = GridBagConstraints.WEST;
		gbc_lblServiciosOfertados.gridwidth = 4;
		gbc_lblServiciosOfertados.insets = new Insets(0, 0, 5, 5);
		gbc_lblServiciosOfertados.gridx = 1;
		gbc_lblServiciosOfertados.gridy = 9;
		panel.add(lblServiciosOfertados, gbc_lblServiciosOfertados);
		
		chckbxGolf = new JCheckBox("Acceso pista de golf (50€)");
		GridBagConstraints gbc_chckbxGolf = new GridBagConstraints();
		gbc_chckbxGolf.anchor = GridBagConstraints.WEST;
		gbc_chckbxGolf.gridwidth = 4;
		gbc_chckbxGolf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGolf.gridx = 1;
		gbc_chckbxGolf.gridy = 10;
		panel.add(chckbxGolf, gbc_chckbxGolf);
		
		chckbxCorrienteElectrica = new JCheckBox("Acceso corriente eléctrica (20€)");
		GridBagConstraints gbc_chckbxCorrienteElectrica = new GridBagConstraints();
		gbc_chckbxCorrienteElectrica.anchor = GridBagConstraints.WEST;
		gbc_chckbxCorrienteElectrica.gridwidth = 4;
		gbc_chckbxCorrienteElectrica.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCorrienteElectrica.gridx = 1;
		gbc_chckbxCorrienteElectrica.gridy = 11;
		panel.add(chckbxCorrienteElectrica, gbc_chckbxCorrienteElectrica);
		
		chckbxParking = new JCheckBox("Parking para autocaravana (15€)");
		GridBagConstraints gbc_chckbxParking = new GridBagConstraints();
		gbc_chckbxParking.anchor = GridBagConstraints.WEST;
		gbc_chckbxParking.gridwidth = 4;
		gbc_chckbxParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParking.gridx = 1;
		gbc_chckbxParking.gridy = 12;
		panel.add(chckbxParking, gbc_chckbxParking);
		
		chckbxWifi = new JCheckBox("Zona WiFi (10€)");
		GridBagConstraints gbc_chckbxWifi = new GridBagConstraints();
		gbc_chckbxWifi.anchor = GridBagConstraints.WEST;
		gbc_chckbxWifi.gridwidth = 4;
		gbc_chckbxWifi.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWifi.gridx = 1;
		gbc_chckbxWifi.gridy = 13;
		panel.add(chckbxWifi, gbc_chckbxWifi);
		
		lblPrecioNoche = new JLabel("Precio por noche:");
		GridBagConstraints gbc_lblPrecioNoche = new GridBagConstraints();
		gbc_lblPrecioNoche.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioNoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioNoche.gridx = 8;
		gbc_lblPrecioNoche.gridy = 13;
		panel.add(lblPrecioNoche, gbc_lblPrecioNoche);
		
		lblPrecio = new JLabel("");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 9;
		gbc_lblPrecio.gridy = 13;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		lblEuros = new JLabel("€");
		GridBagConstraints gbc_lblEuros = new GridBagConstraints();
		gbc_lblEuros.anchor = GridBagConstraints.WEST;
		gbc_lblEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblEuros.gridx = 10;
		gbc_lblEuros.gridy = 13;
		panel.add(lblEuros, gbc_lblEuros);
		
		chckbxTiendaAcampada = new JCheckBox("Tienda de acampada (18€)");
		GridBagConstraints gbc_chckbxTiendaAcampada = new GridBagConstraints();
		gbc_chckbxTiendaAcampada.anchor = GridBagConstraints.WEST;
		gbc_chckbxTiendaAcampada.gridwidth = 4;
		gbc_chckbxTiendaAcampada.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTiendaAcampada.gridx = 1;
		gbc_chckbxTiendaAcampada.gridy = 14;
		panel.add(chckbxTiendaAcampada, gbc_chckbxTiendaAcampada);
		
		chckbxMascotas = new JCheckBox("Admisión animales de compañía (5€)");
		GridBagConstraints gbc_chckbxMascotas = new GridBagConstraints();
		gbc_chckbxMascotas.anchor = GridBagConstraints.WEST;
		gbc_chckbxMascotas.gridwidth = 4;
		gbc_chckbxMascotas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMascotas.gridx = 1;
		gbc_chckbxMascotas.gridy = 15;
		panel.add(chckbxMascotas, gbc_chckbxMascotas);
		
		btnSiguiente = new JButton("Siguiente");
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridwidth = 2;
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSiguiente.gridx = 9;
		gbc_btnSiguiente.gridy = 15;
		panel.add(btnSiguiente, gbc_btnSiguiente);

	}
}
