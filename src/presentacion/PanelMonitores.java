package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import dominio.Monitor;
import persistencia.Monitores;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMonitores extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioMons;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaMons;
	private JButton btnAniadirMonitor;
	private JButton btnEliminarMonitor;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;
	private JList lstMonitores;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private Color colorBotonCritico = new Color(190, 68, 36);
	private Color colorBarraBusqueda = new Color(231, 227, 218);

	private Monitores monitoresDb = new Monitores(new ArrayList<Monitor>());
	/*
	 * Monitores iniciales de ejemplo.
	 */
	private PanelMonitorRenderer panelEjemplo1;
	private PanelMonitorRenderer panelEjemplo2;
	private PanelMonitorRenderer panelEjemplo3;
	private JLabel lblLupa;

	/**
	 * Create the panel.
	 */
	public PanelMonitores() {

		/*
		 * Añade los monitores de ejemplo a la "persistencia"
		 */
		ArrayList<String> idiomas1 = new ArrayList<String>();
		idiomas1.add("Castellano");
		idiomas1.add("Inglés");
		idiomas1.add("Francés");
		ArrayList<String> idiomas2 = new ArrayList<String>();
		idiomas2.add("Castellano");
		idiomas2.add("Francés");
		ArrayList<String> idiomas3 = new ArrayList<String>();
		idiomas3.add("Castellano");
		idiomas3.add("Noruego");
		idiomas3.add("Alemán");
		Monitor monitorEjemplo1 = new Monitor("Juan", "Marín Prieto", "05718928T", "654738273", null,
				"juanmapriSi@gmail.com", "Estudios Universitarios", "Disponible", "8:00-15:00", 1000.0, 24, idiomas1,
				new ImageIcon(PanelMonitorRenderer.class.getResource("./avatarMonitorEjemplo1.png")));
		Monitor monitorEjemplo2 = new Monitor("Eva", "Grande Milagro", "05283928L", "654839283", "926 46 82 91",
				"powerJapan90@yahoo.com", "Educación Secundaria Obligatoria", "Baja laboral", "17:30-22:30", 1235.5, 20,
				idiomas2, new ImageIcon(PanelMonitorRenderer.class.getResource("./avatarMonitorEjemplo2.png")));
		Monitor monitorEjemplo3 = new Monitor("Martín", "García Ortega", "05673822Q", "625890973", null,
				"destroyerManhattan@gmail.com", "Estudios post-universitarios", "Vacaciones", "15:00-23:00", 1540.0, 30,
				idiomas3, new ImageIcon(PanelMonitorRenderer.class.getResource("./avatarMonitorEjemplo3.png")));
		monitoresDb.addMonitor(monitorEjemplo1);
		monitoresDb.addMonitor(monitorEjemplo2);
		monitoresDb.addMonitor(monitorEjemplo3);

		panelEjemplo1 = new PanelMonitorRenderer(monitorEjemplo1);
		panelEjemplo2 = new PanelMonitorRenderer(monitorEjemplo2);
		panelEjemplo3 = new PanelMonitorRenderer(monitorEjemplo3);

		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setMinimumSize(new Dimension(462, 25));
		add(splitPane, BorderLayout.CENTER);

		pnlFormularioMons = new JPanel();
		splitPane.setRightComponent(pnlFormularioMons);
		pnlFormularioMons.setLayout(new CardLayout(0, 0));

		scrollPaneListaMons = new JScrollPane();
		scrollPaneListaMons.setMinimumSize(new Dimension(450, 15));
		splitPane.setLeftComponent(scrollPaneListaMons);

		lstMonitores = new JList();
		lstMonitores.addListSelectionListener(new LstMonitoresListSelectionListener());
		DefaultListModel lstModel = new DefaultListModel();

		lstModel.addElement(panelEjemplo1);
		lstModel.addElement(panelEjemplo2);
		lstModel.addElement(panelEjemplo3);
		lstMonitores.setModel(lstModel);
		lstMonitores.setFixedCellHeight(220);
		lstMonitores.setCellRenderer(new MonitorRenderer());

		lstMonitores.setMinimumSize(new Dimension(200, 23));
		scrollPaneListaMons.setViewportView(lstMonitores);

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

		btnAniadirMonitor = new JButton("Añadir nuevo monitor");
		btnAniadirMonitor.addActionListener(new BtnAniadirMonitorActionListener());
		btnAniadirMonitor.setForeground(Color.BLACK);
		btnAniadirMonitor.setBackground(colorBoton);
		btnAniadirMonitor.setFocusPainted(false);
		GridBagConstraints gbc_btnAniadirMonitor = new GridBagConstraints();
		gbc_btnAniadirMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirMonitor.gridx = 1;
		gbc_btnAniadirMonitor.gridy = 1;
		pnlGestionBusqueda.add(btnAniadirMonitor, gbc_btnAniadirMonitor);

		btnEliminarMonitor = new JButton("Dar de baja al monitor");
		btnEliminarMonitor.addActionListener(new BtnEliminarMonitorActionListener());
		btnEliminarMonitor.setForeground(Color.BLACK);
		btnEliminarMonitor.setBackground(colorBotonCritico);
		btnEliminarMonitor.setFocusPainted(false);
		GridBagConstraints gbc_btnEliminarMonitor = new GridBagConstraints();
		gbc_btnEliminarMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarMonitor.gridx = 2;
		gbc_btnEliminarMonitor.gridy = 1;
		pnlGestionBusqueda.add(btnEliminarMonitor, gbc_btnEliminarMonitor);

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
		txtBarraBusqueda.addActionListener(new BusquedaActionListener());
		GridBagConstraints gbc_txtBarraBusqueda = new GridBagConstraints();
		gbc_txtBarraBusqueda.gridwidth = 2;
		gbc_txtBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBarraBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBarraBusqueda.gridx = 5;
		gbc_txtBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(txtBarraBusqueda, gbc_txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);

		lblLupa = new JLabel("");
		lblLupa.addMouseListener(new LblLupaMouseListener());
		lblLupa.setIcon(new ImageIcon(PanelMonitores.class.getResource("/presentacion/lupa.png")));
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_lblLupa = new GridBagConstraints();
		gbc_lblLupa.insets = new Insets(0, 0, 5, 5);
		gbc_lblLupa.gridx = 8;
		gbc_lblLupa.gridy = 1;
		pnlGestionBusqueda.add(lblLupa, gbc_lblLupa);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioMons.add(formularioVacio, "Formulario vacio");

	}

	private class LstMonitoresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (monitoresDb.getMonitores().get(lstMonitores.getModel().getSize() - 1).getAvatar() == null)
				// En caso de dejar incompleta la agregacion de un nuevo monitor, eliminarlo de
				// la lista
				monitoresDb.getMonitores().remove(lstMonitores.getModel().getSize() - 1);
			if (lstMonitores.getSelectedIndex() != -1) {
				Monitor monitorSeleccionado = monitoresDb.getMonitores().get(lstMonitores.getSelectedIndex());
				PanelFormularioMonitores panelMonitorInfoCompleta = new PanelFormularioMonitores(lstMonitores,
						monitoresDb, lstMonitores.getSelectedIndex());
				panelMonitorInfoCompleta.lblAvatar.setIcon(monitorSeleccionado.getAvatar());
				panelMonitorInfoCompleta.txtNombre.setText(monitorSeleccionado.getNombre());
				panelMonitorInfoCompleta.spnEdad.setValue(monitorSeleccionado.getEdad());
				panelMonitorInfoCompleta.txtApellidos.setText(monitorSeleccionado.getApellidos());
				panelMonitorInfoCompleta.ftxtDNI.setText(monitorSeleccionado.getDni());
				panelMonitorInfoCompleta.ftxtMovil.setText(monitorSeleccionado.getMovil());
				panelMonitorInfoCompleta.ftxtFijo.setText(monitorSeleccionado.getFijo());
				panelMonitorInfoCompleta.txtCorreo.setText(monitorSeleccionado.getCorreo());
				panelMonitorInfoCompleta.cbEstudios.setSelectedItem(monitorSeleccionado.getEstudios());
				panelMonitorInfoCompleta.txtSueldo.setText(monitorSeleccionado.getSueldo().toString());
				panelMonitorInfoCompleta.cbHorario.setSelectedItem(monitorSeleccionado.getHorario());
				panelMonitorInfoCompleta.cbDisponibilidad.setSelectedItem(monitorSeleccionado.getDisponibilidad());
				DefaultListModel model = new DefaultListModel();
				for (String idioma : monitorSeleccionado.getIdiomas())
					model.addElement(idioma);
				panelMonitorInfoCompleta.lstIdiomas.setModel(model);
				pnlFormularioMons.add(panelMonitorInfoCompleta, monitorSeleccionado.getDni());
				((CardLayout) pnlFormularioMons.getLayout()).show(pnlFormularioMons, monitorSeleccionado.getDni());

				panelMonitorInfoCompleta.btnAniadirAvatar.setEnabled(false);
				panelMonitorInfoCompleta.btnAplicarCambios.setEnabled(false);
				panelMonitorInfoCompleta.btnAniadirIdioma.setEnabled(false);
				panelMonitorInfoCompleta.lstIdiomas.setEnabled(false);
				panelMonitorInfoCompleta.txtNombre.setEnabled(false);
				panelMonitorInfoCompleta.txtApellidos.setEnabled(false);
				panelMonitorInfoCompleta.spnEdad.setEnabled(false);
				panelMonitorInfoCompleta.ftxtDNI.setEnabled(false);
				panelMonitorInfoCompleta.ftxtMovil.setEnabled(false);
				panelMonitorInfoCompleta.ftxtFijo.setEnabled(false);
				panelMonitorInfoCompleta.txtCorreo.setEnabled(false);
				panelMonitorInfoCompleta.txtSueldo.setEnabled(false);
				panelMonitorInfoCompleta.cbHorario.setEnabled(false);
				panelMonitorInfoCompleta.cbEstudios.setEnabled(false);
				panelMonitorInfoCompleta.cbDisponibilidad.setEnabled(false);

				UIManager.getDefaults().put("Button.disabledText", Color.DARK_GRAY);
				UIManager.getDefaults().put("ComboBox.disabledText", Color.DARK_GRAY);
			}
		}
	}

	private class BusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombreMonitor;
			Monitor monitor;
			int result = -1, i = 0;
			DefaultListModel modeloMonitores = (DefaultListModel) lstMonitores.getModel();
			for (; i < modeloMonitores.getSize(); ++i) {
				monitor = monitoresDb.getMonitores().get(i);
				nombreMonitor = monitor.getNombre() + " " + monitor.getApellidos();
				if (nombreMonitor.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstMonitores.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null, "El monitor que has buscado no existe en la lista",
						"Busqueda erronea", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class BtnAniadirMonitorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lstMonitores.clearSelection();
			PanelFormularioMonitores panelMonitorInfoCompleta = new PanelFormularioMonitores(lstMonitores, monitoresDb,
					lstMonitores.getModel().getSize());
			panelMonitorInfoCompleta.btnModificar.setEnabled(false);
			pnlFormularioMons.add(panelMonitorInfoCompleta, "Nuevo monitor");
			// Añadir monitor vacio a la lista, si no se completa el formulario, se elimina.
			monitoresDb.addMonitor(new Monitor());
			((CardLayout) pnlFormularioMons.getLayout()).show(pnlFormularioMons, "Nuevo monitor");
		}
	}

	private class BtnEliminarMonitorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] options = {"Sí", "No"};
			int seleccion = JOptionPane.showOptionDialog(null, "¿Está seguro de eliminar el monitor "
					+ "seleccionado en la lista?", "Eliminar monitor", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (seleccion == 0) {
				int indiceMonitorElminado = lstMonitores.getSelectedIndex();
				DefaultListModel modelo = (DefaultListModel) lstMonitores.getModel();
				modelo.remove(indiceMonitorElminado);
				monitoresDb.getMonitores().remove(indiceMonitorElminado);
				((CardLayout) pnlFormularioMons.getLayout()).show(pnlFormularioMons, "Formulario vacio");
			}
			if (monitoresDb.getMonitores().size() == 0)
				((CardLayout) pnlFormularioMons.getLayout()).show(pnlFormularioMons, "Formulario vacio");
		}
	}

	// No podemos usar el actionPerformed porque no esta permitido en las JLabel
	private class LblLupaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String nombreMonitor;
			Monitor monitor;
			int result = -1, i = 0;
			DefaultListModel modeloMonitores = (DefaultListModel) lstMonitores.getModel();
			for (; i < modeloMonitores.getSize(); ++i) {
				monitor = monitoresDb.getMonitores().get(i);
				nombreMonitor = monitor.getNombre() + " " + monitor.getApellidos();
				if (nombreMonitor.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstMonitores.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null, "El monitor que has buscado no existe en la lista",
						"Busqueda erronea", JOptionPane.ERROR_MESSAGE);
		}
	}
}
