package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Ruta;
import dominio.Monitor;
import persistencia.Monitores;
import persistencia.Rutas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelRutas extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioRutas;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaRutas;
	private JButton btnDiseniarRuta;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;
	private JList lstRutas;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private Color colorBotonCritico = new Color(190, 68, 36);
	private Color colorBarraBusqueda = new Color(231, 227, 218);

	private Rutas rutasDb = new Rutas(new ArrayList<Ruta>());
	private Monitores monitoresDb;
	/*
	 * Actividades iniciales de ejemplo.
	 */
	private PanelRutaRenderer panelEjemplo1;
	private PanelRutaRenderer panelEjemplo2;
	private PanelRutaRenderer panelEjemplo3;
	private PanelRutaRenderer panelEjemplo4;
	private JLabel lblLupa;

	/**
	 * Create the panel.
	 */
	public PanelRutas(Monitores monitoresDb) {
		/*
		 * Añade las actividades de ejemplo a la "persistencia"
		 */

		ImageIcon image1 = new ImageIcon(PanelMonitorRenderer.class.getResource("./ruta1.png"));
		Image imagenEscalada1 = image1.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image1 = new ImageIcon(imagenEscalada1);
		ImageIcon image2 = new ImageIcon(PanelMonitorRenderer.class.getResource("./ruta2.png"));
		Image imagenEscalada2 = image2.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image2 = new ImageIcon(imagenEscalada2);
		ImageIcon image3 = new ImageIcon(PanelMonitorRenderer.class.getResource("./ruta3.png"));
		Image imagenEscalada3 = image3.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image3 = new ImageIcon(imagenEscalada3);
		ImageIcon image4 = new ImageIcon(PanelMonitorRenderer.class.getResource("./ruta4.jpg"));
		Image imagenEscalada4 = image4.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image4 = new ImageIcon(imagenEscalada4);

		ArrayList<Monitor> monitoresRutas = new ArrayList<Monitor>();
		this.monitoresDb = monitoresDb;
		for (int i = 0; i < monitoresDb.getMonitores().size(); ++i)
			if (i % 2 == 0)
				monitoresRutas.add(monitoresDb.getMonitores().get(i));

		Ruta ruta1 = new Ruta("Sendero Punta del Boquerón", "Lunes", "9:00 - 11:00", "Restaurante El Comilón", "Media",
				"Este sendero escarposo tiene fama por desgastar muchas calorias con subidas de hasta 9º que se pueden extender hasta 100 metros. Se recomienda venir con cantimplora con agua y sombrero debido a lo cercano que está el Sol.",
				monitoresRutas, 15, image1);
		Ruta ruta2 = new Ruta("Camino de los Angeles", "Viernes", "18:30 - 20:00", "Marca número 5 del Río Mudez",
				"Baja",
				"Largo camino destacable por el terreno llano que lo abarca. A medio camino se atraviesa la cueva Múdez, por lo que se recomienda un casco con linterna incorporada y calzado cómodo para evitar resbalones.",
				monitoresRutas, 10, image2);
		Ruta ruta3 = new Ruta("Sendero de la Magdalena", "Martes", "10:15 - 11:30", "A los pies del monte Picudo",
				"Extrema",
				"Este sendero se caracteriza por su elevada dificultad, solo apto para expertos. Incluye escalada y 5 km de bici, además de atravesar una zona empinada de difícil acceso. Se exige experiencia en escalada para realizar esta ruta.",
				monitoresRutas, 10, image3);
		Ruta ruta4 = new Ruta("Camino de la Risa", "Miércoles", "11:00 - 14:00", "Marca número 5 del Río Mudez", "Alta",
				"El camino de la risa, pese a su nombre, no es que sea fácil. Destacamos el tramo a canoa por el río Múdez y un largo recorrido por un camino rocoso. Destaca por la longitud del camino. Se aconseja traer: agua, comida, calzado cómodo y gorra.",
				monitoresRutas, 20, image4);

		rutasDb.addRuta(ruta1);
		rutasDb.addRuta(ruta2);
		rutasDb.addRuta(ruta3);
		rutasDb.addRuta(ruta4);
		panelEjemplo1 = new PanelRutaRenderer(ruta1);
		panelEjemplo2 = new PanelRutaRenderer(ruta2);
		panelEjemplo3 = new PanelRutaRenderer(ruta3);
		panelEjemplo4 = new PanelRutaRenderer(ruta4);

		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		// splitPane.setPreferredSize(new Dimension(500, 25));
		splitPane.setMinimumSize(new Dimension(462, 25));
		add(splitPane, BorderLayout.CENTER);

		pnlFormularioRutas = new JPanel();
		splitPane.setRightComponent(pnlFormularioRutas);
		pnlFormularioRutas.setLayout(new CardLayout(0, 0));

		scrollPaneListaRutas = new JScrollPane();
		scrollPaneListaRutas.setMinimumSize(new Dimension(520, 23));
		splitPane.setLeftComponent(scrollPaneListaRutas);

		lstRutas = new JList();
		lstRutas.addListSelectionListener(new LstActividadesListSelectionListener());
		lstRutas.setMinimumSize(new Dimension(1000, 25));
		scrollPaneListaRutas.setViewportView(lstRutas);

		DefaultListModel lstModel = new DefaultListModel();

		lstModel.addElement(panelEjemplo1);
		lstModel.addElement(panelEjemplo2);
		lstModel.addElement(panelEjemplo3);
		lstModel.addElement(panelEjemplo4);

		lstRutas.setModel(lstModel);
		lstRutas.setFixedCellHeight(220);
		lstRutas.setFixedCellWidth(520);
		lstRutas.setCellRenderer(new ActividadRenderer());

		lstRutas.setMinimumSize(new Dimension(400, 23));
		scrollPaneListaRutas.setViewportView(lstRutas);

		pnlGestionBusqueda = new JPanel();
		pnlGestionBusqueda.setBackground(colorBarraBusqueda);
		add(pnlGestionBusqueda, BorderLayout.NORTH);
		GridBagLayout gbl_pnlGestionBusqueda = new GridBagLayout();
		gbl_pnlGestionBusqueda.columnWidths = new int[] { 56, 83, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlGestionBusqueda.rowHeights = new int[] { 19, 33, 0, 0 };
		gbl_pnlGestionBusqueda.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlGestionBusqueda.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlGestionBusqueda.setLayout(gbl_pnlGestionBusqueda);

		btnDiseniarRuta = new JButton("Diseñar una nueva ruta");
		btnDiseniarRuta.addActionListener(new BtnCrearRutaActionListener());
		btnDiseniarRuta.setForeground(Color.BLACK);
		btnDiseniarRuta.setBackground(colorBoton);
		btnDiseniarRuta.setFocusPainted(false);
		GridBagConstraints gbc_btnDiseniarRuta = new GridBagConstraints();
		gbc_btnDiseniarRuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnDiseniarRuta.gridx = 1;
		gbc_btnDiseniarRuta.gridy = 1;
		pnlGestionBusqueda.add(btnDiseniarRuta, gbc_btnDiseniarRuta);

		lblBarraBusqueda = new JLabel("Barra de búsqueda:");
		lblBarraBusqueda.setBackground(colorFondo);
		lblBarraBusqueda.setAlignmentX(1.0f);
		GridBagConstraints gbc_lblBarraBusqueda = new GridBagConstraints();
		gbc_lblBarraBusqueda.anchor = GridBagConstraints.EAST;
		gbc_lblBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarraBusqueda.gridx = 3;
		gbc_lblBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(lblBarraBusqueda, gbc_lblBarraBusqueda);

		txtBarraBusqueda = new JTextField();
		txtBarraBusqueda.addActionListener(new TxtBarraBusquedaActionListener());
		GridBagConstraints gbc_txtBarraBusqueda = new GridBagConstraints();
		gbc_txtBarraBusqueda.gridwidth = 2;
		gbc_txtBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBarraBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBarraBusqueda.gridx = 4;
		gbc_txtBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(txtBarraBusqueda, gbc_txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);

		lblLupa = new JLabel("");
		lblLupa.addMouseListener(new LblLupaMouseListener());
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLupa.setIcon(new ImageIcon(PanelRutas.class.getResource("/presentacion/lupa.png")));
		GridBagConstraints gbc_lblLupa = new GridBagConstraints();
		gbc_lblLupa.insets = new Insets(0, 0, 5, 5);
		gbc_lblLupa.gridx = 7;
		gbc_lblLupa.gridy = 1;
		pnlGestionBusqueda.add(lblLupa, gbc_lblLupa);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioRutas.add(formularioVacio, "Formulario vacio");

	}

	private class LstActividadesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
//			if (rutasDb.getRutas().get(lstRutas.getModel().getSize() - 1).getFoto() == null)
//				// En caso de dejar incompleta la agregacion de una nueva ruta, eliminarla
//				// de
//				// la lista
//				actividadesDb.getActividades().remove(lstRutas.getModel().getSize() - 1);
			if (lstRutas.getSelectedIndex() != -1) {
				Ruta rutaSeleccionada = rutasDb.getRutas().get(lstRutas.getSelectedIndex());
				PanelFormularioRutas panelRutaInfoCompleta = new PanelFormularioRutas(lstRutas, rutasDb,
						lstRutas.getSelectedIndex(), monitoresDb);
				ImageIcon foto = rutaSeleccionada.getFoto();
				Image imagenEscalada = foto.getImage().getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
				ImageIcon fotoForm = new ImageIcon(imagenEscalada);
				panelRutaInfoCompleta.lblFoto.setIcon(fotoForm);
				panelRutaInfoCompleta.txtNombre.setText(rutaSeleccionada.getNombre());
				panelRutaInfoCompleta.cbDia.setSelectedItem(rutaSeleccionada.getDia());
				panelRutaInfoCompleta.cbHorario.setSelectedItem(rutaSeleccionada.getHorario());
				panelRutaInfoCompleta.spinCupo.setValue(rutaSeleccionada.getCupo());
				panelRutaInfoCompleta.txtEncuentro.setText(rutaSeleccionada.getEncuentro());
				panelRutaInfoCompleta.cbDificultad.setSelectedItem(rutaSeleccionada.getDificultad());
				panelRutaInfoCompleta.tPDescripcion.setText(rutaSeleccionada.getDescripcion());

				pnlFormularioRutas.add(panelRutaInfoCompleta, rutaSeleccionada.getNombre());
				((CardLayout) pnlFormularioRutas.getLayout()).show(pnlFormularioRutas, rutaSeleccionada.getNombre());

				panelRutaInfoCompleta.btnAniadirAvatar.setEnabled(false);
				panelRutaInfoCompleta.btnAplicarCambios.setEnabled(false);
				panelRutaInfoCompleta.txtNombre.setEditable(false);
				panelRutaInfoCompleta.spinCupo.setEnabled(false);
				panelRutaInfoCompleta.cbDificultad.setEnabled(false);

				UIManager.getDefaults().put("Button.disabledText", Color.DARK_GRAY);
				UIManager.getDefaults().put("ComboBox.disabledText", Color.DARK_GRAY);
			}
		}
	}

	private class TxtBarraBusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombreRuta;
			Ruta ruta;
			int result = -1, i = 0;
			DefaultListModel modeloRutas = (DefaultListModel) lstRutas.getModel();
			for (; i < modeloRutas.getSize(); ++i) {
				ruta = rutasDb.getRutas().get(i);
				nombreRuta = ruta.getNombre();
				if (nombreRuta.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstRutas.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null, "La ruta que has buscado no existe en la lista",
						"Busqueda erronea", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class BtnCrearRutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lstRutas.clearSelection();
			PanelEditorRutas panelEditor = new PanelEditorRutas(monitoresDb, rutasDb, lstRutas);
			pnlFormularioRutas.add(panelEditor, "Nueva ruta");
			((CardLayout) pnlFormularioRutas.getLayout()).show(pnlFormularioRutas, "Nueva ruta");
		}
	}

	private class LblLupaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String nombreRuta;
			Ruta ruta;
			int result = -1, i = 0;
			DefaultListModel modeloRutas = (DefaultListModel) lstRutas.getModel();
			for (; i < modeloRutas.getSize(); ++i) {
				ruta = rutasDb.getRutas().get(i);
				nombreRuta = ruta.getNombre();
				if (nombreRuta.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstRutas.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null, "La ruta que has buscado no existe en la lista",
						"Busqueda erronea", JOptionPane.ERROR_MESSAGE);
		}
	}
}
