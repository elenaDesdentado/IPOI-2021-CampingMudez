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

import dominio.Actividad;
import dominio.Alojamiento;
import dominio.Bungalow;
import dominio.Parcela;
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

	private DefaultListModel modeloOriginal;
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

		Parcela AlojamientoEjemplo1 = new Parcela("Escorpión", 4, "El Páramo", "Descripción...", 43.5, 32.0, "Libre",
				"Mucha sombra", "Arena", "Piscina", "Restaurante El Glotón: 1 km", true, false, true, true, true, false,
				image1);
		Parcela AlojamientoEjemplo2 = new Parcela("Salmón", 5, "Rio Mudez", "Descripción...", 34.4, 23.0, "Libre",
				"Mucha sombra", "Arena", "Piscina", "Restaurante El Glotón: 1 km", true, false, true, true, true, true,
				image2);
		Bungalow AlojamientoEjemplo3 = new Bungalow("Salmón", 5, "Lagunas Claras", "Descripción...", 23.5, 15.5,
				"Ocupada", true, 6, true, false, true, true, false, false, true, true, false, image3);
		Bungalow AlojamientoEjemplo4 = new Bungalow("Ciervo", 3, "Las colinas", "Descripción...", 43.5, 32, "Libre",
				true, 4, false, false, true, true, true, false, true, true, false, image4);
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
		lstAlojamientos.addListSelectionListener(new LstAlojamientosListSelectionListener());
		modeloOriginal = new DefaultListModel();

		modeloOriginal.addElement(panelEjemplo1);
		modeloOriginal.addElement(panelEjemplo2);
		modeloOriginal.addElement(panelEjemplo3);
		modeloOriginal.addElement(panelEjemplo4);
		lstAlojamientos.setModel(modeloOriginal);
		lstAlojamientos.setFixedCellHeight(220);
		lstAlojamientos.setCellRenderer(new ActividadRenderer());

		lstAlojamientos.setMinimumSize(new Dimension(200, 250));
		scrollPaneListaAlojs.setViewportView(lstAlojamientos);

		cbFiltro = new JComboBox();
		cbFiltro.addActionListener(new CbFiltroActionListener());
		cbFiltro.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbFiltro.setToolTipText("Permite filtrar por tipo de alojamiento y listar los que convenga");
		cbFiltro.setModel(new DefaultComboBoxModel(new String[] { "Parcelas", "Cabañas", "Parcelas y cabañas" }));
		cbFiltro.setSelectedIndex(2);
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

	private class CbFiltroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel modeloFiltrado = new DefaultListModel();
			for (int i = 0; i < lstAlojamientos.getModel().getSize(); ++i) {
				if (((String) cbFiltro.getSelectedItem()).equals("Parcelas")) {
					if (alojamientosDb.getAlojamientos().get(i) instanceof Parcela)
						modeloFiltrado.addElement(modeloOriginal.getElementAt(i));
				} else if (((String) cbFiltro.getSelectedItem()).equals("Cabañas")) {
					if (alojamientosDb.getAlojamientos().get(i) instanceof Bungalow)
						modeloFiltrado.addElement(modeloOriginal.getElementAt(i));
				} else {
					lstAlojamientos.setModel(modeloOriginal);
					break; // No se toca el modelo porque se selecciono "Parcelas y cabañas"
				}
			}
			if (modeloFiltrado.getSize() != 0)
				lstAlojamientos.setModel(modeloFiltrado);
		}
	}

	private class LstAlojamientosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (lstAlojamientos.getSelectedIndex() != -1) {
				Alojamiento alojamientoSeleccionado = alojamientosDb.getAlojamientos()
						.get(lstAlojamientos.getSelectedIndex());
				if (alojamientoSeleccionado instanceof Parcela) {
					PanelFormularioReservaParcela panelAlojamientoInfoCompleta = new PanelFormularioReservaParcela(
							lstAlojamientos, alojamientosDb, lstAlojamientos.getSelectedIndex());

					panelAlojamientoInfoCompleta.lblFoto.setIcon(alojamientoSeleccionado.getFoto());
					panelAlojamientoInfoCompleta.lblNombre.setText(alojamientoSeleccionado.getNombre());
					panelAlojamientoInfoCompleta.lblPrecio.setText(String.valueOf(alojamientoSeleccionado.getPrecio()));
					panelAlojamientoInfoCompleta.lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));

					panelAlojamientoInfoCompleta.chckbxCorrienteElectrica
							.setEnabled(((Parcela) alojamientoSeleccionado).isGolf());
					panelAlojamientoInfoCompleta.chckbxCorrienteElectrica
							.setEnabled(((Parcela) alojamientoSeleccionado).isCorriente());
					panelAlojamientoInfoCompleta.chckbxParking
							.setEnabled(((Parcela) alojamientoSeleccionado).isParking());
					panelAlojamientoInfoCompleta.chckbxWifi.setEnabled(((Parcela) alojamientoSeleccionado).isWifi());
					panelAlojamientoInfoCompleta.chckbxTiendaAcampada
							.setEnabled(((Parcela) alojamientoSeleccionado).isAcampada());
					panelAlojamientoInfoCompleta.chckbxMascotas
							.setEnabled(((Parcela) alojamientoSeleccionado).isMascotas());

					panelAlojamientoInfoCompleta.tPDescripcion.setText(alojamientoSeleccionado.getDescripcion());

					pnlFormularioAlojs.add(panelAlojamientoInfoCompleta, alojamientoSeleccionado.getNombre());
					((CardLayout) pnlFormularioAlojs.getLayout()).show(pnlFormularioAlojs,
							alojamientoSeleccionado.getNombre());

					ImageIcon image = new ImageIcon(PanelAlojamientoRenderer.class
							.getResource("./estrellas" + alojamientoSeleccionado.getValoracion() + ".PNG"));
					Image imagenEscalada1 = image.getImage().getScaledInstance(128, 20, java.awt.Image.SCALE_SMOOTH);
					image = new ImageIcon(imagenEscalada1);
					panelAlojamientoInfoCompleta.lblEstrellas.setIcon(image);

					UIManager.getDefaults().put("Button.disabledText", Color.DARK_GRAY);
					UIManager.getDefaults().put("ComboBox.disabledText", Color.DARK_GRAY);
				} else if (alojamientoSeleccionado instanceof Bungalow) {
					PanelFormularioReservaBungalow panelAlojamientoInfoCompleta = new PanelFormularioReservaBungalow(
							lstAlojamientos, alojamientosDb, lstAlojamientos.getSelectedIndex());

					panelAlojamientoInfoCompleta.lblFoto.setIcon(alojamientoSeleccionado.getFoto());
					panelAlojamientoInfoCompleta.lblNombre.setText(alojamientoSeleccionado.getNombre());
					panelAlojamientoInfoCompleta.lblPrecio.setText(String.valueOf(alojamientoSeleccionado.getPrecio()));
					panelAlojamientoInfoCompleta.lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));

					panelAlojamientoInfoCompleta.chckbxGolf.setEnabled(((Bungalow) alojamientoSeleccionado).isGolf());
					panelAlojamientoInfoCompleta.chckbxCarbon
							.setEnabled(((Bungalow) alojamientoSeleccionado).isCarbon());
					panelAlojamientoInfoCompleta.chckbxGaraje
							.setEnabled(((Bungalow) alojamientoSeleccionado).isGaraje());
					panelAlojamientoInfoCompleta.chckbxCama.setEnabled(((Bungalow) alojamientoSeleccionado).isCama());
					panelAlojamientoInfoCompleta.chckbxLimpieza
							.setEnabled(((Bungalow) alojamientoSeleccionado).isLimpieza());
					panelAlojamientoInfoCompleta.chckbxLavavajillas
							.setEnabled(((Bungalow) alojamientoSeleccionado).isLavavajillas());

					panelAlojamientoInfoCompleta.tPDescripcion.setText(alojamientoSeleccionado.getDescripcion());

					pnlFormularioAlojs.add(panelAlojamientoInfoCompleta, alojamientoSeleccionado.getNombre());
					((CardLayout) pnlFormularioAlojs.getLayout()).show(pnlFormularioAlojs,
							alojamientoSeleccionado.getNombre());

					ImageIcon image = new ImageIcon(PanelAlojamientoRenderer.class
							.getResource("./estrellas" + alojamientoSeleccionado.getValoracion() + ".PNG"));
					Image imagenEscalada1 = image.getImage().getScaledInstance(128, 20, java.awt.Image.SCALE_SMOOTH);
					image = new ImageIcon(imagenEscalada1);
					panelAlojamientoInfoCompleta.lblEstrellas.setIcon(image);
				}
			}
		}
	}
}