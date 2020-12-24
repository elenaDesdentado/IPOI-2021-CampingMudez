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

import dominio.Alojamiento;
import persistencia.Alojamientos;
import persistencia.Alojamientos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class PanelAlojamientos extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioAlojs;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaAlojs;
	private JButton btnReserva;
	private JButton btnCancelar;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;
	private JList lstAlojamientos;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private Color colorBotonCritico = new Color(190, 68, 36);
	private Color colorBarraBusqueda = new Color(231, 227, 218);

	private Alojamientos alojamientosDb = new Alojamientos(new ArrayList<Alojamiento>());
	/*
	 * Alojamientoes iniciales de ejemplo.
	 */
	private PanelAlojamientoRenderer panelEjemplo1;
	private PanelAlojamientoRenderer panelEjemplo2;
	private PanelAlojamientoRenderer panelEjemplo3;
	private PanelAlojamientoRenderer panelEjemplo4;
	private JLabel lblLupa;
	private JComboBox cbFiltro;

	/**
	 * Create the panel.
	 */
	public PanelAlojamientos() {

		/*
		 * 
		 * Añade los Alojamientos de ejemplo a la "persistencia" y escala las imagenes
		 */
		ImageIcon image1 = new ImageIcon(PanelMonitorRenderer.class.getResource("./parcela1.jpeg"));
		Image imagenEscalada1 = image1.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image1 = new ImageIcon(imagenEscalada1);
		ImageIcon image2 = new ImageIcon(PanelMonitorRenderer.class.getResource("./parcela3.jpeg"));
		Image imagenEscalada2 = image2.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image2 = new ImageIcon(imagenEscalada2);
		ImageIcon image3 = new ImageIcon(PanelMonitorRenderer.class.getResource("./bungalow1.jpeg"));
		Image imagenEscalada3 = image3.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image3 = new ImageIcon(imagenEscalada3);
		ImageIcon image4 = new ImageIcon(PanelMonitorRenderer.class.getResource("./bungalow3.jpg"));
		Image imagenEscalada4 = image4.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		image4 = new ImageIcon(imagenEscalada4);

		Alojamiento AlojamientoEjemplo1 = new Alojamiento("Escorpión", 4, "El Páramo", "Descripción...", 43.5, 32,
				"Libre", image1);
		Alojamiento AlojamientoEjemplo2 = new Alojamiento("Salmón", 5, "Rio Mudez", "Descripción...", 34.4, 23,
				"Libre", image2);
		Alojamiento AlojamientoEjemplo3 = new Alojamiento("Salmón", 5, "Lagunas Claras", "Descripción...", 23.5, 15,
				"Ocupada", image3);
		Alojamiento AlojamientoEjemplo4 = new Alojamiento("Ciervo", 3, "Las colinas", "Descripción...", 43.5, 32,
				"Libre", image4);
		alojamientosDb.addAlojamiento(AlojamientoEjemplo1);
		alojamientosDb.addAlojamiento(AlojamientoEjemplo2);
		alojamientosDb.addAlojamiento(AlojamientoEjemplo3);
		alojamientosDb.addAlojamiento(AlojamientoEjemplo4);

		panelEjemplo1 = new PanelAlojamientoRenderer(AlojamientoEjemplo1);
		panelEjemplo2 = new PanelAlojamientoRenderer(AlojamientoEjemplo2);
		panelEjemplo3 = new PanelAlojamientoRenderer(AlojamientoEjemplo3);
		panelEjemplo4 = new PanelAlojamientoRenderer(AlojamientoEjemplo4);
		

		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setMinimumSize(new Dimension(462, 25));
		add(splitPane, BorderLayout.CENTER);

		pnlFormularioAlojs = new JPanel();
		splitPane.setRightComponent(pnlFormularioAlojs);
		pnlFormularioAlojs.setLayout(new CardLayout(0, 0));

		scrollPaneListaAlojs = new JScrollPane();
		scrollPaneListaAlojs.setMinimumSize(new Dimension(450, 15));
		splitPane.setLeftComponent(scrollPaneListaAlojs);

		lstAlojamientos = new JList();
		DefaultListModel lstModel = new DefaultListModel();

		lstModel.addElement(panelEjemplo1);
		lstModel.addElement(panelEjemplo2);
		lstModel.addElement(panelEjemplo3);
		lstModel.addElement(panelEjemplo4);
		lstAlojamientos.setModel(lstModel);
		lstAlojamientos.setFixedCellHeight(220);
		lstAlojamientos.setCellRenderer(new ActividadRenderer());

		lstAlojamientos.setMinimumSize(new Dimension(200, 23));
		scrollPaneListaAlojs.setViewportView(lstAlojamientos);
		
		cbFiltro = new JComboBox();
		cbFiltro.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbFiltro.setToolTipText("Permite filtrar por tipo de alojamiento y listar los que convenga");
		cbFiltro.setModel(new DefaultComboBoxModel(new String[] {"Parcelas", "Cabañas", "Parcelas y cabañas"}));
		scrollPaneListaAlojs.setColumnHeaderView(cbFiltro);

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

		btnReserva = new JButton("Reservar alojamiento");
		btnReserva.setForeground(Color.BLACK);
		btnReserva.setBackground(colorBoton);
		btnReserva.setFocusPainted(false);
		GridBagConstraints gbc_btnReserva = new GridBagConstraints();
		gbc_btnReserva.insets = new Insets(0, 0, 5, 5);
		gbc_btnReserva.gridx = 1;
		gbc_btnReserva.gridy = 1;
		pnlGestionBusqueda.add(btnReserva, gbc_btnReserva);

		btnCancelar = new JButton("Cancelar una reserva");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(colorBotonCritico);
		btnCancelar.setFocusPainted(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 1;
		pnlGestionBusqueda.add(btnCancelar, gbc_btnCancelar);

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

		lblLupa = new JLabel("");
		lblLupa.setIcon(new ImageIcon(PanelAlojamientos.class.getResource("/presentacion/lupa.png")));
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_lblLupa = new GridBagConstraints();
		gbc_lblLupa.insets = new Insets(0, 0, 5, 5);
		gbc_lblLupa.gridx = 8;
		gbc_lblLupa.gridy = 1;
		pnlGestionBusqueda.add(lblLupa, gbc_lblLupa);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioAlojs.add(formularioVacio, "Formulario vacio");

	}
}