package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FormularioReservaRealizada extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoMudez;
	private JLabel lblIconoCliente;
	private JButton btnImpresora;
	private JLabel lblMovil;
	private JLabel lblFijo;
	private JLabel lblEmail;
	private JTextField txtMovil;
	private JTextField txtFijo;
	private JTextField txtEmail;
	private JLabel lblIconoInformacion;
	private JTextPane tPInformacion;
	private JLabel lblIconoAlojamiento;
	private JRadioButton rdbtnParcela;
	private JRadioButton rdbtnBungalow;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNombreAlojamiento;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JTextField txtEntrada;
	private JTextField txtSalida;
	private JButton btnGuardar;
	private JLabel lblOcupantes;
	private JTextField txtOcupantes;
	private JLabel lblServicios;
	private JTextArea tAServicios;
	private JScrollPane scrollPane;
	private JLabel lblDNI;
	private JLabel lblNombreCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioReservaRealizada frame = new FormularioReservaRealizada(null, null, null, null, null, null, null, null, (Integer) null, null, (Boolean) null);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param nombreCliente
	 * @param salida
	 * @param entrada
	 * @param DNI
	 * @param fijo
	 * @param movil
	 * @param servicios 
	 * @param ocupantes 
	 * @param email 
	 * @param isParcela 
	 */
	public FormularioReservaRealizada(String nombreAlojamiento, String entrada, String salida, String nombreCliente, String DNI, String movil,
			String fijo, String email, int ocupantes, ArrayList<String> servicios, boolean isParcela) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 125, 113, 69, 0, 50, 126, 0, 30, 30, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 20, 0, 0, 60, 0, 0, 0, 40, 0, 0, 0, 20, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnGuardar = new JButton("");
		btnGuardar.setToolTipText("Pulse para guardar la información de la reserva en formato PDF");
		btnGuardar.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 8;
		gbc_btnGuardar.gridy = 0;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		btnImpresora = new JButton("");
		btnImpresora.setToolTipText("Pulse para imprimir la información de la reserva");
		btnImpresora
				.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/impresora.png")));
		GridBagConstraints gbc_btnImpresora = new GridBagConstraints();
		gbc_btnImpresora.insets = new Insets(0, 0, 5, 0);
		gbc_btnImpresora.gridx = 9;
		gbc_btnImpresora.gridy = 0;
		contentPane.add(btnImpresora, gbc_btnImpresora);

		lblLogoMudez = new JLabel("");
		lblLogoMudez.setIcon(
				new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/campingMudezPequenio.png")));
		GridBagConstraints gbc_lblLogoMudez = new GridBagConstraints();
		gbc_lblLogoMudez.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLogoMudez.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogoMudez.gridx = 0;
		gbc_lblLogoMudez.gridy = 1;
		contentPane.add(lblLogoMudez, gbc_lblLogoMudez);

		lblIconoCliente = new JLabel("Cliente");
		lblIconoCliente
				.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/cliente.png")));
		GridBagConstraints gbc_lblIconoCliente = new GridBagConstraints();
		gbc_lblIconoCliente.gridwidth = 5;
		gbc_lblIconoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoCliente.gridx = 0;
		gbc_lblIconoCliente.gridy = 3;
		contentPane.add(lblIconoCliente, gbc_lblIconoCliente);

		lblIconoInformacion = new JLabel("Información");
		lblIconoInformacion
				.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/informacion.png")));
		GridBagConstraints gbc_lblIconoInformacion = new GridBagConstraints();
		gbc_lblIconoInformacion.gridwidth = 3;
		gbc_lblIconoInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoInformacion.gridx = 5;
		gbc_lblIconoInformacion.gridy = 3;
		contentPane.add(lblIconoInformacion, gbc_lblIconoInformacion);
		
		lblNombreCliente = new JLabel(nombreCliente);
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.gridwidth = 3;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 0;
		gbc_lblNombreCliente.gridy = 4;
		contentPane.add(lblNombreCliente, gbc_lblNombreCliente);

		lblDNI = new JLabel("");
		lblDNI.setText(DNI);
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 3;
		gbc_lblDNI.gridy = 4;
		contentPane.add(lblDNI, gbc_lblDNI);

		lblMovil = new JLabel("Teléfono móvil: ");
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 0;
		gbc_lblMovil.gridy = 5;
		contentPane.add(lblMovil, gbc_lblMovil);

		txtMovil = new JTextField();
		txtMovil.setText(movil);
		GridBagConstraints gbc_txtMovil = new GridBagConstraints();
		gbc_txtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_txtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMovil.gridx = 1;
		gbc_txtMovil.gridy = 5;
		contentPane.add(txtMovil, gbc_txtMovil);
		txtMovil.setColumns(10);

		tPInformacion = new JTextPane();
		tPInformacion.setContentType("text/html");
		GridBagConstraints gbc_tPInformacion = new GridBagConstraints();
		gbc_tPInformacion.gridwidth = 3;
		gbc_tPInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_tPInformacion.fill = GridBagConstraints.BOTH;
		gbc_tPInformacion.gridx = 5;
		gbc_tPInformacion.gridy = 5;
		contentPane.add(tPInformacion, gbc_tPInformacion);

		tPInformacion.setText("<html><pre> La reserva se ha realizado con éxito y se \r\n encuentra confirmada. Gracias por confiar en nosotros.</html></pre>");

		lblFijo = new JLabel("Teléfono fijo: ");
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.gridx = 0;
		gbc_lblFijo.gridy = 6;
		contentPane.add(lblFijo, gbc_lblFijo);

		txtFijo = new JTextField();
		txtFijo.setText(fijo);
		GridBagConstraints gbc_txtFijo = new GridBagConstraints();
		gbc_txtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_txtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFijo.gridx = 1;
		gbc_txtFijo.gridy = 6;
		contentPane.add(txtFijo, gbc_txtFijo);
		txtFijo.setColumns(10);

		lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		contentPane.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText(email);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 7;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblOcupantes = new JLabel("Número de ocupantes:");
		GridBagConstraints gbc_lblOcupantes = new GridBagConstraints();
		gbc_lblOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupantes.gridx = 0;
		gbc_lblOcupantes.gridy = 8;
		contentPane.add(lblOcupantes, gbc_lblOcupantes);

		txtOcupantes = new JTextField();
		txtOcupantes.setText(String.valueOf(ocupantes));
		GridBagConstraints gbc_txtOcupantes = new GridBagConstraints();
		gbc_txtOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_txtOcupantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOcupantes.gridx = 1;
		gbc_txtOcupantes.gridy = 8;
		contentPane.add(txtOcupantes, gbc_txtOcupantes);
		txtOcupantes.setColumns(10);

		lblIconoAlojamiento = new JLabel("Alojamiento");
		lblIconoAlojamiento.setIcon(
				new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/iconoAlojamiento.png")));
		GridBagConstraints gbc_lblIconoAlojamiento = new GridBagConstraints();
		gbc_lblIconoAlojamiento.gridwidth = 5;
		gbc_lblIconoAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoAlojamiento.gridx = 0;
		gbc_lblIconoAlojamiento.gridy = 10;
		contentPane.add(lblIconoAlojamiento, gbc_lblIconoAlojamiento);

		rdbtnParcela = new JRadioButton("Parcela");
		buttonGroup.add(rdbtnParcela);
		rdbtnParcela.setEnabled(false);
		rdbtnParcela.setFocusable(false);
		GridBagConstraints gbc_rdbtnParcela = new GridBagConstraints();
		gbc_rdbtnParcela.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnParcela.gridx = 5;
		gbc_rdbtnParcela.gridy = 10;
		contentPane.add(rdbtnParcela, gbc_rdbtnParcela);

		rdbtnBungalow = new JRadioButton("Bungalow");
		buttonGroup.add(rdbtnBungalow);
		rdbtnBungalow.setEnabled(false);
		GridBagConstraints gbc_rdbtnBungalow = new GridBagConstraints();
		gbc_rdbtnBungalow.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBungalow.gridx = 6;
		gbc_rdbtnBungalow.gridy = 10;
		contentPane.add(rdbtnBungalow, gbc_rdbtnBungalow);
		
		if (isParcela) rdbtnParcela.setSelected(true);
		else rdbtnBungalow.setSelected(true);

		lblNombreAlojamiento = new JLabel(nombreAlojamiento);
		GridBagConstraints gbc_lblNombreAlojamiento = new GridBagConstraints();
		gbc_lblNombreAlojamiento.anchor = GridBagConstraints.WEST;
		gbc_lblNombreAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreAlojamiento.gridx = 7;
		gbc_lblNombreAlojamiento.gridy = 10;
		contentPane.add(lblNombreAlojamiento, gbc_lblNombreAlojamiento);

		lblEntrada = new JLabel("Fecha de entrada:");
		GridBagConstraints gbc_lblEntrada = new GridBagConstraints();
		gbc_lblEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntrada.gridx = 0;
		gbc_lblEntrada.gridy = 11;
		contentPane.add(lblEntrada, gbc_lblEntrada);

		txtEntrada = new JTextField(entrada);
		GridBagConstraints gbc_txtEntrada = new GridBagConstraints();
		gbc_txtEntrada.gridwidth = 2;
		gbc_txtEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_txtEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEntrada.gridx = 1;
		gbc_txtEntrada.gridy = 11;
		contentPane.add(txtEntrada, gbc_txtEntrada);
		txtEntrada.setColumns(10);

		lblServicios = new JLabel("Servicios contratados:");
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.anchor = GridBagConstraints.EAST;
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 5;
		gbc_lblServicios.gridy = 11;
		contentPane.add(lblServicios, gbc_lblServicios);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 11;
		contentPane.add(scrollPane, gbc_scrollPane);

		tAServicios = new JTextArea();
		String serviciosContratados = "";
		for (String servicio : servicios) {
			serviciosContratados += servicio;
			serviciosContratados += "\n";
		}
		tAServicios.setText(serviciosContratados);
		scrollPane.setViewportView(tAServicios);

		lblSalida = new JLabel("Fecha de salida:");
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.anchor = GridBagConstraints.EAST;
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 0;
		gbc_lblSalida.gridy = 12;
		contentPane.add(lblSalida, gbc_lblSalida);

		txtSalida = new JTextField(salida);
		GridBagConstraints gbc_txtSalida = new GridBagConstraints();
		gbc_txtSalida.gridwidth = 2;
		gbc_txtSalida.insets = new Insets(0, 0, 5, 5);
		gbc_txtSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalida.gridx = 1;
		gbc_txtSalida.gridy = 12;
		contentPane.add(txtSalida, gbc_txtSalida);
		txtSalida.setColumns(10);
	}

}
