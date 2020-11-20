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

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private Container pnlListaFormulario;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar tbGestion = new JToolBar();
		tbGestion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gesti\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tbGestion.setOrientation(SwingConstants.VERTICAL);
		tbGestion.setFloatable(false);
		contentPane.add(tbGestion, BorderLayout.WEST);

		final Component verticalGlue = Box.createVerticalGlue();
		tbGestion.add(verticalGlue);

		final Component verticalGlue_5 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_5);

		final JButton btnGestorReservas = new JButton("Reservas");
		btnGestorReservas.setFocusable(false);
		// btnGestorReservas.setPreferredSize (new Dimension(250, 75));
		btnGestorReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		tbGestion.add(btnGestorReservas);

		final Component verticalGlue_2 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_2);

		final JButton btnGestorActividades = new JButton("Actividades");
		btnGestorActividades.addActionListener(new BtnGestorActividadesActionListener());
		btnGestorActividades.setFocusable(false);
		btnGestorActividades.setAlignmentX(Component.CENTER_ALIGNMENT);
		tbGestion.add(btnGestorActividades);

		final Component verticalGlue_3 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_3);

		final JButton btnGestorMonitores = new JButton("Monitores");
		btnGestorMonitores.setFocusable(false);
		btnGestorMonitores.setAlignmentX(0.5f);
		tbGestion.add(btnGestorMonitores);

		final Component verticalGlue_4 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_4);

		final JButton btnRutasSenderistas = new JButton("Rutas senderistas");
		btnRutasSenderistas.setFocusable(false);
		btnRutasSenderistas.setAlignmentX(0.5f);
		tbGestion.add(btnRutasSenderistas);

		final Component verticalGlue_1 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_1);

		final Component verticalGlue_6 = Box.createVerticalGlue();
		tbGestion.add(verticalGlue_6);

		JPanel pnlListaFormulario = new JPanel();
		pnlListaFormulario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlListaFormulario, BorderLayout.CENTER);
		pnlListaFormulario.setLayout(new CardLayout(0, 0));

		final JPanel pnlActividades = new PanelActividades();
		pnlListaFormulario.add(pnlActividades, "Actividades");
		

		JLabel lblInfoLegal = new JLabel("Done by: elena.desdentado@alu.uclm.es and ruben.grande@alu.uclm.es");
		lblInfoLegal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfoLegal, BorderLayout.SOUTH);

		JPanel pnlMenu = new JPanel();
		pnlMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(pnlMenu, BorderLayout.NORTH);
		GridBagLayout gbl_pnlMenu = new GridBagLayout();
		gbl_pnlMenu.columnWidths = new int[] { 620, 132, 0 };
		gbl_pnlMenu.rowHeights = new int[] { 39, 0 };
		gbl_pnlMenu.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnlMenu.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlMenu.setLayout(gbl_pnlMenu);

		JToolBar tbUsuario = new JToolBar();
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
		tbUsuario.add(lblAvatar);

		final Component horizontalStrut = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut);

		JLabel lblName = new JLabel("NAME");
		tbUsuario.add(lblName);

		final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_1);

		JLabel lblUltimaConexion = new JLabel("ULTIMA CONEXION");
		tbUsuario.add(lblUltimaConexion);

		final Component horizontalGlue = Box.createHorizontalGlue();
		tbUsuario.add(horizontalGlue);

		JButton btnConfiguracion = new JButton("CONFIG");
		btnConfiguracion.setFocusPainted(false);
		tbUsuario.add(btnConfiguracion);

		final Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		tbUsuario.add(horizontalStrut_3);

		final JButton btnLogOut = new JButton("");
		btnLogOut.setFocusPainted(false);
		btnLogOut.setIcon(new ImageIcon(VentanaInicio.class.getResource("/presentacion/espaniol.png")));
		tbUsuario.add(btnLogOut);

		JMenuBar mnbAyuda = new JMenuBar();
		GridBagConstraints gbc_mnbAyuda = new GridBagConstraints();
		gbc_mnbAyuda.fill = GridBagConstraints.BOTH;
		gbc_mnbAyuda.anchor = GridBagConstraints.NORTHWEST;
		gbc_mnbAyuda.gridx = 1;
		gbc_mnbAyuda.gridy = 0;
		pnlMenu.add(mnbAyuda, gbc_mnbAyuda);

		final JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		mnbAyuda.add(mnAyuda);

		final JMenuItem mntmReadMe = new JMenuItem("Acceder a la documentación en línea");
		mnAyuda.add(mntmReadMe);
	}
	private class BtnGestorActividadesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) pnlListaFormulario.getLayout()).show(pnlListaFormulario, arg0.getActionCommand());
		}
	}
}
