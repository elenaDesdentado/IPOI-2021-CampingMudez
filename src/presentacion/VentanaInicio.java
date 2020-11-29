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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JPanel pnlActividades;
	private JPanel pnlMonitores;
	private JPanel pnlReservas;
	private JPanel pnlRutas;
	private JButton btnGestorReservas;
	private JButton btnGestorActividades;
	private JButton btnGestorMonitores;
	private JButton btnRutasSenderistas;
	private JPanel pnlListaFormulario;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBarraBusqueda = new Color(231, 227, 218);
	private Color colorTbGestion = new Color(51, 153, 51);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setTitle("Camping Mudez");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaInicio.class.getResource("/presentacion/campingMudez.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 516);
		contentPane = new JPanel();
		contentPane.setBackground(colorBarraBusqueda);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar tbGestion = new JToolBar();
		tbGestion.setBackground(new Color(51, 153, 51));
		tbGestion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gesti\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tbGestion.setOrientation(SwingConstants.VERTICAL);
		tbGestion.setFloatable(false);
		contentPane.add(tbGestion, BorderLayout.WEST);

		final Component verticalGlue_5 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_5);

		btnGestorReservas = new JButton("Reservas");
		btnGestorReservas.setToolTipText("Haz click para gestionar las reservas de los campings y bungalows ofertados por Campings Mudez");
		btnGestorReservas.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoReservas.png")));
		btnGestorReservas.setMargin(new Insets(10, 15, 10, 15));
		btnGestorReservas.setBackground(colorTbGestion );
		btnGestorReservas.setFocusable(false);
		btnGestorReservas.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		tbGestion.add(btnGestorReservas);

		final Component verticalGlue_2 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_2);

		btnGestorActividades = new JButton("Actividades");
		btnGestorActividades.setToolTipText("Haz click para gestionar las actividades ofertadas por Campings Mudez");
		btnGestorActividades.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoActividades.png")));
		btnGestorActividades.setMargin(new Insets(10, 10, 10, 10));
		btnGestorActividades.setBackground(colorTbGestion );
		btnGestorActividades.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorActividades.setFocusable(false);
		btnGestorActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		tbGestion.add(btnGestorActividades);

		final Component verticalGlue_3 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_3);

		btnGestorMonitores = new JButton("Monitores");
		btnGestorMonitores.setToolTipText("Haz click para gestionar los monitores que trabajan en Campings Mudez");
		btnGestorMonitores.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoMonitores.png")));
		btnGestorMonitores.setMargin(new Insets(10, 14, 10, 14));
		btnGestorMonitores.setBackground(colorTbGestion);
		btnGestorMonitores.addActionListener(new BtnSeleccionarGestorActionListener());
		btnGestorMonitores.setFocusable(false);
		btnGestorMonitores.setAlignmentX(0.5f);
		tbGestion.add(btnGestorMonitores);

		final Component verticalGlue_4 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_4);

		btnRutasSenderistas = new JButton("Rutas");
		btnRutasSenderistas.setToolTipText("Haz click para gestionar las rutas ofertadas por Campings Mudez");
		btnRutasSenderistas.setMargin(new Insets(10, 28, 10, 28));
		btnRutasSenderistas.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/iconoRutas.png")));
		btnRutasSenderistas.setBackground(colorTbGestion);
		btnRutasSenderistas.addActionListener(new BtnSeleccionarGestorActionListener());
		btnRutasSenderistas.setFocusable(false);
		btnRutasSenderistas.setAlignmentX(0.5f);
		tbGestion.add(btnRutasSenderistas);

		final Component verticalGlue_1 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_1);

		pnlListaFormulario = new JPanel();
		pnlListaFormulario.setBackground(colorFondo);
		pnlListaFormulario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlListaFormulario, BorderLayout.CENTER);
		pnlListaFormulario.setLayout(new CardLayout(0, 0));

		// Añadiendo los paneles al panel con cardLayout
		pnlActividades = new PanelActividades();
		pnlMonitores = new PanelMonitores();
		pnlReservas = new JPanel();
		pnlRutas = new JPanel();
		pnlActividades.setBackground(colorFondo);
		pnlMonitores.setBackground(colorFondo);
		pnlListaFormulario.add(pnlActividades, "Actividades");
		pnlListaFormulario.add(pnlMonitores, "Monitores");
		pnlListaFormulario.add(pnlReservas, "Reservas");
		pnlListaFormulario.add(pnlRutas, "Rutas");
		

		JLabel lblInfoLegal = new JLabel("Done by: elena.desdentado@alu.uclm.es and ruben.grande@alu.uclm.es");
		lblInfoLegal.setBackground(colorBarraBusqueda);
		lblInfoLegal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfoLegal, BorderLayout.SOUTH);

		JPanel pnlMenu = new JPanel();
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
		tbUsuario.setBackground(colorFondo);
		tbUsuario.setBorder(new TitledBorder(null, "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		tbUsuario.add(horizontalStrut_2);

		JLabel lblAvatar = new JLabel("AVATAR");
		lblAvatar.setBackground(colorFondo);
		tbUsuario.add(lblAvatar);

		final Component horizontalStrut = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut);

		JLabel lblName = new JLabel("NAME");
		lblName.setBackground(colorFondo);
		tbUsuario.add(lblName);

		final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_1);

		JLabel lblUltimaConexion = new JLabel("ULTIMA CONEXION");
		lblUltimaConexion.setBackground(colorFondo);
		tbUsuario.add(lblUltimaConexion);

		final Component horizontalGlue = Box.createHorizontalGlue();
		tbUsuario.add(horizontalGlue);

		JButton btnConfiguracion = new JButton("CONFIG");
		btnConfiguracion.setBackground(colorFondo);
		btnConfiguracion.setFocusPainted(false);
		tbUsuario.add(btnConfiguracion);

		final Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_3);

		final JButton btnLogOut = new JButton("");
		btnLogOut.setBackground(colorFondo);
		btnLogOut.setFocusPainted(false);
		btnLogOut.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/espaniol.png")));
		tbUsuario.add(btnLogOut);

		JMenuBar mnbAyuda = new JMenuBar();
		mnbAyuda.setBackground(colorFondo);
		GridBagConstraints gbc_mnbAyuda = new GridBagConstraints();
		gbc_mnbAyuda.fill = GridBagConstraints.BOTH;
		gbc_mnbAyuda.anchor = GridBagConstraints.NORTHWEST;
		gbc_mnbAyuda.gridx = 1;
		gbc_mnbAyuda.gridy = 0;
		pnlMenu.add(mnbAyuda, gbc_mnbAyuda);

		final JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setBackground(colorFondo);
		mnAyuda.setMnemonic('A');
		mnbAyuda.add(mnAyuda);

		final JMenuItem mntmReadMe = new JMenuItem("Acceder a la documentación en línea");
		mntmReadMe.setBackground(colorFondo);
		mnAyuda.add(mntmReadMe);
	}
	private class BtnSeleccionarGestorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, arg0.getActionCommand());
		}
	}
}
