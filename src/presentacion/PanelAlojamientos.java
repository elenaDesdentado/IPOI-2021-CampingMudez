package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
import dominio.Monitor;
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

		Parcela alojamientoEjemplo1 = new Parcela("Escorpión", 4, "El Páramo",
				"Con un cálido clima que se mantiene constante a lo largo del año, en la parcela El Páramo \npodrá disfrutar de una experiencia lo más cercana a una playa sin estar en ella.\n"
						+ "Bien equipada y económica, podrá disfrutar de unas vacaciones de ensueño.",
				43.5, 32.0, "Libre", "Mucha sombra", "Arena", "Piscina", "Restaurante El Glotón (1 km)", true, false,
				true, true, true, false, image1);
		Parcela alojamientoEjemplo2 = new Parcela("Salmón", 5, "Río Mudez",
				"Una parcela que se encuentra en la misma orilla del famoso río Mudez. \nHaga realidad los recuerdos de su infancia disfrutando de un día de pesca o de baño en el río, \n"
						+ "mientras tiene a escasos metros una vivienda de 2 pisos, 4 baños y 6 camas para descansar \ndel agotador día de natación.",
				34.4, 23.0, "Libre", "Poca sombra", "Césped", "Río", "Gastrobar Tapas y más (5 km)", true, false, true,
				true, true, true, image2);
		Bungalow alojamientoEjemplo3 = new Bungalow("Salmón", 5, "Lagunas Claras",
				"Esta cabaña se encuentra en mitad de las reconocidas Lagunas Claras donde podremos \ndisfrutar de reconfortantes baños, sobre todo en verano. "
						+ "La cabaña se encuentra \nclimatizada interiormente, cuenta con un gran almacén y una chimenea con la poder \nasar para pasar unas vacaciones invernales de lujo.",
				23.5, 15.5, "Ocupada", true, 6, true, false, true, true, false, false, true, true, false, image3);
		Bungalow alojamientoEjemplo4 = new Bungalow("Águila", 3, "Las colinas",
				"En la cabaña Las Colinas podrá vivir una experiencia del típico \"ermitaño\" solitario. \n"
						+ "La cabaña se encuentra situada a 1000 metros de altura, y se encuentra completamente \nclimatizada para resistir las nevadas. Cuenta además, con chimenea, 2 pisos, 4 baños \ny 4 camas."
						+ "Cabe destacar la instalación de un cercado para disuadir a los osos \nque por allí merodean.",
				43.5, 32, "Libre", true, 4, false, false, true, true, true, false, true, true, false, image4);

		/*
		 * Añadiendo algunos dias como fechas ya reservadas
		 */

		alojamientoEjemplo1.getFechasReservadas().add("2020-12-01;2020-12-04");
		alojamientoEjemplo1.getFechasReservadas().add("2021-01-03;2020-01-06");
		alojamientoEjemplo3.getFechasReservadas().add("2021-01-01;2021-01-05");
		alojamientoEjemplo3.getFechasReservadas().add("2020-12-15;2020-12-27");
		alojamientoEjemplo2.getFechasReservadas().add("2020-12-01;2020-12-04");
		alojamientoEjemplo1.getFechasReservadas().add("2021-01-08;2021-01-20");
		alojamientoEjemplo2.getFechasReservadas().add("2021-01-01;2021-01-05");
		alojamientoEjemplo4.getFechasReservadas().add("2021-01-15;2021-01-20");

		alojamientosDb.addAlojamiento(alojamientoEjemplo1);
		alojamientosDb.addAlojamiento(alojamientoEjemplo2);
		alojamientosDb.addAlojamiento(alojamientoEjemplo3);
		alojamientosDb.addAlojamiento(alojamientoEjemplo4);

		panelEjemplo1 = new PanelAlojamientoRenderer(alojamientoEjemplo1);
		panelEjemplo2 = new PanelAlojamientoRenderer(alojamientoEjemplo2);
		panelEjemplo3 = new PanelAlojamientoRenderer(alojamientoEjemplo3);
		panelEjemplo4 = new PanelAlojamientoRenderer(alojamientoEjemplo4);

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
		cbFiltro.setToolTipText(MessagesPanelAlojamientos.getString("PanelAlojamientos.cbFiltro.toolTipText")); //$NON-NLS-1$
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

		btnCancelar = new JButton(MessagesPanelAlojamientos.getString("PanelAlojamientos.btnCancelar.text")); //$NON-NLS-1$
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(colorBotonCritico);
		btnCancelar.setFocusPainted(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 1;
		pnlGestionBusqueda.add(btnCancelar, gbc_btnCancelar);

		lblBarraBusqueda = new JLabel(MessagesPanelAlojamientos.getString("PanelAlojamientos.lblBarraBusqueda.text")); //$NON-NLS-1$
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

		lblLupa = new JLabel(""); //$NON-NLS-1$
		lblLupa.addMouseListener(new LblLupaMouseListener());
		lblLupa.setIcon(new ImageIcon(PanelAlojamientos.class.getResource("/presentacion/lupa.png"))); //$NON-NLS-1$
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_lblLupa = new GridBagConstraints();
		gbc_lblLupa.insets = new Insets(0, 0, 5, 5);
		gbc_lblLupa.gridx = 8;
		gbc_lblLupa.gridy = 1;
		pnlGestionBusqueda.add(lblLupa, gbc_lblLupa);

		// PANELES PARA EL CARD LAYOUT
		JPanel formularioVacio = new PanelFormularioActividadesInicio();

		pnlFormularioAlojs.add(formularioVacio, "Formulario vacio"); //$NON-NLS-1$

	}

	private class CbFiltroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel modeloFiltrado = new DefaultListModel();
			for (int i = 0; i < modeloOriginal.getSize(); ++i) {
				if (((String) cbFiltro.getSelectedItem()).equals("Parcelas")) { //$NON-NLS-1$
					if (alojamientosDb.getAlojamientos().get(i) instanceof Parcela)
						modeloFiltrado.addElement(modeloOriginal.getElementAt(i));
				} else if (((String) cbFiltro.getSelectedItem()).equals("Cabañas")) { //$NON-NLS-1$
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
				int index = alojamientosDb.getAlojamientos()
						.indexOf(((PanelAlojamientoRenderer) lstAlojamientos.getSelectedValue()).getAlojamiento());
				Alojamiento alojamientoSeleccionado = alojamientosDb.getAlojamientos().get(index);
				if (alojamientoSeleccionado instanceof Parcela) {
					PanelFormularioReservaParcela panelAlojamientoInfoCompleta = new PanelFormularioReservaParcela(
							lstAlojamientos, alojamientosDb);

					panelAlojamientoInfoCompleta.lblFoto.setIcon(alojamientoSeleccionado.getFoto());
					panelAlojamientoInfoCompleta.lblNombre.setText(alojamientoSeleccionado.getNombre());
					panelAlojamientoInfoCompleta.lblPrecio.setText(String.valueOf(alojamientoSeleccionado.getPrecio()));
					panelAlojamientoInfoCompleta.lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$

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

					panelAlojamientoInfoCompleta.tPDescripcion.setText("<html><pre>" //$NON-NLS-1$
							+ alojamientoSeleccionado.getDescripcion() + "</pre><ul><li>Área de la parcela: " //$NON-NLS-1$
							+ alojamientoSeleccionado.getArea() + "</li><li>Superficie de la parcela: " //$NON-NLS-1$
							+ String.valueOf(alojamientoSeleccionado.getTamanio()) + "m<sup>2</sup>" //$NON-NLS-1$
							+ "</li><li>Sombra: " + ((Parcela) alojamientoSeleccionado).getSombra() //$NON-NLS-1$
							+ "</li><li>Tipo de suelo: " + ((Parcela) alojamientoSeleccionado).getSuelo() //$NON-NLS-1$
							+ "</li><li>Zona de baño: " + ((Parcela) alojamientoSeleccionado).getBanio() //$NON-NLS-1$
							+ "</li><li>Restaurantes cercanos: " + ((Parcela) alojamientoSeleccionado).getRestaurante() //$NON-NLS-1$
							+ "</li></ul></html>"); //$NON-NLS-1$

					pnlFormularioAlojs.add(panelAlojamientoInfoCompleta, alojamientoSeleccionado.getNombre());
					((CardLayout) pnlFormularioAlojs.getLayout()).show(pnlFormularioAlojs,
							alojamientoSeleccionado.getNombre());

					ImageIcon image = new ImageIcon(PanelAlojamientoRenderer.class
							.getResource("./estrellas" + alojamientoSeleccionado.getValoracion() + ".PNG")); //$NON-NLS-1$ //$NON-NLS-2$
					Image imagenEscalada1 = image.getImage().getScaledInstance(128, 20, java.awt.Image.SCALE_SMOOTH);
					image = new ImageIcon(imagenEscalada1);
					panelAlojamientoInfoCompleta.lblEstrellas.setIcon(image);

					UIManager.getDefaults().put("Button.disabledText", Color.DARK_GRAY); //$NON-NLS-1$
					UIManager.getDefaults().put("ComboBox.disabledText", Color.DARK_GRAY); //$NON-NLS-1$
				} else if (alojamientoSeleccionado instanceof Bungalow) {
					String jardin = "", wifi = "", piscina = "", barbacoa = ""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

					PanelFormularioReservaBungalow panelAlojamientoInfoCompleta = new PanelFormularioReservaBungalow(
							lstAlojamientos, alojamientosDb);

					panelAlojamientoInfoCompleta.lblFoto.setIcon(alojamientoSeleccionado.getFoto());
					panelAlojamientoInfoCompleta.lblNombre.setText(alojamientoSeleccionado.getNombre());
					panelAlojamientoInfoCompleta.lblPrecio.setText(String.valueOf(alojamientoSeleccionado.getPrecio()));
					panelAlojamientoInfoCompleta.lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$

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

					if (((Bungalow) alojamientoSeleccionado).isJardin())
						jardin = "Sí"; //$NON-NLS-1$
					else
						jardin = "No"; //$NON-NLS-1$
					if (((Bungalow) alojamientoSeleccionado).isWifi())
						wifi = "Sí"; //$NON-NLS-1$
					else
						wifi = "No"; //$NON-NLS-1$
					if (((Bungalow) alojamientoSeleccionado).isPiscina())
						piscina = "Sí"; //$NON-NLS-1$
					else
						piscina = "No"; //$NON-NLS-1$
					if (((Bungalow) alojamientoSeleccionado).isBarbacoa())
						barbacoa = "Sí"; //$NON-NLS-1$
					else
						barbacoa = "No"; //$NON-NLS-1$

					panelAlojamientoInfoCompleta.tPDescripcion.setText("<html><pre>" //$NON-NLS-1$
							+ alojamientoSeleccionado.getDescripcion() + "</pre><ul><li>Área de la cabaña: " //$NON-NLS-1$
							+ alojamientoSeleccionado.getArea() + "</li><li>Jardín: " + jardin + "</li><li>Superficie: " //$NON-NLS-1$ //$NON-NLS-2$
							+ alojamientoSeleccionado.getTamanio() + "m<sup>2</sup>" //$NON-NLS-1$
							+ "</li><li>Capacidad máxima de personas: " //$NON-NLS-1$
							+ String.valueOf(((Bungalow) alojamientoSeleccionado).getCapacidadMaxima())
							+ " personas</li><li>WiFi: " + wifi + "</li><li>Piscina: " + piscina //$NON-NLS-1$ //$NON-NLS-2$
							+ "</li><li>Barbacoa exterior: " + barbacoa + "</li></ul></html>"); //$NON-NLS-1$ //$NON-NLS-2$

					pnlFormularioAlojs.add(panelAlojamientoInfoCompleta, alojamientoSeleccionado.getNombre());
					((CardLayout) pnlFormularioAlojs.getLayout()).show(pnlFormularioAlojs,
							alojamientoSeleccionado.getNombre());

					ImageIcon image = new ImageIcon(PanelAlojamientoRenderer.class
							.getResource("./estrellas" + alojamientoSeleccionado.getValoracion() + ".PNG")); //$NON-NLS-1$ //$NON-NLS-2$
					Image imagenEscalada1 = image.getImage().getScaledInstance(128, 20, java.awt.Image.SCALE_SMOOTH);
					image = new ImageIcon(imagenEscalada1);
					panelAlojamientoInfoCompleta.lblEstrellas.setIcon(image);
				}
			}
		}
	}

	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (lstAlojamientos.getSelectedIndex() != -1) {
				int index = alojamientosDb.getAlojamientos()
						.indexOf(((PanelAlojamientoRenderer) lstAlojamientos.getSelectedValue()).getAlojamiento());
				Alojamiento alojamientoSeleccionado = alojamientosDb.getAlojamientos().get(index);
				String[] choices = new String[alojamientoSeleccionado.getFechasReservadas().size()];
				for (int i = 0; i < choices.length; ++i) {
//					 String [] fechas = alojamientoSeleccionado.getFechasReservadas().get(i).split(";");
//					 String fechaFormateada = "Entrada: " + fechas[0] + "\t Salida: " + fechas[1];
					choices[i] = alojamientoSeleccionado.getFechasReservadas().get(i);
				}
				String input = (String) JOptionPane.showInputDialog(null,
						MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReserva"), //$NON-NLS-1$
						MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReservaTitulo"), //$NON-NLS-1$
						JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				if (input != null) {
					String[] options = { MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReservaSi"), //$NON-NLS-1$
							MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReservaNo") }; //$NON-NLS-1$
					int seleccion = JOptionPane.showOptionDialog(null,
							MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReservaConfirmacion"), //$NON-NLS-1$
							MessagesPanelAlojamientos.getString("PanelAlojamientos.EliminarReservaConfirmacionTitulo"), //$NON-NLS-1$
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (seleccion == 0)
						alojamientoSeleccionado.getFechasReservadas().remove(input);
				}
			}
		}
	}

	private class TxtBarraBusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombreAlojamiento;
			PanelAlojamientoRenderer panelAlojamiento;
			int result = -1, i = 0;
			DefaultListModel modeloAlojamientos = (DefaultListModel) lstAlojamientos.getModel();
			for (; i < modeloAlojamientos.getSize(); ++i) {
				panelAlojamiento = (PanelAlojamientoRenderer) modeloAlojamientos.get(i);
				nombreAlojamiento = panelAlojamiento.getAlojamiento().getNombre();
				if (nombreAlojamiento.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstAlojamientos.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null,
						MessagesPanelAlojamientos.getString("PanelAlojamientos.MonitorNoExiste"), //$NON-NLS-1$
						MessagesPanelAlojamientos.getString("PanelAlojamientos.ErrorBusqueda"), //$NON-NLS-1$
						JOptionPane.ERROR_MESSAGE);
		}
	}

	private class LblLupaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String nombreAlojamiento;
			PanelAlojamientoRenderer panelAlojamiento;
			int result = -1, i = 0;
			DefaultListModel modeloAlojamientos = (DefaultListModel) lstAlojamientos.getModel();
			for (; i < modeloAlojamientos.getSize(); ++i) {
				panelAlojamiento = (PanelAlojamientoRenderer) modeloAlojamientos.get(i);
				nombreAlojamiento = panelAlojamiento.getAlojamiento().getNombre();
				if (nombreAlojamiento.equals(txtBarraBusqueda.getText())) {
					result = i;
					break;
				}
			}
			if (result != -1)
				lstAlojamientos.setSelectedIndex(i);
			else
				JOptionPane.showMessageDialog(null,
						MessagesPanelAlojamientos.getString("PanelAlojamientos.AlojamientoNoExiste"), //$NON-NLS-1$
						MessagesPanelAlojamientos.getString("PanelAlojamientos.ErrorBusqueda2"), //$NON-NLS-1$
						JOptionPane.ERROR_MESSAGE);
		}
	}

	public JList getLstAlojamientos() {
		return this.lstAlojamientos;
	}
}