package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import dominio.Monitor;
import dominio.Usuario;
import persistencia.Monitores;
import persistencia.Usuarios;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JPanel pnlActividades;
	private JPanel pnlMonitores;
	private JPanel pnlReservas;
	private JPanel pnlRutas;
	private JPanel pnlConfiguracion;
	private JButton btnGestorReservas;
	private JButton btnGestorActividades;
	private JButton btnGestorMonitores;
	private JButton btnRutasSenderistas;
	private JPanel pnlListaFormulario;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBarraBusqueda = new Color(231, 227, 218);
	private Color colorTbGestion = new Color(74, 103, 49);
	private Color colorBotonesGestion = new Color(243, 243, 245);
	private Color colorBotonSeleccionado = new Color(159, 177, 57);

	public JLabel lblAvatar;
	private JLabel lblName;
	private JPanel pnlMenu;

	private Usuarios usuarios;
	private Usuario usuarioPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio(null, null, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio(String usuario, String password, Usuarios usuarios) {

		/*
		 * Añade los monitores de ejemplo a la "persistencia"
		 */

		Monitores monitoresDb = new Monitores(new ArrayList<Monitor>());
		ArrayList<String> idiomas1 = new ArrayList<String>();
		idiomas1.add("Castellano"); //$NON-NLS-1$
		idiomas1.add("Inglés"); //$NON-NLS-1$
		idiomas1.add("Francés"); //$NON-NLS-1$
		ArrayList<String> idiomas2 = new ArrayList<String>();
		idiomas2.add("Castellano"); //$NON-NLS-1$
		idiomas2.add("Francés"); //$NON-NLS-1$
		ArrayList<String> idiomas3 = new ArrayList<String>();
		idiomas3.add("Castellano"); //$NON-NLS-1$
		idiomas3.add("Noruego"); //$NON-NLS-1$
		idiomas3.add("Alemán"); //$NON-NLS-1$
		Monitor monitorEjemplo1 = new Monitor("Juan", "Marín Prieto", "05718928T", "654 73 82 73", null, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				"juanmapriSi@gmail.com", "Estudios Universitarios", "Disponible", MessagesVentanaInicio.getString("VentanaInicio.15"), 1000.0, 24, idiomas1, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				new ImageIcon(VentanaInicio.class.getResource("./avatarMonitorEjemplo1.png"))); //$NON-NLS-1$
		Monitor monitorEjemplo2 = new Monitor("Eva", "Grande Milagro", "05283928L", "654 83 92 83", "926 46 82 91", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				"powerJapan90@yahoo.com", "Educación Secundaria Obligatoria", "Baja laboral", "17:30-22:30", 1235.5, 20, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				idiomas2, new ImageIcon(VentanaInicio.class.getResource("./avatarMonitorEjemplo2.png"))); //$NON-NLS-1$
		Monitor monitorEjemplo3 = new Monitor("Martín", "García Ortega", "05673822Q", "625 89 09 73", null, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				"destroyerManhattan@gmail.com", "Estudios post-universitarios", "Vacaciones", "15:00-23:00", 1540.0, 30, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				idiomas3, new ImageIcon(VentanaInicio.class.getResource("./avatarMonitorEjemplo3.png"))); //$NON-NLS-1$
		monitoresDb.addMonitor(monitorEjemplo1);
		monitoresDb.addMonitor(monitorEjemplo2);
		monitoresDb.addMonitor(monitorEjemplo3);

		setTitle("Camping Mudez"); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaInicio.class.getResource("/presentacion/campingMudez.png"))); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 516);
		contentPane = new JPanel();
		contentPane.setBackground(colorBarraBusqueda);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.usuarios = usuarios;
		this.usuarioPrincipal = usuarios.getUsuario();

		JToolBar tbGestion = new JToolBar();
		tbGestion.setName("tbGestion"); //$NON-NLS-1$
		tbGestion.setBackground(colorTbGestion);
		tbGestion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				MessagesVentanaInicio.getString("VentanaInicio.tbGestion.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
		tbGestion.setOrientation(SwingConstants.VERTICAL);
		tbGestion.setFloatable(false);
		contentPane.add(tbGestion, BorderLayout.WEST);

		final Component verticalGlue_5 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_5);

		btnGestorReservas = new JButton(MessagesVentanaInicio.getString("VentanaInicio.btnGestorReservas.text")); //$NON-NLS-1$
		btnGestorReservas.setToolTipText(
				MessagesVentanaInicio.getString("VentanaInicio.btnGestorReservas.toolTipText")); //$NON-NLS-1$
		btnGestorReservas.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoReservas.png"))); //$NON-NLS-1$
		btnGestorReservas.setMargin(new Insets(10, 15, 10, 15));
		btnGestorReservas.setBackground(colorBotonesGestion);
		btnGestorReservas.setFocusable(false);
		btnGestorReservas.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		tbGestion.add(btnGestorReservas);

		final Component verticalGlue_2 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_2);

		btnGestorActividades = new JButton(MessagesVentanaInicio.getString("VentanaInicio.btnGestorActividades.text")); //$NON-NLS-1$
		btnGestorActividades.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.btnGestorActividades.toolTipText")); //$NON-NLS-1$
		btnGestorActividades
				.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoActividades.png"))); //$NON-NLS-1$
		btnGestorActividades.setMargin(new Insets(10, 9, 10, 9));
		btnGestorActividades.setBackground(colorBotonesGestion);
		btnGestorActividades.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorActividades.setFocusable(false);
		btnGestorActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGestorActividades.setBackground(colorBotonSeleccionado);
		tbGestion.add(btnGestorActividades);

		final Component verticalGlue_3 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_3);

		btnGestorMonitores = new JButton(MessagesVentanaInicio.getString("VentanaInicio.btnGestorMonitores.text")); //$NON-NLS-1$
		btnGestorMonitores.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.btnGestorMonitores.toolTipText")); //$NON-NLS-1$
		btnGestorMonitores.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoMonitores.png"))); //$NON-NLS-1$
		btnGestorMonitores.setMargin(new Insets(10, 14, 10, 14));
		btnGestorMonitores.setBackground(colorBotonesGestion);
		btnGestorMonitores.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorMonitores.setFocusable(false);
		btnGestorMonitores.setAlignmentX(0.5f);
		tbGestion.add(btnGestorMonitores);

		final Component verticalGlue_4 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_4);

		btnRutasSenderistas = new JButton(MessagesVentanaInicio.getString("VentanaInicio.btnRutasSenderistas.text")); //$NON-NLS-1$
		btnRutasSenderistas.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.btnRutasSenderistas.toolTipText")); //$NON-NLS-1$
		btnRutasSenderistas.setMargin(new Insets(14, 30, 10, 30));
		btnRutasSenderistas.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoRutas.png"))); //$NON-NLS-1$
		btnRutasSenderistas.setBackground(colorBotonesGestion);
		btnRutasSenderistas.addActionListener(new BtnSeleccionarGestorActionListener());
		btnRutasSenderistas.setFocusable(false);
		btnRutasSenderistas.setAlignmentX(0.5f);
		tbGestion.add(btnRutasSenderistas);

		final Component verticalGlue_1 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_1);

		pnlListaFormulario = new JPanel();
		pnlListaFormulario.setName("pnlListaFormulario"); //$NON-NLS-1$
		pnlListaFormulario.setBackground(colorFondo);
		pnlListaFormulario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		contentPane.add(pnlListaFormulario, BorderLayout.CENTER);
		pnlListaFormulario.setLayout(new CardLayout(0, 0));

		// Añadiendo los paneles al panel con cardLayout
		pnlActividades = new PanelActividades();
		pnlMonitores = new PanelMonitores(monitoresDb);
		pnlReservas = new PanelAlojamientos();
		pnlRutas = new PanelRutas(monitoresDb);
		pnlConfiguracion = new PanelConfiguracion(this, usuarios, usuarioPrincipal);
		pnlActividades.setBackground(colorFondo);
		pnlMonitores.setBackground(colorFondo);
		pnlListaFormulario.add(pnlActividades, "Actividades"); //$NON-NLS-1$
		pnlListaFormulario.add(pnlMonitores, "Monitores"); //$NON-NLS-1$
		pnlListaFormulario.add(pnlReservas, "Reservas"); //$NON-NLS-1$
		pnlListaFormulario.add(pnlRutas, "Rutas"); //$NON-NLS-1$
		pnlListaFormulario.add(pnlConfiguracion, "Configuración"); //$NON-NLS-1$

		JLabel lblInfoLegal = new JLabel(MessagesVentanaInicio.getString("VentanaInicio.lblInfoLegal.text")); //$NON-NLS-1$
		lblInfoLegal.setName("lblInfoLegal"); //$NON-NLS-1$
		lblInfoLegal.setBackground(colorBarraBusqueda);
		lblInfoLegal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfoLegal, BorderLayout.SOUTH);

		pnlMenu = new JPanel();
		pnlMenu.setName("pnlMenu"); //$NON-NLS-1$
		pnlMenu.setBackground(colorFondo);
		pnlMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(pnlMenu, BorderLayout.NORTH);
		GridBagLayout gbl_pnlMenu = new GridBagLayout();
		gbl_pnlMenu.columnWidths = new int[] { 620, 132, 0 };
		gbl_pnlMenu.rowHeights = new int[] { 39, 0 };
		gbl_pnlMenu.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlMenu.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlMenu.setLayout(gbl_pnlMenu);

		JToolBar tbUsuario = new JToolBar();
		tbUsuario.setMaximumSize(new Dimension(13, 25));
		tbUsuario.setName("tbUsuario"); //$NON-NLS-1$
		tbUsuario.setBackground(colorFondo);
		tbUsuario.setBorder(new TitledBorder(null, MessagesVentanaInicio.getString("VentanaInicio.tbUsuario.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		tbUsuario.setFloatable(false);
		tbUsuario.setMargin(new Insets(0, 0, 0, 50));
		GridBagConstraints gbc_tbUsuario = new GridBagConstraints();
		gbc_tbUsuario.fill = GridBagConstraints.BOTH;
		gbc_tbUsuario.anchor = GridBagConstraints.NORTHWEST;
		gbc_tbUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_tbUsuario.gridx = 0;
		gbc_tbUsuario.gridy = 0;
		pnlMenu.add(tbUsuario, gbc_tbUsuario);

		final Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setName("horizontalStrut_2"); //$NON-NLS-1$
		tbUsuario.add(horizontalStrut_2);

		this.lblAvatar = new JLabel(""); //$NON-NLS-1$
		lblAvatar.setName("lblAvatar"); //$NON-NLS-1$
		this.lblAvatar.setIcon(usuarioPrincipal.getAvatar());
		this.lblAvatar.setBackground(colorFondo);
		tbUsuario.add(lblAvatar);

		final Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setName("horizontalStrut"); //$NON-NLS-1$
		tbUsuario.add(horizontalStrut);

		this.lblName = new JLabel(usuarioPrincipal.getNombreUsuario());
		lblName.setName("lblName"); //$NON-NLS-1$
		this.lblName.setFont(new Font("Times New Roman", Font.BOLD, 14)); //$NON-NLS-1$
		this.lblName.setBackground(colorFondo);
		tbUsuario.add(lblName);

		final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_1);

		String ultimaConexion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")).toString(); //$NON-NLS-1$
		JLabel lblUltimaConexion = new JLabel(ultimaConexion);
		lblUltimaConexion.setFont(new Font("Times New Roman", Font.BOLD, 14)); //$NON-NLS-1$
		lblUltimaConexion.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.lblUltimaConexion.toolTipText")); //$NON-NLS-1$
		lblUltimaConexion.setBackground(colorFondo);
		tbUsuario.add(lblUltimaConexion);

		final Component horizontalGlue = Box.createHorizontalGlue();
		tbUsuario.add(horizontalGlue);

		JButton btnConfiguracion = new JButton(""); //$NON-NLS-1$
		btnConfiguracion.addActionListener(new BtnConfiguracionActionListener());
		btnConfiguracion.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.btnConfiguracion.toolTipText")); //$NON-NLS-1$
		btnConfiguracion
				.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoConfiguracion.png"))); //$NON-NLS-1$
		btnConfiguracion.setBackground(colorFondo);
		btnConfiguracion.setFocusPainted(false);
		tbUsuario.add(btnConfiguracion);

		final Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_3);

		final JButton btnLogOut = new JButton(""); //$NON-NLS-1$
		btnLogOut.addActionListener(new BtnLogOutActionListener());
		btnLogOut.setToolTipText(MessagesVentanaInicio.getString("VentanaInicio.btnLogOut.toolTipText")); //$NON-NLS-1$
		btnLogOut.setBackground(colorFondo);
		btnLogOut.setFocusPainted(false);
		btnLogOut.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoLogout.png"))); //$NON-NLS-1$
		tbUsuario.add(btnLogOut);

		JMenuBar mnbAyuda = new JMenuBar();
		mnbAyuda.setName("mnbAyuda"); //$NON-NLS-1$
		mnbAyuda.setBackground(colorFondo);
		GridBagConstraints gbc_mnbAyuda = new GridBagConstraints();
		gbc_mnbAyuda.fill = GridBagConstraints.BOTH;
		gbc_mnbAyuda.anchor = GridBagConstraints.NORTHWEST;
		gbc_mnbAyuda.gridx = 1;
		gbc_mnbAyuda.gridy = 0;
		pnlMenu.add(mnbAyuda, gbc_mnbAyuda);

		final JMenu mnAyuda = new JMenu(MessagesVentanaInicio.getString("VentanaInicio.66")); //$NON-NLS-1$
		mnAyuda.setBackground(colorFondo);
		mnAyuda.setMnemonic('A');
		mnbAyuda.add(mnAyuda);

		JMenuItem mntmManualUsuario = new JMenuItem(MessagesVentanaInicio.getString("VentanaInicio.mntmManualUsuario.text")); //$NON-NLS-1$
		mntmManualUsuario.addActionListener(new MntmManualUsuarioActionListener());
		mnAyuda.add(mntmManualUsuario);
		
		JMenuItem mntmEmail = new JMenuItem(MessagesVentanaInicio.getString("VentanaInicio.mntmNewMenuItem.text")); //$NON-NLS-1$
		mntmEmail.addActionListener(new MntmEmailActionListener());
		mnAyuda.add(mntmEmail);
	}

	private class BtnSeleccionarGestorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand().equals("Actividades") || arg0.getActionCommand().equals("Activities")) { //$NON-NLS-1$ //$NON-NLS-2$
				btnGestorActividades.setBackground(colorBotonSeleccionado);
				btnGestorMonitores.setBackground(colorBotonesGestion);
				btnGestorReservas.setBackground(colorBotonesGestion);
				btnRutasSenderistas.setBackground(colorBotonesGestion);
				((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, "Actividades"); //$NON-NLS-1$
			} else if (arg0.getActionCommand().equals("Reservas") || arg0.getActionCommand().equals("Reservations")) { //$NON-NLS-1$ //$NON-NLS-2$
				btnGestorActividades.setBackground(colorBotonesGestion);
				btnGestorMonitores.setBackground(colorBotonesGestion);
				btnGestorReservas.setBackground(colorBotonSeleccionado);
				btnRutasSenderistas.setBackground(colorBotonesGestion);
				((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, "Reservas"); //$NON-NLS-1$
			} else if (arg0.getActionCommand().equals("Rutas") || arg0.getActionCommand().equals("Routes")) { //$NON-NLS-1$ //$NON-NLS-2$
				btnGestorActividades.setBackground(colorBotonesGestion);
				btnGestorMonitores.setBackground(colorBotonesGestion);
				btnGestorReservas.setBackground(colorBotonesGestion);
				btnRutasSenderistas.setBackground(colorBotonSeleccionado);
				((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, "Rutas"); //$NON-NLS-1$
			} else if (arg0.getActionCommand().equals("Monitores") || arg0.getActionCommand().equals("Monitors")) { //$NON-NLS-1$ //$NON-NLS-2$
				btnGestorActividades.setBackground(colorBotonesGestion);
				btnGestorMonitores.setBackground(colorBotonSeleccionado);
				btnGestorReservas.setBackground(colorBotonesGestion);
				btnRutasSenderistas.setBackground(colorBotonesGestion);
				((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, "Monitores"); //$NON-NLS-1$
			}
			pnlMenu.repaint();
		}
	}

	private class BtnLogOutActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ventanaLogin ventanaLogin = new ventanaLogin();
			dispose();
			ventanaLogin.getFrame().setVisible(true);
		}
	}

	private class BtnConfiguracionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, "Configuración"); //$NON-NLS-1$
		}
	}

	public void openWebPage(String url) {
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private class MntmManualUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			openWebPage("https://www.youtube.com/playlist?list=PLm5gPPPhlUenezECNoXFjdU6I4TXCYo41"); //$NON-NLS-1$
		}
	}
	private class MntmEmailActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			contactanos();
		}
	}
	public void contactanos() {
		Desktop desktop;
		if (Desktop.isDesktopSupported() 
		    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
		  URI mailto = null;
		try {
			mailto = new URI("mailto:campingMudez@gmail.com?subject=Duda%20aplicacion%20Camping%20Mudez"); //$NON-NLS-1$
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			desktop.mail(mailto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
		  // TODO fallback to some Runtime.exec(..) voodoo?
		  throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)"); //$NON-NLS-1$
		}
	}
}
