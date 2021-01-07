package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.SystemColor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

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
	private JLabel lblIconoAlojamiento;
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
	private JTextArea tAServicios;
	private JScrollPane scrollPane;
	private JLabel lblDNI;
	private JLabel lblNombreCliente;
	private JTextArea tAInformacion;
	private JLabel lblServicios;
	private JRadioButton rdbtnParcela;
	
	private Color colorBoton = new Color(159, 177, 57);
	private JTextField txtSeparador;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JPanel panel;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmailCamping;
	private Component verticalStrut;
	private JLabel lblSimboloEuros;
	private JLabel lblFechaReserva;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioReservaRealizada frame = new FormularioReservaRealizada(null, null, null, null, null, null, null, null, (Integer) null, null, null, (Boolean) null);
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
	 * @param precioTotal 
	 * @param isParcela 
	 */
	public FormularioReservaRealizada(String nombreAlojamiento, String entrada, String salida, String nombreCliente, String DNI, String movil,
			String fijo, String email, int ocupantes, ArrayList<String> servicios, String precioTotal, boolean isParcela) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 887);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 40, 125, 113, -67, 44, 0, 130, 0, 152, 30, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 20, 0, 20, 0, 60, 0, 0, 0, 55, 0, 20, 0, 0, 90, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnGuardar = new JButton("");
		btnGuardar.setToolTipText(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.btnGuardar.toolTipText")); //$NON-NLS-1$
		btnGuardar.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 9;
		gbc_btnGuardar.gridy = 0;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
				btnImpresora = new JButton("");
				btnImpresora.setToolTipText(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.btnImpresora.toolTipText")); //$NON-NLS-1$
				btnImpresora
						.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/impresora.png")));
				GridBagConstraints gbc_btnImpresora = new GridBagConstraints();
				gbc_btnImpresora.insets = new Insets(0, 0, 5, 0);
				gbc_btnImpresora.gridx = 10;
				gbc_btnImpresora.gridy = 0;
				contentPane.add(btnImpresora, gbc_btnImpresora);

		lblLogoMudez = new JLabel("");
		lblLogoMudez.setIcon(
				new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/campingMudezPequenio.png")));
		GridBagConstraints gbc_lblLogoMudez = new GridBagConstraints();
		gbc_lblLogoMudez.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLogoMudez.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogoMudez.gridx = 1;
		gbc_lblLogoMudez.gridy = 1;
		contentPane.add(lblLogoMudez, gbc_lblLogoMudez);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 8;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		lblDireccion = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblDireccion.text")); //$NON-NLS-1$
		panel.add(lblDireccion);
		
		lblTelefono = new JLabel("969 89 92 25");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTelefono);
		
		lblEmailCamping = new JLabel("campingMudez@gmail.com");
		lblEmailCamping.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblEmailCamping);
		
		separator = new JSeparator();
		panel.add(separator);
		
		lblFechaReserva = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")).toString());
		lblFechaReserva.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblFechaReserva);
		
		verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);
		
		txtSeparador = new JTextField();
		txtSeparador.setEditable(false);
		txtSeparador.setBackground(colorBoton);
		GridBagConstraints gbc_txtSeparador = new GridBagConstraints();
		gbc_txtSeparador.gridwidth = 11;
		gbc_txtSeparador.insets = new Insets(0, 0, 5, 0);
		gbc_txtSeparador.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSeparador.gridx = 0;
		gbc_txtSeparador.gridy = 2;
		contentPane.add(txtSeparador, gbc_txtSeparador);
		txtSeparador.setColumns(10);

		lblIconoCliente = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblIconoCliente.text")); //$NON-NLS-1$
		lblIconoCliente
				.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/cliente.png")));
		GridBagConstraints gbc_lblIconoCliente = new GridBagConstraints();
		gbc_lblIconoCliente.gridwidth = 6;
		gbc_lblIconoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoCliente.gridx = 1;
		gbc_lblIconoCliente.gridy = 4;
		contentPane.add(lblIconoCliente, gbc_lblIconoCliente);

		lblIconoInformacion = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblIconoInformacion.text")); //$NON-NLS-1$
		lblIconoInformacion
				.setIcon(new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/informacion.png")));
		GridBagConstraints gbc_lblIconoInformacion = new GridBagConstraints();
		gbc_lblIconoInformacion.gridwidth = 2;
		gbc_lblIconoInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoInformacion.gridx = 7;
		gbc_lblIconoInformacion.gridy = 4;
		contentPane.add(lblIconoInformacion, gbc_lblIconoInformacion);
		
		lblNombreCliente = new JLabel(nombreCliente);
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.gridwidth = 3;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 1;
		gbc_lblNombreCliente.gridy = 6;
		contentPane.add(lblNombreCliente, gbc_lblNombreCliente);

		lblDNI = new JLabel("");
		lblDNI.setText(DNI);
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 5;
		gbc_lblDNI.gridy = 6;
		contentPane.add(lblDNI, gbc_lblDNI);

		lblMovil = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblMovil.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 1;
		gbc_lblMovil.gridy = 7;
		contentPane.add(lblMovil, gbc_lblMovil);

		txtMovil = new JTextField();
		txtMovil.setEditable(false);
		txtMovil.setText(movil);
		GridBagConstraints gbc_txtMovil = new GridBagConstraints();
		gbc_txtMovil.gridwidth = 3;
		gbc_txtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_txtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMovil.gridx = 2;
		gbc_txtMovil.gridy = 7;
		contentPane.add(txtMovil, gbc_txtMovil);
		txtMovil.setColumns(10);
		
		tAInformacion = new JTextArea(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.tAInformacion.text")); //$NON-NLS-1$
		tAInformacion.setEditable(false);
		GridBagConstraints gbc_tAInformacion = new GridBagConstraints();
		gbc_tAInformacion.gridwidth = 2;
		gbc_tAInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_tAInformacion.fill = GridBagConstraints.BOTH;
		gbc_tAInformacion.gridx = 7;
		gbc_tAInformacion.gridy = 7;
		contentPane.add(tAInformacion, gbc_tAInformacion);

		lblFijo = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblFijo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.gridx = 1;
		gbc_lblFijo.gridy = 8;
		contentPane.add(lblFijo, gbc_lblFijo);

		txtFijo = new JTextField();
		txtFijo.setEditable(false);
		txtFijo.setText(fijo);
		GridBagConstraints gbc_txtFijo = new GridBagConstraints();
		gbc_txtFijo.gridwidth = 3;
		gbc_txtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_txtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFijo.gridx = 2;
		gbc_txtFijo.gridy = 8;
		contentPane.add(txtFijo, gbc_txtFijo);
		txtFijo.setColumns(10);

		lblEmail = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblEmail.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		contentPane.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText(email);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 9;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblOcupantes = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblOcupantes.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblOcupantes = new GridBagConstraints();
		gbc_lblOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupantes.gridx = 1;
		gbc_lblOcupantes.gridy = 10;
		contentPane.add(lblOcupantes, gbc_lblOcupantes);

		txtOcupantes = new JTextField();
		txtOcupantes.setEditable(false);
		txtOcupantes.setText(String.valueOf(ocupantes));
		GridBagConstraints gbc_txtOcupantes = new GridBagConstraints();
		gbc_txtOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_txtOcupantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOcupantes.gridx = 2;
		gbc_txtOcupantes.gridy = 10;
		contentPane.add(txtOcupantes, gbc_txtOcupantes);
		txtOcupantes.setColumns(10);

		lblIconoAlojamiento = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblIconoAlojamiento.text")); //$NON-NLS-1$
		lblIconoAlojamiento.setIcon(
				new ImageIcon(FormularioReservaRealizada.class.getResource("/presentacion/iconoAlojamiento.png")));
		GridBagConstraints gbc_lblIconoAlojamiento = new GridBagConstraints();
		gbc_lblIconoAlojamiento.gridwidth = 5;
		gbc_lblIconoAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblIconoAlojamiento.gridx = 1;
		gbc_lblIconoAlojamiento.gridy = 12;
		contentPane.add(lblIconoAlojamiento, gbc_lblIconoAlojamiento);
		
		rdbtnParcela = new JRadioButton(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.rdbtnParcela.text")); //$NON-NLS-1$
		rdbtnParcela.setEnabled(false);
		GridBagConstraints gbc_rdbtnParcela = new GridBagConstraints();
		gbc_rdbtnParcela.anchor = GridBagConstraints.EAST;
		gbc_rdbtnParcela.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnParcela.gridx = 6;
		gbc_rdbtnParcela.gridy = 12;
		contentPane.add(rdbtnParcela, gbc_rdbtnParcela);

		rdbtnBungalow = new JRadioButton(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.rdbtnBungalow.text")); //$NON-NLS-1$
		buttonGroup.add(rdbtnBungalow);
		rdbtnBungalow.setEnabled(false);
		GridBagConstraints gbc_rdbtnBungalow = new GridBagConstraints();
		gbc_rdbtnBungalow.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBungalow.gridx = 7;
		gbc_rdbtnBungalow.gridy = 12;
		contentPane.add(rdbtnBungalow, gbc_rdbtnBungalow);
		
		if (isParcela) rdbtnParcela.setSelected(true);
		else rdbtnBungalow.setSelected(true);

		lblNombreAlojamiento = new JLabel(nombreAlojamiento);
		GridBagConstraints gbc_lblNombreAlojamiento = new GridBagConstraints();
		gbc_lblNombreAlojamiento.anchor = GridBagConstraints.EAST;
		gbc_lblNombreAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreAlojamiento.gridx = 8;
		gbc_lblNombreAlojamiento.gridy = 12;
		contentPane.add(lblNombreAlojamiento, gbc_lblNombreAlojamiento);

		lblEntrada = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblEntrada.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEntrada = new GridBagConstraints();
		gbc_lblEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntrada.gridx = 1;
		gbc_lblEntrada.gridy = 14;
		contentPane.add(lblEntrada, gbc_lblEntrada);

		txtEntrada = new JTextField(entrada);
		txtEntrada.setEditable(false);
		GridBagConstraints gbc_txtEntrada = new GridBagConstraints();
		gbc_txtEntrada.gridwidth = 2;
		gbc_txtEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_txtEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEntrada.gridx = 2;
		gbc_txtEntrada.gridy = 14;
		contentPane.add(txtEntrada, gbc_txtEntrada);
		txtEntrada.setColumns(10);
		
		lblServicios = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblServicios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.anchor = GridBagConstraints.EAST;
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 6;
		gbc_lblServicios.gridy = 14;
		contentPane.add(lblServicios, gbc_lblServicios);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 7;
		gbc_scrollPane.gridy = 14;
		contentPane.add(scrollPane, gbc_scrollPane);

		tAServicios = new JTextArea();
		tAServicios.setEditable(false);
		String serviciosContratados = "";
		for (String servicio : servicios) {
			serviciosContratados += servicio;
			serviciosContratados += "\n";
		}
		tAServicios.setText(serviciosContratados);
		scrollPane.setViewportView(tAServicios);

		lblSalida = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblSalida.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.anchor = GridBagConstraints.EAST;
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 1;
		gbc_lblSalida.gridy = 15;
		contentPane.add(lblSalida, gbc_lblSalida);

		txtSalida = new JTextField(salida);
		txtSalida.setEditable(false);
		GridBagConstraints gbc_txtSalida = new GridBagConstraints();
		gbc_txtSalida.gridwidth = 2;
		gbc_txtSalida.insets = new Insets(0, 0, 5, 5);
		gbc_txtSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalida.gridx = 2;
		gbc_txtSalida.gridy = 15;
		contentPane.add(txtSalida, gbc_txtSalida);
		txtSalida.setColumns(10);
		
		lblPrecio = new JLabel(MessagesFormularioReservaRealizada.getString("FormularioReservaRealizada.lblPrecio.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 6;
		gbc_lblPrecio.gridy = 17;
		contentPane.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField(precioTotal);
		txtPrecio.setBackground(SystemColor.scrollbar);
		txtPrecio.setEditable(false);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridwidth = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 7;
		gbc_txtPrecio.gridy = 17;
		contentPane.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		lblSimboloEuros = new JLabel(" €");
		GridBagConstraints gbc_lblSimboloEuros = new GridBagConstraints();
		gbc_lblSimboloEuros.anchor = GridBagConstraints.WEST;
		gbc_lblSimboloEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimboloEuros.gridx = 9;
		gbc_lblSimboloEuros.gridy = 17;
		contentPane.add(lblSimboloEuros, gbc_lblSimboloEuros);
	}

}
