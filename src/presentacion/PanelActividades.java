package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Actividad;
import dominio.Monitor;
import persistencia.Actividades;

public class PanelActividades extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioActs;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaActs;
	private JButton btnCrearActividad;
	private JButton btnEliminarActividad;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;
	private JList lstActividades;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private Color colorBotonCritico = new Color(190, 68, 36);
	private Color colorBarraBusqueda = new Color(231, 227, 218);

	private Actividades actividadesDb = new Actividades(new ArrayList<Actividad>());
	/*
	 * Actividades iniciales de ejemplo.
	 */
	private PanelActividadRenderer panelEjemplo1;
	private PanelActividadRenderer panelEjemplo2;
	private PanelActividadRenderer panelEjemplo3;
	private PanelActividadRenderer panelEjemplo4;
	private PanelActividadRenderer panelEjemplo5;
	private JLabel lblLupa;

	/**
	 * Create the panel.
	 */
	public PanelActividades() {
		/*
		 * Añade las actividades de ejemplo a la "persistencia"
		 */
		Actividad actividad1 = new Actividad("Paintball", "Juan Marín Prieto", 10, "Adultos", "Ciervo",
				"El paintball es un juego de estrategia en el que compiten normalmente dos equipos. Cada jugador tiene algo "
						+ "parecido a una pistola de bolas de pintura, y el objetivo puede variar según la modalidad del juego que es"
						+ "cojas: atrapar la bandera, eliminar al equipo contrario, rescatar al presidente...",
				"Incluye la equipación", "16:00-18:00", 20.5,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./fotoPaintball.jpg")));
		Actividad actividad2 = new Actividad("Espeleología subacuática", "Martín García Ortega", 5, "Adultos", "Salmón",
				"Cuevas bajo el agua. Si descubrir los secretos de las cuevas y galerías nos abre un mundo, imagínate la "
						+ "sensación cuando esto ocurre debajo del agua. ",
				"Incluye la equipación", "11:00-12:00", 150.0,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./fotoEspeleologiaAcuatica.jpg")));
		Actividad actividad3 = new Actividad("Karts Infantil", "Martín García Ortega", 8, "Niños de 12 a 14 años",
				"Escorpión",
				"Las instalaciones constan de una pista de 10m de ancho y 1100m de cuerda.Esta pista cuenta con todas las "
						+ "normas de seguridad de la real federacion de automovilismo y de la CIK/FIA por que podremos disfrutar de "
						+ "toda la adrenalina generada sin preocupaciones.",
				"Incluye el kart y la equipación", "9:00-12:00", 14.5,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./fotoKartInf.jpg")));
		Actividad actividad4 = new Actividad("Karts Junior", "Juan Marín Prieto", 10, "Niños de 14 a 17 años", "Ciervo",
				"Las instalaciones constan de una pista de 10m de ancho y 1100m de cuerda.Esta pista cuenta con todas las "
						+ "normas de seguridad de la real federacion de automovilismo y de la CIK/FIA por que podremos disfrutar de "
						+ "toda la adrenalina generada sin preocupaciones.",
				"Incluye el kart y la equipación", "10:00-11:30", 18.5,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./fotoKartJunior.jpg")));
		Actividad actividad5 = new Actividad("Karts Adultos", "Juan Marín Prieto", 12, "Adultos", "Águila",
				"Las instalaciones constan de una pista de 10m de ancho y 1100m de cuerda.Esta pista cuenta con todas las "
						+ "normas de seguridad de la real federacion de automovilismo y de la CIK/FIA por que podremos disfrutar de "
						+ "toda la adrenalina generada sin preocupaciones.",
				"Incluye el kart y la equipación", "19:00-21:00", 22.5,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./fotoKartAdultos.jpg")));

		actividadesDb.addActividad(actividad1);
		actividadesDb.addActividad(actividad2);
		actividadesDb.addActividad(actividad3);
		actividadesDb.addActividad(actividad4);
		actividadesDb.addActividad(actividad5);
		panelEjemplo1 = new PanelActividadRenderer(actividad1);
		panelEjemplo2 = new PanelActividadRenderer(actividad2);
		panelEjemplo3 = new PanelActividadRenderer(actividad3);
		panelEjemplo4 = new PanelActividadRenderer(actividad4);
		panelEjemplo5 = new PanelActividadRenderer(actividad5);

		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setMinimumSize(new Dimension(462, 25));
		add(splitPane, BorderLayout.CENTER);

		pnlFormularioActs = new JPanel();
		splitPane.setRightComponent(pnlFormularioActs);
		pnlFormularioActs.setLayout(new CardLayout(0, 0));

		scrollPaneListaActs = new JScrollPane();
		scrollPaneListaActs.setMinimumSize(new Dimension(420, 23));
		splitPane.setLeftComponent(scrollPaneListaActs);

		lstActividades = new JList();
		lstActividades.addListSelectionListener(new LstActividadesListSelectionListener());
		lstActividades.setMinimumSize(new Dimension(440, 23));
		scrollPaneListaActs.setViewportView(lstActividades);

		// lstActividades.addListSelectionListener(new
		// LstActividadesListSelectionListener());
		DefaultListModel lstModel = new DefaultListModel();

		lstModel.addElement(panelEjemplo1);
		lstModel.addElement(panelEjemplo2);
		lstModel.addElement(panelEjemplo3);
		lstModel.addElement(panelEjemplo4);
		lstModel.addElement(panelEjemplo5);

		lstActividades.setModel(lstModel);
		lstActividades.setFixedCellHeight(220);
		lstActividades.setCellRenderer(new ActividadRenderer());

		lstActividades.setMinimumSize(new Dimension(200, 23));
		scrollPaneListaActs.setViewportView(lstActividades);

		pnlGestionBusqueda = new JPanel();
		pnlGestionBusqueda.setBackground(colorBarraBusqueda);
		add(pnlGestionBusqueda, BorderLayout.NORTH);
		GridBagLayout gbl_pnlGestionBusqueda = new GridBagLayout();
		gbl_pnlGestionBusqueda.columnWidths = new int[] { 56, 83, 171, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlGestionBusqueda.rowHeights = new int[] { 19, 33, 0, 0 };
		gbl_pnlGestionBusqueda.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlGestionBusqueda.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlGestionBusqueda.setLayout(gbl_pnlGestionBusqueda);

		btnCrearActividad = new JButton("Crear Actividad");
		btnCrearActividad.setForeground(Color.BLACK);
		btnCrearActividad.setBackground(colorBoton);
		btnCrearActividad.setFocusPainted(false);
		GridBagConstraints gbc_btnCrearActividad = new GridBagConstraints();
		gbc_btnCrearActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearActividad.gridx = 1;
		gbc_btnCrearActividad.gridy = 1;
		pnlGestionBusqueda.add(btnCrearActividad, gbc_btnCrearActividad);

		btnEliminarActividad = new JButton("Eliminar Actividad");
		btnEliminarActividad.setForeground(Color.BLACK);
		btnEliminarActividad.setBackground(colorBotonCritico);
		btnEliminarActividad.setFocusPainted(false);
		GridBagConstraints gbc_btnEliminarActividad = new GridBagConstraints();
		gbc_btnEliminarActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarActividad.gridx = 2;
		gbc_btnEliminarActividad.gridy = 1;
		pnlGestionBusqueda.add(btnEliminarActividad, gbc_btnEliminarActividad);

		lblBarraBusqueda = new JLabel("Barra de búsqueda:");
		lblBarraBusqueda.setBackground(colorFondo);
		lblBarraBusqueda.setAlignmentX(1.0f);
		GridBagConstraints gbc_lblBarraBusqueda = new GridBagConstraints();
		gbc_lblBarraBusqueda.anchor = GridBagConstraints.EAST;
		gbc_lblBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarraBusqueda.gridx = 4;
		gbc_lblBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(lblBarraBusqueda, gbc_lblBarraBusqueda);

		txtBarraBusqueda = new JTextField();
		txtBarraBusqueda.addActionListener(new TxtBarraBusquedaActionListener());
		GridBagConstraints gbc_txtBarraBusqueda = new GridBagConstraints();
		gbc_txtBarraBusqueda.gridwidth = 2;
		gbc_txtBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBarraBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBarraBusqueda.gridx = 5;
		gbc_txtBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(txtBarraBusqueda, gbc_txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);

		lblLupa = new JLabel("");
		lblLupa.setIcon(new ImageIcon(PanelActividades.class.getResource("/presentacion/lupa.png")));
		GridBagConstraints gbc_lblLupa = new GridBagConstraints();
		gbc_lblLupa.insets = new Insets(0, 0, 5, 5);
		gbc_lblLupa.gridx = 8;
		gbc_lblLupa.gridy = 1;
		pnlGestionBusqueda.add(lblLupa, gbc_lblLupa);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioActs.add(formularioVacio);

	}

	private class LstActividadesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			Actividad actividadSeleccionada = actividadesDb.getActividades().get(lstActividades.getSelectedIndex());
			PanelFormularioActividades panelActividadInfoCompleta = new PanelFormularioActividades();
			panelActividadInfoCompleta.lblFoto.setIcon(actividadSeleccionada.getFotoActividad());
			panelActividadInfoCompleta.txtNombre.setText(actividadSeleccionada.getNombre());
			panelActividadInfoCompleta.txtMonitor.setText(actividadSeleccionada.getMonitor());
			panelActividadInfoCompleta.spinCupo.setValue(actividadSeleccionada.getCupo());
			panelActividadInfoCompleta.cbDestinatarios.setSelectedItem(actividadSeleccionada.getDestinatario());
			panelActividadInfoCompleta.cbArea.setSelectedItem(actividadSeleccionada.getArea());
			panelActividadInfoCompleta.tADescripcion.setText(actividadSeleccionada.getDescripcion());
			panelActividadInfoCompleta.tAMateriales.setText(actividadSeleccionada.getMateriales());
			panelActividadInfoCompleta.txtPrecio.setText(actividadSeleccionada.getPrecio().toString());
			panelActividadInfoCompleta.cbHorario.setSelectedItem(actividadSeleccionada.getHorario());

			pnlFormularioActs.add(panelActividadInfoCompleta, actividadSeleccionada.getNombre());
			((CardLayout) pnlFormularioActs.getLayout()).show(pnlFormularioActs, actividadSeleccionada.getNombre());

			panelActividadInfoCompleta.btnAniadirAvatar.setEnabled(false);
			panelActividadInfoCompleta.btnAplicarCambios.setEnabled(false);
			panelActividadInfoCompleta.txtNombre.setEditable(false);
			panelActividadInfoCompleta.txtMonitor.setEditable(false);
			panelActividadInfoCompleta.txtPrecio.setEditable(false);
			panelActividadInfoCompleta.spinCupo.setEnabled(false);
			panelActividadInfoCompleta.tADescripcion.setEnabled(false);
			panelActividadInfoCompleta.tAMateriales.setEnabled(false);
			panelActividadInfoCompleta.cbDestinatarios.setEnabled(false);
			panelActividadInfoCompleta.cbArea.setEnabled(false);
			panelActividadInfoCompleta.cbHorario.setEnabled(false);
		}
	}

	private class TxtBarraBusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombreActividad;
			Actividad actividad;
			int result = -1, i = 0;
			DefaultListModel modeloMonitores = (DefaultListModel) lstActividades.getModel();
			for (; i < modeloMonitores.getSize(); ++i) {
				actividad = actividadesDb.getActividades().get(i);
				nombreActividad = actividad.getNombre();
				if (nombreActividad.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstActividades.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null, "La actividad que has buscado no existe en la lista",
						"Busqueda erronea", JOptionPane.ERROR_MESSAGE);
		}
	}
}
