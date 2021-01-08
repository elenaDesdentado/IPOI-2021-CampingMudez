package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import dominio.Alojamiento;
import dominio.Parcela;

import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;

public class PanelFormularioReserva extends JPanel {
	private JProgressBar progressBar;
	private JLabel lblFechaEntrada;
	private JDateChooser dcEntrada;
	private JLabel lblFechaSalida;
	private JDateChooser dcSalida;
	private JLabel lblNombreApellidos;
	private JLabel lblMovil;
	private JLabel lblFijo;
	private JFormattedTextField ftxtMovil;
	private JFormattedTextField ftxtFijo;
	private JTextField txtNombreApellidos;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblOcupantes;
	private JSpinner spnOcupantes;
	private JSeparator separator_1;
	private JLabel lblServicios;
	private JScrollPane scrollPane;
	private JList lstServicios;
	private JLabel lblComentarios;
	private JTextArea tAComentarios;
	private JLabel lblAlojamiento;
	private JLabel lblPrecioTotal;
	private JButton btnReservar;
	private JCalendar calendar;
	private JButton btnAtras;
	private JButton btnCalcularPrecio;

	private Alojamiento alojamiento;
	private ArrayList<String> servicios;
	private ArrayList<String> fechasReservadas;
	private String nombreAlojamiento;
	private JLabel lblDNI;
	private JFormattedTextField ftxtDNI;
	private String patron = "[0-9]{7,8}[A-Z a-z]"; //$NON-NLS-1$

	/*
	 * Variables para determinar si actualizar la barra de progreso
	 */
	private boolean updateNA = true;
	private boolean updateDCE = true;
	private boolean updateDCS = true;
	private boolean updateEM = true;

	private double precioNoche;
	private JTextField txtPrecioTotal;
	private JLabel lblSimboloEuros;

	/**
	 * Create the panel.
	 */
	public PanelFormularioReserva(JCalendar calendario, Alojamiento alojamiento, String nombreAlojamiento,
			int capacidadMaxima, ArrayList<String> servicios, double precioNoche, ArrayList<String> fechasReservadas) {

		this.alojamiento = alojamiento;
		this.precioNoche = precioNoche;
		this.nombreAlojamiento = nombreAlojamiento;
		this.servicios = servicios;
		this.fechasReservadas = fechasReservadas;

		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				MessagesPanelFormularioReserva.getString("PanelFormularioReserva.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128))); //$NON-NLS-1$
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 15, 127, 82, 51, 47, 0, 52, 0, 56, 0, 20, 0 };
		gridBagLayout.rowHeights = new int[] { 15, 0, 27, 0, 0, 18, 0, 0, 0, 0, 0, 0, 18, 0, 28, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(600, 15));
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 7;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		add(progressBar, gbc_progressBar);

		lblFechaEntrada = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblFechaEntrada.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaEntrada = new GridBagConstraints();
		gbc_lblFechaEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblFechaEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEntrada.gridx = 1;
		gbc_lblFechaEntrada.gridy = 2;
		add(lblFechaEntrada, gbc_lblFechaEntrada);

		dcEntrada = new JDateChooser("yyyy-MM-dd", "####-##-##", '_'); //$NON-NLS-1$ //$NON-NLS-2$
		DcPropertyChangeListener listener = new DcPropertyChangeListener(updateDCE);
		dcEntrada.addPropertyChangeListener(listener);
		GridBagConstraints gbc_dcEntrada = new GridBagConstraints();
		gbc_dcEntrada.gridwidth = 3;
		gbc_dcEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_dcEntrada.fill = GridBagConstraints.BOTH;
		gbc_dcEntrada.gridx = 2;
		gbc_dcEntrada.gridy = 2;
		add(dcEntrada, gbc_dcEntrada);

		lblFechaSalida = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblFechaSalida.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaSalida = new GridBagConstraints();
		gbc_lblFechaSalida.anchor = GridBagConstraints.EAST;
		gbc_lblFechaSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaSalida.gridx = 1;
		gbc_lblFechaSalida.gridy = 3;
		add(lblFechaSalida, gbc_lblFechaSalida);

		dcSalida = new JDateChooser("yyyy-MM-dd", "####-##-##", '_'); //$NON-NLS-1$ //$NON-NLS-2$
		DcPropertyChangeListener list = new DcPropertyChangeListener(updateDCS);
		dcSalida.addPropertyChangeListener(list);
		GridBagConstraints gbc_dcSalida = new GridBagConstraints();
		gbc_dcSalida.gridwidth = 3;
		gbc_dcSalida.insets = new Insets(0, 0, 5, 5);
		gbc_dcSalida.fill = GridBagConstraints.BOTH;
		gbc_dcSalida.gridx = 2;
		gbc_dcSalida.gridy = 3;
		add(dcSalida, gbc_dcSalida);

		calendar = calendario;
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridheight = 3;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 7;
		gbc_calendar.gridy = 2;
		add(calendar, gbc_calendar);

		btnCalcularPrecio = new JButton(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.btnCalcularPrecio.text")); //$NON-NLS-1$
		btnCalcularPrecio.setIcon(new ImageIcon(PanelFormularioReserva.class.getResource("/presentacion/euro.png"))); //$NON-NLS-1$
		btnCalcularPrecio.addActionListener(new BtnCalcularPrecioActionListener());
		GridBagConstraints gbc_btnCalcularPrecio = new GridBagConstraints();
		gbc_btnCalcularPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalcularPrecio.gridx = 4;
		gbc_btnCalcularPrecio.gridy = 4;
		add(btnCalcularPrecio, gbc_btnCalcularPrecio);

		lblNombreApellidos = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblNombreApellidos.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombreApellidos = new GridBagConstraints();
		gbc_lblNombreApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblNombreApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreApellidos.gridx = 1;
		gbc_lblNombreApellidos.gridy = 6;
		add(lblNombreApellidos, gbc_lblNombreApellidos);

		txtNombreApellidos = new JTextField();
		txtNombreApellidos.getDocument().addDocumentListener(new miDocumentListener());
		txtNombreApellidos.getDocument().putProperty("name", "txtNombreApellidos"); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_txtNombreApellidos = new GridBagConstraints();
		gbc_txtNombreApellidos.gridwidth = 4;
		gbc_txtNombreApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreApellidos.gridx = 2;
		gbc_txtNombreApellidos.gridy = 6;
		add(txtNombreApellidos, gbc_txtNombreApellidos);
		txtNombreApellidos.setColumns(10);

		lblAlojamiento = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.LabelAlojamiento") + nombreAlojamiento + "</b></html>"); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_lblAlojamiento = new GridBagConstraints();
		gbc_lblAlojamiento.anchor = GridBagConstraints.WEST;
		gbc_lblAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlojamiento.gridx = 7;
		gbc_lblAlojamiento.gridy = 6;
		add(lblAlojamiento, gbc_lblAlojamiento);

		lblDNI = new JLabel("DNI/NIF:"); //$NON-NLS-1$
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 1;
		gbc_lblDNI.gridy = 7;
		add(lblDNI, gbc_lblDNI);

		MaskFormatter formatoDNI;
		try {
			formatoDNI = new MaskFormatter("########U"); //$NON-NLS-1$
			formatoDNI.setPlaceholderCharacter('X');
			ftxtDNI = new JFormattedTextField(formatoDNI);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 2;
		gbc_ftxtDNI.gridy = 7;
		add(ftxtDNI, gbc_ftxtDNI);

		lblMovil = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblMovil.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 1;
		gbc_lblMovil.gridy = 8;
		add(lblMovil, gbc_lblMovil);

		MaskFormatter formatoMovil;
		try {
			formatoMovil = new MaskFormatter("###' ##' ##' ##"); //$NON-NLS-1$
			formatoMovil.setPlaceholderCharacter('*');
			ftxtMovil = new JFormattedTextField(formatoMovil);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtMovil = new GridBagConstraints();
		gbc_ftxtMovil.gridwidth = 2;
		gbc_ftxtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtMovil.gridx = 2;
		gbc_ftxtMovil.gridy = 8;
		add(ftxtMovil, gbc_ftxtMovil);

		lblFijo = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblFijo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.gridx = 1;
		gbc_lblFijo.gridy = 9;
		add(lblFijo, gbc_lblFijo);

		MaskFormatter formatoFijo;
		try {
			formatoFijo = new MaskFormatter("###' ##' ##' ##"); //$NON-NLS-1$
			formatoFijo.setPlaceholderCharacter('*');
			ftxtFijo = new JFormattedTextField(formatoFijo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtFijo = new GridBagConstraints();
		gbc_ftxtFijo.gridwidth = 2;
		gbc_ftxtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFijo.gridx = 2;
		gbc_ftxtFijo.gridy = 9;
		add(ftxtFijo, gbc_ftxtFijo);

		lblEmail = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblEmail.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 10;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.getDocument().addDocumentListener(new miDocumentListener());
		txtEmail.getDocument().putProperty("name", "txtEmail"); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 4;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 10;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblOcupantes = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblOcupantes.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblOcupantes = new GridBagConstraints();
		gbc_lblOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupantes.gridx = 1;
		gbc_lblOcupantes.gridy = 11;
		add(lblOcupantes, gbc_lblOcupantes);

		spnOcupantes = new JSpinner();
		if (capacidadMaxima != -1)
			spnOcupantes.setModel(new SpinnerNumberModel(4, 4, capacidadMaxima, 1));
		else
			spnOcupantes.setModel(new SpinnerNumberModel(4, 4, 16, 1));
		GridBagConstraints gbc_spnOcupantes = new GridBagConstraints();
		gbc_spnOcupantes.anchor = GridBagConstraints.WEST;
		gbc_spnOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_spnOcupantes.gridx = 2;
		gbc_spnOcupantes.gridy = 11;
		add(spnOcupantes, gbc_spnOcupantes);

		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 5;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 12;
		add(separator_1, gbc_separator_1);

		lblServicios = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblServicios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 1;
		gbc_lblServicios.gridy = 13;
		add(lblServicios, gbc_lblServicios);

		lblComentarios = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblComentarios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.anchor = GridBagConstraints.WEST;
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 4;
		gbc_lblComentarios.gridy = 13;
		add(lblComentarios, gbc_lblComentarios);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 14;
		add(scrollPane, gbc_scrollPane);

		lstServicios = new JList();
		DefaultListModel modelo = new DefaultListModel();
		for (String servicio : servicios)
			modelo.addElement(servicio);
		lstServicios.setModel(modelo);
		scrollPane.setViewportView(lstServicios);

		tAComentarios = new JTextArea();
		tAComentarios.setWrapStyleWord(true);
		tAComentarios.setBackground(Color.LIGHT_GRAY);
		tAComentarios.setRows(5);
		tAComentarios.setLineWrap(true);
		GridBagConstraints gbc_tAComentarios = new GridBagConstraints();
		gbc_tAComentarios.gridheight = 3;
		gbc_tAComentarios.gridwidth = 3;
		gbc_tAComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_tAComentarios.fill = GridBagConstraints.BOTH;
		gbc_tAComentarios.gridx = 4;
		gbc_tAComentarios.gridy = 14;
		add(tAComentarios, gbc_tAComentarios);

		lblPrecioTotal = new JLabel(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lblPrecioTotal.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotal.gridx = 7;
		gbc_lblPrecioTotal.gridy = 14;
		add(lblPrecioTotal, gbc_lblPrecioTotal);

		btnReservar = new JButton(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.btnReservar.text")); //$NON-NLS-1$
		btnReservar.addActionListener(new BtnReservarActionListener());

		btnAtras = new JButton(""); //$NON-NLS-1$
		btnAtras.setIcon(new ImageIcon(PanelFormularioReserva.class.getResource("/presentacion/flecha-hacia-atras.png"))); //$NON-NLS-1$
		btnAtras.addActionListener(new BtnAtrasActionListener());
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setEditable(false);
		GridBagConstraints gbc_txtPrecioTotal = new GridBagConstraints();
		gbc_txtPrecioTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioTotal.gridx = 8;
		gbc_txtPrecioTotal.gridy = 14;
		add(txtPrecioTotal, gbc_txtPrecioTotal);
		txtPrecioTotal.setColumns(10);
		
		lblSimboloEuros = new JLabel("€"); //$NON-NLS-1$
		GridBagConstraints gbc_lblSimboloEuros = new GridBagConstraints();
		gbc_lblSimboloEuros.anchor = GridBagConstraints.WEST;
		gbc_lblSimboloEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimboloEuros.gridx = 9;
		gbc_lblSimboloEuros.gridy = 14;
		add(lblSimboloEuros, gbc_lblSimboloEuros);
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 18;
		add(btnAtras, gbc_btnAtras);
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(new Color(159, 177, 57));
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservar.gridx = 7;
		gbc_btnReservar.gridy = 18;
		add(btnReservar, gbc_btnReservar);

	}

	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (txtPrecioTotal.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,
						MessagesPanelFormularioReserva.getString("PanelFormularioReserva.PrimeroCalcular"), //$NON-NLS-1$
						MessagesPanelFormularioReserva.getString("PanelFormularioReserva.NoSePudoReservar"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
			} else {
				boolean condicionCamposRellenados = !ftxtDNI.getText().matches(patron)
						|| ftxtMovil.getText().contains("*") || ftxtFijo.getText().contains("*") //$NON-NLS-1$ //$NON-NLS-2$
						|| txtNombreApellidos.getText().length() < 12 || txtEmail.getText().length() < 16 || !txtEmail.getText().contains("@"); //$NON-NLS-1$
				if (condicionCamposRellenados) {
					JOptionPane.showMessageDialog(null, MessagesPanelFormularioReserva.getString("PanelFormularioReserva.RellenaTodasEntradas"), //$NON-NLS-1$
							MessagesPanelFormularioReserva.getString("PanelFormularioReserva.EntradasVacias"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
				} else {
					if (sonFechasValidas()) {
						progressBar.setValue(100);
						String[] opciones = { MessagesPanelFormularioReserva.getString("PanelFormularioReserva.OpcionSi"), MessagesPanelFormularioReserva.getString("PanelFormularioReserva.OpcionNo") }; //$NON-NLS-1$ //$NON-NLS-2$
						int seleccion = JOptionPane.showOptionDialog(null, MessagesPanelFormularioReserva.getString("PanelFormularioReserva.ConfirmarReserva"), //$NON-NLS-1$
								MessagesPanelFormularioReserva.getString("PanelFormularioReserva.PreguntaRealizarReserva"), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, //$NON-NLS-1$
								opciones, opciones[0]);
						if (seleccion == 0) {
							JOptionPane.showMessageDialog(null, MessagesPanelFormularioReserva.getString("PanelFormularioReserva.ExitoReserva"), //$NON-NLS-1$
									MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TituloExitoReserva"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
							String entrada = sdf.format(dcEntrada.getDate());
							String salida = sdf.format(dcSalida.getDate());
							alojamiento.getFechasReservadas().add(entrada + ";" + salida); //$NON-NLS-1$
							boolean isParcela = false;
							if (alojamiento instanceof Parcela)
								isParcela = true;
							FormularioReservaRealizada reservaRealizada = new FormularioReservaRealizada(
									nombreAlojamiento, entrada, salida, txtNombreApellidos.getText(), ftxtDNI.getText(),
									ftxtMovil.getText(), ftxtFijo.getText(), txtEmail.getText(),
									(int) spnOcupantes.getValue(), servicios, txtPrecioTotal.getText(), isParcela);
							reservaRealizada.setLocationRelativeTo(null);
							reservaRealizada.setVisible(true);
						} else
							progressBar.setValue(89);
					}
				}
			}
		}
	}

	private class miDocumentListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			updateProgressBar(e);

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			removeUpdateProgressBar(e);

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		public void removeUpdateProgressBar(DocumentEvent e) {

			Document doc = (Document) e.getDocument();
			switch ((String) doc.getProperty("name")) { //$NON-NLS-1$
			case "txtNombreApellidos": //$NON-NLS-1$
				if (txtNombreApellidos.getText().equals("")) { //$NON-NLS-1$
					progressBar.setValue(progressBar.getValue() - 15);
					updateNA = true;
				}
				break;
			case "txtEmail": //$NON-NLS-1$
				if (txtEmail.getText().equals("")) { //$NON-NLS-1$
					progressBar.setValue(progressBar.getValue() - 44);
					updateEM = true;
				}
			}
		}

		public void updateProgressBar(DocumentEvent e) {
			Document doc = (Document) e.getDocument();
			switch ((String) doc.getProperty("name")) { //$NON-NLS-1$
			case "txtNombreApellidos": //$NON-NLS-1$
				if (txtNombreApellidos.getText().length() >= 12 && updateNA) {
					progressBar.setValue(progressBar.getValue() + 15);
					updateNA = false;
				}
				break;
			case "txtEmail": //$NON-NLS-1$
				boolean condicion = ftxtDNI.getText().matches(patron) && !ftxtMovil.getText().contains("*") //$NON-NLS-1$
						&& !ftxtFijo.getText().contains("*"); //$NON-NLS-1$
				if (txtEmail.getText().length() >= 16 && updateEM && condicion) {
					progressBar.setValue(progressBar.getValue() + 44);
					updateEM = false;
				}
			}
		}

	}

	private class DcPropertyChangeListener implements PropertyChangeListener {
		private boolean updater;

		public DcPropertyChangeListener(boolean updater) {
			this.updater = updater;
		}

		public void propertyChange(PropertyChangeEvent evt) {
			if ("date".equals(evt.getPropertyName()) && updater) { //$NON-NLS-1$
				progressBar.setValue(progressBar.getValue() + 15);
				this.updater = false;
			}
		}
	}

	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel padre = (JPanel) getParent();
			((CardLayout) padre.getLayout()).show(padre, nombreAlojamiento);
		}
	}

	private class BtnCalcularPrecioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double precioServicios = 0;
			if (dcEntrada.getDate() == null || dcSalida.getDate() == null) {
				JOptionPane.showMessageDialog(null, MessagesPanelFormularioReserva.getString("PanelFormularioReserva.IntroduceDosFechas"), //$NON-NLS-1$
						MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TitulointroduceDosFechas"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
				String entrada = sdf.format(dcEntrada.getDate());
				String salida = sdf.format(dcSalida.getDate());
				if (sonFechasValidas()) {
					for (String servicio : servicios) {
						if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.golf"))) //$NON-NLS-1$
							precioServicios += 50;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.corriente"))) //$NON-NLS-1$
							precioServicios += 20;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.parking"))) //$NON-NLS-1$
							precioServicios += 15;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.WiFi"))) //$NON-NLS-1$
							precioServicios += 10;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.acampada"))) //$NON-NLS-1$
							precioServicios += 18;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.animales"))) //$NON-NLS-1$
							precioServicios += 5;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.carbon"))) //$NON-NLS-1$
							precioServicios += 5;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.garaje"))) //$NON-NLS-1$
							precioServicios += 15;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.extra"))) //$NON-NLS-1$
							precioServicios += 10;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.limpieza"))) //$NON-NLS-1$
							precioServicios += 15;
						else if (servicio.contains(MessagesPanelFormularioReserva.getString("PanelFormularioReserva.lavavajillas"))) //$NON-NLS-1$
							precioServicios += 10;
					}
					LocalDate d1 = LocalDate.parse(entrada, DateTimeFormatter.ISO_LOCAL_DATE);
					LocalDate d2 = LocalDate.parse(salida, DateTimeFormatter.ISO_LOCAL_DATE);
					Duration dias = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
					long diasReservados = dias.toDays();
					txtPrecioTotal.setText(String.valueOf(precioServicios + diasReservados * precioNoche));
				}
			}
		}
	}

	public boolean sonFechasValidas() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
		Date fechaEntrada = new Date();
		Date fechaSalida = new Date();
		Date diaHoy = new Date();
		if (dcEntrada.getDate().after(dcSalida.getDate())) {
			JOptionPane.showMessageDialog(null, MessagesPanelFormularioReserva.getString("PanelFormularioReserva.EntradaPreviaSalida"), MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TituloEntradaPreviaSalida"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(dcEntrada.getDate().before(diaHoy) || dcSalida.getDate().before(diaHoy)) {
			JOptionPane.showMessageDialog(null,
					MessagesPanelFormularioReserva.getString("PanelFormularioReserva.PreviasHoy"), //$NON-NLS-1$
					MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TituloPreviasHoy"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
			return false;
		}
		else {
			for (String rangoFechas : fechasReservadas) {
				String[] fechas = rangoFechas.split(";"); //$NON-NLS-1$
				try {
					fechaEntrada = sdf.parse(fechas[0]);
					fechaSalida = sdf.parse(fechas[1]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (fechaEntrada.equals(dcEntrada.getDate()) || !(fechaEntrada.compareTo(dcEntrada.getDate())
						* fechaSalida.compareTo(dcEntrada.getDate()) > 0)) {
					JOptionPane.showMessageDialog(null,
							MessagesPanelFormularioReserva.getString("PanelFormularioReserva.FechaEntradaReservada"), //$NON-NLS-1$
							MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TituloEntradaYaReservada"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
					return false;
				}
				if (fechaSalida.equals(dcSalida.getDate()) || !(fechaEntrada.compareTo(dcSalida.getDate())
						* fechaSalida.compareTo(dcSalida.getDate()) > 0)) {
					JOptionPane.showMessageDialog(null,
							MessagesPanelFormularioReserva.getString("PanelFormularioReserva.SalidaYaReservada"), //$NON-NLS-1$
							MessagesPanelFormularioReserva.getString("PanelFormularioReserva.TiutuloSalidaYaReservada"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
					return false;
				}
			}
		}
		return true;
	}
}
