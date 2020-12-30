package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Dimension;

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
	
	private ArrayList<String> servicios;
	private String nombreAlojamiento;
	private int capacidadMaxima;
	private JLabel lblDNI;
	private JFormattedTextField ftxtDNI;
	

	/**
	 * Create the panel.
	 */
	public PanelFormularioReserva(JCalendar calendario, String nombreAlojamiento, int capacidadMaxima, ArrayList<String> servicios) {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de la reserva", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 127, 51, 30, 47, 0, 30, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{15, 0, 27, 0, 18, 0, 0, 0, 0, 0, 0, 18, 0, 28, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		lblFechaEntrada = new JLabel("Fecha de entrada:");
		GridBagConstraints gbc_lblFechaEntrada = new GridBagConstraints();
		gbc_lblFechaEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblFechaEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEntrada.gridx = 1;
		gbc_lblFechaEntrada.gridy = 2;
		add(lblFechaEntrada, gbc_lblFechaEntrada);
		
		dcEntrada = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		GridBagConstraints gbc_dcEntrada = new GridBagConstraints();
		gbc_dcEntrada.gridwidth = 3;
		gbc_dcEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_dcEntrada.fill = GridBagConstraints.BOTH;
		gbc_dcEntrada.gridx = 2;
		gbc_dcEntrada.gridy = 2;
		add(dcEntrada, gbc_dcEntrada);
		
		lblFechaSalida = new JLabel("Fecha de salida:");
		GridBagConstraints gbc_lblFechaSalida = new GridBagConstraints();
		gbc_lblFechaSalida.anchor = GridBagConstraints.EAST;
		gbc_lblFechaSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaSalida.gridx = 1;
		gbc_lblFechaSalida.gridy = 3;
		add(lblFechaSalida, gbc_lblFechaSalida);
		
		dcSalida = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
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
		
		lblNombreApellidos = new JLabel("Nombre y apellidos:");
		GridBagConstraints gbc_lblNombreApellidos = new GridBagConstraints();
		gbc_lblNombreApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblNombreApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreApellidos.gridx = 1;
		gbc_lblNombreApellidos.gridy = 5;
		add(lblNombreApellidos, gbc_lblNombreApellidos);
		
		txtNombreApellidos = new JTextField();
		GridBagConstraints gbc_txtNombreApellidos = new GridBagConstraints();
		gbc_txtNombreApellidos.gridwidth = 4;
		gbc_txtNombreApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreApellidos.gridx = 2;
		gbc_txtNombreApellidos.gridy = 5;
		add(txtNombreApellidos, gbc_txtNombreApellidos);
		txtNombreApellidos.setColumns(10);
		
		lblAlojamiento = new JLabel("<html>Alojamiento: <b>" + nombreAlojamiento + "</b></html>");
		GridBagConstraints gbc_lblAlojamiento = new GridBagConstraints();
		gbc_lblAlojamiento.anchor = GridBagConstraints.WEST;
		gbc_lblAlojamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlojamiento.gridx = 7;
		gbc_lblAlojamiento.gridy = 5;
		add(lblAlojamiento, gbc_lblAlojamiento);
		
		lblDNI = new JLabel("DNI/NIF:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 1;
		gbc_lblDNI.gridy = 6;
		add(lblDNI, gbc_lblDNI);
		
		MaskFormatter formatoDNI;
		try {
			formatoDNI = new MaskFormatter("########' U");
			formatoDNI.setPlaceholderCharacter('X');
			ftxtDNI = new JFormattedTextField(formatoDNI);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 2;
		gbc_ftxtDNI.gridy = 6;
		add(ftxtDNI, gbc_ftxtDNI);
		
		lblMovil = new JLabel("Teléfono móvil:");
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 1;
		gbc_lblMovil.gridy = 7;
		add(lblMovil, gbc_lblMovil);
		
		MaskFormatter formatoMovil;
		try {
			formatoMovil = new MaskFormatter("###' ##' ##' ##");
			formatoMovil.setPlaceholderCharacter('*');
			ftxtMovil = new JFormattedTextField(formatoMovil);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtMovil = new GridBagConstraints();
		gbc_ftxtMovil.gridwidth = 3;
		gbc_ftxtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtMovil.gridx = 2;
		gbc_ftxtMovil.gridy = 7;
		add(ftxtMovil, gbc_ftxtMovil);
		
		lblFijo = new JLabel("Teléfono fijo:");
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.gridx = 1;
		gbc_lblFijo.gridy = 8;
		add(lblFijo, gbc_lblFijo);
		
		MaskFormatter formatoFijo;
		try {
			formatoFijo = new MaskFormatter("###' ##' ##' ##");
			formatoFijo.setPlaceholderCharacter('*');
			ftxtFijo = new JFormattedTextField(formatoFijo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtFijo = new GridBagConstraints();
		gbc_ftxtFijo.gridwidth = 3;
		gbc_ftxtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFijo.gridx = 2;
		gbc_ftxtFijo.gridy = 8;
		add(ftxtFijo, gbc_ftxtFijo);
		
		lblEmail = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 4;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 9;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		lblOcupantes = new JLabel("Número de ocupantes:");
		GridBagConstraints gbc_lblOcupantes = new GridBagConstraints();
		gbc_lblOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupantes.gridx = 1;
		gbc_lblOcupantes.gridy = 10;
		add(lblOcupantes, gbc_lblOcupantes);
		
		spnOcupantes = new JSpinner();
		if(capacidadMaxima != -1)
			spnOcupantes.setModel(new SpinnerNumberModel(4, 4, capacidadMaxima, 1));
		else
			spnOcupantes.setModel(new SpinnerNumberModel(4, 4, 16, 1));
		GridBagConstraints gbc_spnOcupantes = new GridBagConstraints();
		gbc_spnOcupantes.anchor = GridBagConstraints.WEST;
		gbc_spnOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_spnOcupantes.gridx = 2;
		gbc_spnOcupantes.gridy = 10;
		add(spnOcupantes, gbc_spnOcupantes);
		
		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 5;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 11;
		add(separator_1, gbc_separator_1);
		
		lblServicios = new JLabel("Servicios contratados:");
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 1;
		gbc_lblServicios.gridy = 12;
		add(lblServicios, gbc_lblServicios);
		
		lblComentarios = new JLabel("Comentarios adicionales:");
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.anchor = GridBagConstraints.WEST;
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 4;
		gbc_lblComentarios.gridy = 12;
		add(lblComentarios, gbc_lblComentarios);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 13;
		add(scrollPane, gbc_scrollPane);
		
		lstServicios = new JList();
		DefaultListModel modelo = new DefaultListModel();
		for(String servicio : servicios)
			modelo.addElement(servicio);
		lstServicios.setModel(modelo);
		scrollPane.setViewportView(lstServicios);
		
		tAComentarios = new JTextArea();
		tAComentarios.setLineWrap(true);
		GridBagConstraints gbc_tAComentarios = new GridBagConstraints();
		gbc_tAComentarios.gridheight = 3;
		gbc_tAComentarios.gridwidth = 3;
		gbc_tAComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_tAComentarios.fill = GridBagConstraints.BOTH;
		gbc_tAComentarios.gridx = 4;
		gbc_tAComentarios.gridy = 13;
		add(tAComentarios, gbc_tAComentarios);
		
		lblPrecioTotal = new JLabel("Precio total:");
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotal.gridx = 7;
		gbc_lblPrecioTotal.gridy = 13;
		add(lblPrecioTotal, gbc_lblPrecioTotal);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(new Color(159, 177, 57));
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservar.gridx = 7;
		gbc_btnReservar.gridy = 15;
		add(btnReservar, gbc_btnReservar);
		
	}

}
