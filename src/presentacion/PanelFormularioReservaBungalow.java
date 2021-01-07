package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;

import dominio.Actividad;
import dominio.Alojamiento;
import dominio.Bungalow;
import persistencia.Actividades;
import persistencia.Alojamientos;

import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFormularioReservaBungalow extends JPanel {
	public JScrollPane scrollPane;
	public JPanel panel;
	public JLabel lblFoto;
	public JLabel lblBungalow;
	public JLabel lblValoracionCliente;
	public JLabel lblEstrellas;
	public JCalendar calendar;
	public JLabel lblServiciosOfertados;
	public JCheckBox chckbxGolf;
	public JCheckBox chckbxCarbon;
	public JCheckBox chckbxGaraje;
	public JCheckBox chckbxCama;
	public JCheckBox chckbxLimpieza;
	public JCheckBox chckbxLavavajillas;
	public JButton btnSiguiente;
	public JLabel lblPrecioNoche;
	public JLabel lblEuros;
	public JLabel lblNombre;
	public JTextPane tPDescripcion;
	private JProgressBar progressBar;
	public JLabel lblPrecio;

	private Alojamientos alojamientosDb;
	
	private JList lstAlojamientos;

	private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

	/**
	 * Create the panel.
	 */
	public PanelFormularioReservaBungalow(JList lstAlojamientos, Alojamientos db) {
		
		this.lstAlojamientos = lstAlojamientos;
		this.alojamientosDb = db;

		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 20, 60, 40, 10, 157, 31, 0, 90, 159, 25, 10, 20, 0 };
		gbl_panel.rowHeights = new int[] { 20, 0, 20, 0, 157, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 45, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(600, 15));
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

		lblBungalow = new JLabel("Bungalow: ");
		GridBagConstraints gbc_lblBungalow = new GridBagConstraints();
		gbc_lblBungalow.anchor = GridBagConstraints.EAST;
		gbc_lblBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_lblBungalow.gridx = 1;
		gbc_lblBungalow.gridy = 3;
		panel.add(lblBungalow, gbc_lblBungalow);

		tPDescripcion = new JTextPane();
		tPDescripcion.setContentType("text/html");
		GridBagConstraints gbc_tPDescripcion = new GridBagConstraints();
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

		lblValoracionCliente = new JLabel(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.lblValoracionCliente.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblValoracionCliente = new GridBagConstraints();
		gbc_lblValoracionCliente.anchor = GridBagConstraints.EAST;
		gbc_lblValoracionCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblValoracionCliente.gridx = 4;
		gbc_lblValoracionCliente.gridy = 6;
		panel.add(lblValoracionCliente, gbc_lblValoracionCliente);

		lblEstrellas = new JLabel("");
		GridBagConstraints gbc_lblEstrellas = new GridBagConstraints();
		gbc_lblEstrellas.anchor = GridBagConstraints.WEST;
		gbc_lblEstrellas.gridwidth = 2;
		gbc_lblEstrellas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstrellas.gridx = 5;
		gbc_lblEstrellas.gridy = 6;
		panel.add(lblEstrellas, gbc_lblEstrellas);

		lblServiciosOfertados = new JLabel(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.lblServiciosOfertados.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblServiciosOfertados = new GridBagConstraints();
		gbc_lblServiciosOfertados.anchor = GridBagConstraints.WEST;
		gbc_lblServiciosOfertados.gridwidth = 4;
		gbc_lblServiciosOfertados.insets = new Insets(0, 0, 5, 5);
		gbc_lblServiciosOfertados.gridx = 1;
		gbc_lblServiciosOfertados.gridy = 8;
		panel.add(lblServiciosOfertados, gbc_lblServiciosOfertados);

		chckbxGolf = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxGolf.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxGolf = new GridBagConstraints();
		gbc_chckbxGolf.anchor = GridBagConstraints.WEST;
		gbc_chckbxGolf.gridwidth = 4;
		gbc_chckbxGolf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGolf.gridx = 1;
		gbc_chckbxGolf.gridy = 9;
		panel.add(chckbxGolf, gbc_chckbxGolf);
		checkBoxes.add(chckbxGolf);

		chckbxCarbon = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxCarbon.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxCarbon = new GridBagConstraints();
		gbc_chckbxCarbon.anchor = GridBagConstraints.WEST;
		gbc_chckbxCarbon.gridwidth = 4;
		gbc_chckbxCarbon.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCarbon.gridx = 1;
		gbc_chckbxCarbon.gridy = 10;
		panel.add(chckbxCarbon, gbc_chckbxCarbon);
		checkBoxes.add(chckbxCarbon);

		chckbxGaraje = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxGaraje.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxGaraje = new GridBagConstraints();
		gbc_chckbxGaraje.anchor = GridBagConstraints.WEST;
		gbc_chckbxGaraje.gridwidth = 4;
		gbc_chckbxGaraje.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGaraje.gridx = 1;
		gbc_chckbxGaraje.gridy = 11;
		panel.add(chckbxGaraje, gbc_chckbxGaraje);
		checkBoxes.add(chckbxGaraje);

		chckbxCama = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxCama.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxCama = new GridBagConstraints();
		gbc_chckbxCama.anchor = GridBagConstraints.WEST;
		gbc_chckbxCama.gridwidth = 4;
		gbc_chckbxCama.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCama.gridx = 1;
		gbc_chckbxCama.gridy = 12;
		panel.add(chckbxCama, gbc_chckbxCama);
		checkBoxes.add(chckbxCama);

		lblPrecioNoche = new JLabel(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.lblPrecioNoche.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecioNoche = new GridBagConstraints();
		gbc_lblPrecioNoche.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioNoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioNoche.gridx = 8;
		gbc_lblPrecioNoche.gridy = 12;
		panel.add(lblPrecioNoche, gbc_lblPrecioNoche);

		lblPrecio = new JLabel("");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 9;
		gbc_lblPrecio.gridy = 12;
		panel.add(lblPrecio, gbc_lblPrecio);

		lblEuros = new JLabel("€");
		GridBagConstraints gbc_lblEuros = new GridBagConstraints();
		gbc_lblEuros.anchor = GridBagConstraints.WEST;
		gbc_lblEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblEuros.gridx = 10;
		gbc_lblEuros.gridy = 12;
		panel.add(lblEuros, gbc_lblEuros);

		chckbxLimpieza = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxLimpieza.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxLimpieza = new GridBagConstraints();
		gbc_chckbxLimpieza.anchor = GridBagConstraints.WEST;
		gbc_chckbxLimpieza.gridwidth = 4;
		gbc_chckbxLimpieza.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLimpieza.gridx = 1;
		gbc_chckbxLimpieza.gridy = 13;
		panel.add(chckbxLimpieza, gbc_chckbxLimpieza);
		checkBoxes.add(chckbxLimpieza);

		chckbxLavavajillas = new JCheckBox(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.chckbxLavavajillas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxLavavajillas = new GridBagConstraints();
		gbc_chckbxLavavajillas.anchor = GridBagConstraints.WEST;
		gbc_chckbxLavavajillas.gridwidth = 4;
		gbc_chckbxLavavajillas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLavavajillas.gridx = 1;
		gbc_chckbxLavavajillas.gridy = 14;
		panel.add(chckbxLavavajillas, gbc_chckbxLavavajillas);
		checkBoxes.add(chckbxLavavajillas);

		btnSiguiente = new JButton(MessagesPanelFormularioReservaBungalow.getString("PanelFormularioReservaBungalow.btnSiguiente.text")); //$NON-NLS-1$
		btnSiguiente.addActionListener(new BtnSiguienteActionListener());
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.anchor = GridBagConstraints.EAST;
		gbc_btnSiguiente.gridwidth = 2;
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSiguiente.gridx = 9;
		gbc_btnSiguiente.gridy = 15;
		panel.add(btnSiguiente, gbc_btnSiguiente);

		invalidarDias();
	}

	public void invalidarDias() {
		int index = alojamientosDb.getAlojamientos()
				.indexOf(((PanelAlojamientoRenderer) lstAlojamientos.getSelectedValue()).getAlojamiento());
		Alojamiento alojamiento = alojamientosDb.getAlojamientos().get(index);
		for (String rangoFechas : alojamiento.getFechasReservadas()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			FechasInvalidas evaluator = new FechasInvalidas();
			String[] fechas = rangoFechas.split(";");
			try {
				evaluator.setStartDate(dateFormat.parse(fechas[0]));
				evaluator.setEndDate(dateFormat.parse(fechas[1]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendar.getDayChooser().addDateEvaluator(evaluator);
		}
		calendar.setDate(Calendar.getInstance().getTime());
	}

	private class BtnSiguienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> servicios = new ArrayList<String>();
			int index = alojamientosDb.getAlojamientos()
					.indexOf(((PanelAlojamientoRenderer) lstAlojamientos.getSelectedValue()).getAlojamiento());
			Alojamiento alojamiento = alojamientosDb.getAlojamientos().get(index);
			for (JCheckBox cbx : checkBoxes) {
				if (cbx.isSelected())
					servicios.add(cbx.getText());
			}
			PanelFormularioReserva reserva = new PanelFormularioReserva(calendar, alojamiento, alojamiento.getNombre(),
					((Bungalow) alojamiento).getCapacidadMaxima(), servicios, alojamiento.getPrecio(), alojamiento.getFechasReservadas());
			JPanel padre = (JPanel) getParent();
			padre.add(reserva, "Nueva reserva");
			((CardLayout) padre.getLayout()).show(padre, "Nueva reserva");
		}
	}
}
