package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import dominio.Monitor;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PanelMonitores extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioMons;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaMons;
	private JButton btnAñadirMonitor;
	private JButton btnEliminarMonitor;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;
	private JList lstMonitores;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private Color colorBotonCritico = new Color(190, 68, 36);
	private Color colorBarraBusqueda = new Color(231, 227, 218);
	/*
	 * Monitores iniciales de ejemplo.
	 */
	private ArrayList<String> idiomas = new ArrayList<String>();
	Monitor monitorEjemplo1 = new Monitor("Juan", "Marín Prieto", "05718928T", "654738273", null,
			"juanmapriSi@gmail.com", "Grado universitario", "Disponible", "8:00-15:00", 1000.0, 24, idiomas);
	private PanelMonitorRenderer panelEjemplo1 = new PanelMonitorRenderer("./avatarMonitorEjemplo1.png",
			monitorEjemplo1);

	/**
	 * Create the panel.
	 */
	public PanelMonitores() {
		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		pnlFormularioMons = new JPanel();
		splitPane.setRightComponent(pnlFormularioMons);
		pnlFormularioMons.setLayout(new CardLayout(0, 0));

		scrollPaneListaMons = new JScrollPane();
		scrollPaneListaMons.setMinimumSize(new Dimension(200, 23));
		splitPane.setLeftComponent(scrollPaneListaMons);

		lstMonitores = new JList();
		lstMonitores.addListSelectionListener(new LstMonitoresListSelectionListener());
		DefaultListModel lstModel = new DefaultListModel();
		lstModel.addElement(panelEjemplo1);
		lstMonitores.setModel(lstModel);
		lstMonitores.setFixedCellHeight(220);
		lstMonitores.setCellRenderer(new MonitorRenderer());

		lstMonitores.setMinimumSize(new Dimension(200, 23));
		scrollPaneListaMons.setViewportView(lstMonitores);

		pnlGestionBusqueda = new JPanel();
		pnlGestionBusqueda.setBackground(colorBarraBusqueda);
		add(pnlGestionBusqueda, BorderLayout.NORTH);
		GridBagLayout gbl_pnlGestionBusqueda = new GridBagLayout();
		gbl_pnlGestionBusqueda.columnWidths = new int[] { 56, 83, 171, 0, 0, 0, 0, 0, 0 };
		gbl_pnlGestionBusqueda.rowHeights = new int[] { 19, 33, 0, 0 };
		gbl_pnlGestionBusqueda.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlGestionBusqueda.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlGestionBusqueda.setLayout(gbl_pnlGestionBusqueda);

		btnAñadirMonitor = new JButton("Añadir nuevo monitor");
		btnAñadirMonitor.setForeground(Color.BLACK);
		btnAñadirMonitor.setBackground(colorBoton);
		btnAñadirMonitor.setFocusPainted(false);
		GridBagConstraints gbc_btnAñadirMonitor = new GridBagConstraints();
		gbc_btnAñadirMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_btnAñadirMonitor.gridx = 1;
		gbc_btnAñadirMonitor.gridy = 1;
		pnlGestionBusqueda.add(btnAñadirMonitor, gbc_btnAñadirMonitor);

		btnEliminarMonitor = new JButton("Dar de baja al monitor");
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
		GridBagConstraints gbc_txtBarraBusqueda = new GridBagConstraints();
		gbc_txtBarraBusqueda.gridwidth = 2;
		gbc_txtBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBarraBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBarraBusqueda.gridx = 5;
		gbc_txtBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(txtBarraBusqueda, gbc_txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioMons.add(formularioVacio);
	}

	private class LstMonitoresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			System.out.println("Ay que me has pinchaoooo "
					+ ((PanelMonitorRenderer) lstMonitores.getSelectedValue()).getLblAvatar().getText());
		}
	}
}
