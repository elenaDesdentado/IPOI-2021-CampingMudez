package presentacion;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import dominio.Ruta;
import persistencia.Monitores;
import persistencia.Rutas;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JScrollPane;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class PanelEditorRutas extends JPanel {
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDia;
	private JComboBox cbDia;
	private JLabel lblHorario;
	private JComboBox cbHorario;
	private JLabel lblCupo;
	private JLabel lblEncuentro;
	private JLabel lblDificultad;
	private JSpinner spinCupo;
	private JTextField txtEncuentro;
	private JComboBox cbDificultad;
	private JPanel pnlDiseño;
	private JToolBar toolBar;
	private JButton btnCargarMapa;
	private JButton btnInicio;
	private JButton btnMeta;
	private JButton btnMirador;
	private JButton btnFuente;
	private JButton btnRupestre;
	private JButton btnMerendero;
	private JScrollPane spDibujo;

	private MiAreaDibujo miAreaDibujo;
	// Imagen en la que se cargará el fichero seleccionado por el
	// usuario
	private ImageIcon imagen;

	int modo = -1;
	private final int INICIO = 1;
	private final int META = 2;
	private final int MIRADOR = 3;
	private final int FUENTE = 4;
	private final int RUPESTRE = 5;
	private final int MERENDERO = 6;
	private final int LINEA = 7;

	private int x, y;

	// Cursores e imagenes
	private Toolkit toolkit;
	private Image imagInicio;
	private Image imagMeta;
	private Image imagMirador;
	private Image imagFuente;
	private Image imagRupestre;
	private Image imagMerendero;
	private Image imagLinea;
	private Image imagCursorInicio;
	private Image imagCursorMeta;
	private Image imagCursorMirador;
	private Image imagCursorFuente;
	private Image imagCursorRupestre;
	private Image imagCursorMerendero;
	private Image imagCursorLinea;
	private Cursor cursorInicio;
	private Cursor cursorMeta;
	private Cursor cursorFuente;
	private Cursor cursorMirador;
	private Cursor cursorRupestre;
	private Cursor cursorMerendero;
	private Cursor cursorLinea;
	private JButton btnLinea;
	private JButton btnPapelera;
	private JButton btnNewButton;
	private JLabel lblDescripcion;
	private JScrollPane scrollPane;
	private JTextArea tADescripcion;

	private Monitores monitores;
	private Rutas rutas;
	private JList lstRutas;

	private JButton btnCursor;
	private JSeparator separator;
	private JLabel lblLeyenda;

	/**
	 * Create the panel.
	 */
	public PanelEditorRutas(Monitores monitores, Rutas rutasDb, JList lstRutas) {

		this.monitores = monitores;
		this.rutas = rutasDb;
		this.lstRutas = lstRutas;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 15, 0, 133, 0, 69, 85, 0, 68, 0, 0, 33, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 15, 0, 0, 0, 0, 0, 0, 38, 50, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNombre = new JLabel("Nombre de la ruta:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/guardar.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		lblLeyenda = new JLabel("");
		lblLeyenda.addMouseListener(new LblLeyendaMouseListener());
		lblLeyenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLeyenda.setToolTipText("Haz click para ver la leyenda del diseño de la ruta");
		lblLeyenda.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-info.png")));
		GridBagConstraints gbc_lblLeyenda = new GridBagConstraints();
		gbc_lblLeyenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeyenda.gridx = 10;
		gbc_lblLeyenda.gridy = 1;
		add(lblLeyenda, gbc_lblLeyenda);

		lblDia = new JLabel("Dia que se realiza:");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 1;
		gbc_lblDia.gridy = 2;
		add(lblDia, gbc_lblDia);

		cbDia = new JComboBox();
		cbDia.setModel(new DefaultComboBoxModel(
				new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" }));
		GridBagConstraints gbc_cbDia = new GridBagConstraints();
		gbc_cbDia.insets = new Insets(0, 0, 5, 5);
		gbc_cbDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia.gridx = 2;
		gbc_cbDia.gridy = 2;
		add(cbDia, gbc_cbDia);

		pnlDiseño = new JPanel();
		pnlDiseño.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dise\u00F1o de la ruta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlDiseño = new GridBagConstraints();
		gbc_pnlDiseño.gridheight = 9;
		gbc_pnlDiseño.gridwidth = 5;
		gbc_pnlDiseño.insets = new Insets(0, 0, 5, 5);
		gbc_pnlDiseño.fill = GridBagConstraints.BOTH;
		gbc_pnlDiseño.gridx = 5;
		gbc_pnlDiseño.gridy = 2;
		add(pnlDiseño, gbc_pnlDiseño);
		pnlDiseño.setLayout(new BorderLayout(0, 0));

		toolBar = new JToolBar();
		pnlDiseño.add(toolBar, BorderLayout.NORTH);

		btnCargarMapa = new JButton("");
		btnCargarMapa.setToolTipText("Pulsa para cargar la imagen de un mapa sobre el que dibujar");
		btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
		btnCargarMapa.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-mapa.png")));
		toolBar.add(btnCargarMapa);

		btnInicio = new JButton("");
		btnInicio.addActionListener(new BtnInicioActionListener());

		btnCursor = new JButton("");
		btnCursor.setToolTipText("Pulsa para \"recuperar\" el cursor normal");
		btnCursor.addActionListener(new BtnCursorActionListener());

		btnPapelera = new JButton("");
		btnPapelera.setToolTipText("Pulsa para limpiar lo que este dibujado sobre la imagen");
		btnPapelera.addActionListener(new BtnPapeleraActionListener());
		btnPapelera.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-papelera.png")));
		toolBar.add(btnPapelera);
		btnCursor.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-cursor.png")));
		toolBar.add(btnCursor);

		separator = new JSeparator();
		separator.setMinimumSize(new Dimension(10, 0));
		separator.setPreferredSize(new Dimension(10, 2));
		toolBar.add(separator);
		btnInicio.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-inicio.png")));
		toolBar.add(btnInicio);

		btnMeta = new JButton("");
		btnMeta.addActionListener(new BtnMetaActionListener());
		btnMeta.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-final.png")));
		toolBar.add(btnMeta);

		btnMirador = new JButton("");
		btnMirador.addActionListener(new BtnMiradorActionListener());
		btnMirador.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-mirador.png")));
		toolBar.add(btnMirador);

		btnFuente = new JButton("");
		btnFuente.addActionListener(new BtnFuenteActionListener());
		btnFuente.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-fuente-agua.png")));
		toolBar.add(btnFuente);

		btnRupestre = new JButton("");
		btnRupestre.addActionListener(new BtnRupestreActionListener());
		btnRupestre.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-rupestre.png")));
		toolBar.add(btnRupestre);

		btnMerendero = new JButton("");
		btnMerendero.addActionListener(new BtnMerenderoActionListener());
		btnMerendero.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-merendero.png")));
		toolBar.add(btnMerendero);

		btnLinea = new JButton("");
		btnLinea.addActionListener(new BtnLineaActionListener());
		btnLinea.setIcon(new ImageIcon(PanelEditorRutas.class.getResource("/presentacion/icono-linea.png")));
		toolBar.add(btnLinea);

		spDibujo = new JScrollPane();
		pnlDiseño.add(spDibujo, BorderLayout.CENTER);

		lblHorario = new JLabel("Horario:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 3;
		add(lblHorario, gbc_lblHorario);

		cbHorario = new JComboBox();
		cbHorario.setModel(new DefaultComboBoxModel(new String[] { "8:00 - 10:00", "9:00 - 10:15", "10:15 - 11:30",
				"11:00 - 14:00", "11:15 - 12:45", "17:30 - 19:30", "18:30 - 20:00" }));
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 2;
		gbc_cbHorario.gridy = 3;
		add(cbHorario, gbc_cbHorario);

		lblCupo = new JLabel("Cupo:");
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 1;
		gbc_lblCupo.gridy = 4;
		add(lblCupo, gbc_lblCupo);

		spinCupo = new JSpinner();
		spinCupo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GridBagConstraints gbc_spinCupo = new GridBagConstraints();
		gbc_spinCupo.anchor = GridBagConstraints.WEST;
		gbc_spinCupo.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupo.gridx = 2;
		gbc_spinCupo.gridy = 4;
		add(spinCupo, gbc_spinCupo);

		lblEncuentro = new JLabel("Punto de encuentro:");
		GridBagConstraints gbc_lblEncuentro = new GridBagConstraints();
		gbc_lblEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncuentro.gridx = 1;
		gbc_lblEncuentro.gridy = 5;
		add(lblEncuentro, gbc_lblEncuentro);

		txtEncuentro = new JTextField();
		GridBagConstraints gbc_txtEncuentro = new GridBagConstraints();
		gbc_txtEncuentro.gridwidth = 2;
		gbc_txtEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_txtEncuentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEncuentro.gridx = 2;
		gbc_txtEncuentro.gridy = 5;
		add(txtEncuentro, gbc_txtEncuentro);
		txtEncuentro.setColumns(10);

		lblDificultad = new JLabel("Dificultad:");
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 1;
		gbc_lblDificultad.gridy = 6;
		add(lblDificultad, gbc_lblDificultad);

		cbDificultad = new JComboBox();
		cbDificultad.setModel(new DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta", "Extrema" }));
		GridBagConstraints gbc_cbDificultad = new GridBagConstraints();
		gbc_cbDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_cbDificultad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDificultad.gridx = 2;
		gbc_cbDificultad.gridy = 6;
		add(cbDificultad, gbc_cbDificultad);

		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		spDibujo.setViewportView(miAreaDibujo);

		lblDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 7;
		add(lblDescripcion, gbc_lblDescripcion);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);

		tADescripcion = new JTextArea();
		tADescripcion.setLineWrap(true);
		tADescripcion.setWrapStyleWord(true);
		scrollPane.setViewportView(tADescripcion);

		// Creación de imágenes y cursores
		toolkit = Toolkit.getDefaultToolkit();
		imagInicio = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-inicio.png"));
		imagMeta = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-final.png"));
		imagMirador = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-mirador.png"));
		imagFuente = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-fuente-agua.png"));
		imagRupestre = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-rupestre.png"));
		imagMerendero = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-merendero.png"));
		imagLinea = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-linea.png"));
		imagCursorInicio = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-inicio.png"));
		imagCursorMeta = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-final.png"));
		imagCursorFuente = toolkit
				.getImage(getClass().getClassLoader().getResource("presentacion/icono-fuente-agua.png"));
		imagCursorMirador = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-mirador.png"));
		imagCursorRupestre = toolkit
				.getImage(getClass().getClassLoader().getResource("presentacion/icono-rupestre.png"));
		imagCursorMerendero = toolkit
				.getImage(getClass().getClassLoader().getResource("presentacion/icono-merendero.png"));
		imagCursorInicio = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/icono-linea.png"));
		// Creación de los cursores
		cursorInicio = toolkit.createCustomCursor(imagInicio, new Point(0, 0), "CURSOR_INICIO");
		cursorMeta = toolkit.createCustomCursor(imagMeta, new Point(0, 0), "CURSOR_META");
		cursorMirador = toolkit.createCustomCursor(imagMirador, new Point(0, 0), "CURSOR_MIRADOR");
		cursorFuente = toolkit.createCustomCursor(imagCursorFuente, new Point(0, 0), "CURSOR_FUENTE");
		cursorRupestre = toolkit.createCustomCursor(imagRupestre, new Point(0, 0), "CURSOR_RUPESTRE");
		cursorMerendero = toolkit.createCustomCursor(imagMerendero, new Point(0, 0), "CURSOR_MERENDERO");
		cursorLinea = toolkit.createCustomCursor(imagLinea, new Point(0, 0), "CURSOR_LINEA");
	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			miAreaDibujo.setObjetosGraficos(new ArrayList<ObjetoGrafico>());
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(null);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				miAreaDibujo.setIcon(imagen);
			}
		}
	}

	private class BtnInicioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = INICIO;
			setCursor(cursorInicio);
		}
	}

	private class BtnMetaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = META;
			setCursor(cursorMeta);
		}
	}

	private class BtnMiradorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = MIRADOR;
			setCursor(cursorMirador);
		}
	}

	private class BtnFuenteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = FUENTE;
			setCursor(cursorFuente);
		}
	}

	private class BtnRupestreActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RUPESTRE;
			setCursor(cursorRupestre);
		}
	}

	private class BtnMerenderoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = MERENDERO;
			setCursor(cursorMerendero);
		}
	}

	private class BtnLineaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = LINEA;
		}
	}

	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			toolkit = Toolkit.getDefaultToolkit();
			if (imagen != null) {
				switch (modo) {
				case INICIO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagInicio));
					miAreaDibujo.repaint();
					break;
				case META:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagMeta));
					miAreaDibujo.repaint();
					break;
				case MIRADOR:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagMirador));
					miAreaDibujo.repaint();
					break;
				case FUENTE:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagFuente));
					miAreaDibujo.repaint();
					break;
				case MERENDERO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagMerendero));
					miAreaDibujo.repaint();
					break;
				case RUPESTRE:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagRupestre));
					miAreaDibujo.repaint();
					break;
				case LINEA:
					miAreaDibujo.addObjetoGrafico(new LineaGrafico(x, y, x, y, Color.RED, new BasicStroke(3f)));
					break;
				}
			}
		}
	}

	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == LINEA && imagen != null) {
				((LineaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((LineaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
		}
	}

	private class BtnPapeleraActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			miAreaDibujo.setObjetosGraficos(new ArrayList<ObjetoGrafico>());
			miAreaDibujo.repaint();
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Image image = null;
			if (txtNombre.getText().length() < 10 || txtEncuentro.getText().length() < 10
					|| tADescripcion.getText().length() < 20)
				JOptionPane.showMessageDialog(null, "Asegúrese de haber completado correctamente toda la información",
						"Error al guardar ruta", JOptionPane.ERROR_MESSAGE);
			else {
				Ruta nuevaRuta = new Ruta();
				nuevaRuta.setNombre(txtNombre.getText());
				nuevaRuta.setDia((String) cbDia.getSelectedItem());
				nuevaRuta.setDificultad((String) cbDificultad.getSelectedItem());
				nuevaRuta.setHorario((String) cbHorario.getSelectedItem());
				nuevaRuta.setCupo((int) spinCupo.getValue());
				nuevaRuta.setEncuentro(txtEncuentro.getText());
				nuevaRuta.setDescripcion(tADescripcion.getText());
				nuevaRuta.setMonitores(monitores.getMonitores());
				// Guardar la ruta pintada como imagen
				BufferedImage img = new BufferedImage(miAreaDibujo.getWidth(), miAreaDibujo.getHeight(),
						BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = img.createGraphics();
				miAreaDibujo.printAll(g2d);
				g2d.dispose();
				File imagen = new File("./src/presentacion/NuevoMapa" + rutas.getRutas().size() + ".png");
				try {
					ImageIO.write(img, "png", imagen);
					image = ImageIO.read(imagen);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Image imagenEscalada = image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
				ImageIcon foto = new ImageIcon(imagenEscalada);
				nuevaRuta.setFoto(foto);
				rutas.addRuta(nuevaRuta);
				PanelRutaRenderer nuevoPanel = new PanelRutaRenderer(nuevaRuta);
				((DefaultListModel) lstRutas.getModel()).addElement(nuevoPanel);
				JOptionPane.showConfirmDialog(null, "La ruta se guardo correctamente", "Ruta guardada",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	private class BtnCursorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setCursor(Cursor.getDefaultCursor());
		}
	}

	private class LblLeyendaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showConfirmDialog(null,
					"De izquierda a derecha, el significado de los botones es el siguiente:\nCargar la imagen de un mapa\nLimpiar la imagen\nRecuperar el cursor\nComienzo de la ruta\nMeta\nMirador\nFuente\nPintura rupestre\nMerendero\nTrazar una linea",
					"Leyenda de los botones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
