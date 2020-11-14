package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;

public class ventanaLogin {

	private JFrame frmCampingMudez;
	private JPanel pnlIdioma;
	private JComboBox cbIdioma;
	private JPanel pnlLogin;
	private JLabel lblLogoCamping;
	private JLabel lblInfoLegal;
	private JPanel pnlTFLogin;
	private JTextField txtNombreUsuario;
	private JFormattedTextField ftxtContrasenia;
	private JCheckBox chckbxRecuerdame;
	private JButton btnLogin;
	private JLabel lblOlvido;

	private Object[] items = {new ImageIcon("english.png"), new ImageIcon("spain.png")};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogin window = new ventanaLogin();
					window.frmCampingMudez.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCampingMudez = new JFrame();
		frmCampingMudez.setBackground(Color.WHITE);
		frmCampingMudez.setTitle("Camping Mudez");
		frmCampingMudez.setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaLogin.class.getResource("/presentacion/campingMudez.png")));
		
		// Hacer que la frame ocupe toda la pantalla
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				
		frmCampingMudez.setBounds(150, 15, 950, 700);
		frmCampingMudez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlIdioma = new JPanel();
		
		pnlIdioma.setBackground(new java.awt.Color(243, 243, 245));
		
		
		frmCampingMudez.getContentPane().add(pnlIdioma, BorderLayout.NORTH);
		GridBagLayout gbl_pnlIdioma = new GridBagLayout();
		gbl_pnlIdioma.columnWidths = new int[]{769, 98, 0, 0};
		gbl_pnlIdioma.rowHeights = new int[]{16, 0, 0};
		gbl_pnlIdioma.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlIdioma.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlIdioma.setLayout(gbl_pnlIdioma);
		
		cbIdioma = new JComboBox();
		cbIdioma.setRenderer(new ModeloIdiomaCB());
		
		GridBagConstraints gbc_cbIdioma = new GridBagConstraints();
		gbc_cbIdioma.insets = new Insets(0, 0, 0, 5);
		gbc_cbIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbIdioma.gridx = 1;
		gbc_cbIdioma.gridy = 1;
		pnlIdioma.add(cbIdioma, gbc_cbIdioma);
		
		pnlLogin = new JPanel();
		frmCampingMudez.getContentPane().add(pnlLogin, BorderLayout.CENTER);
		
		pnlLogin.setBackground(new java.awt.Color(243, 243, 245));
		
		pnlLogin.setLayout(new BorderLayout(0, 0));
		
		lblLogoCamping = new JLabel("");
		lblLogoCamping.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoCamping.setIcon(new ImageIcon(ventanaLogin.class.getResource("/presentacion/campingMudez.png")));
		lblLogoCamping.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlLogin.add(lblLogoCamping, BorderLayout.NORTH);
		
		pnlTFLogin = new JPanel();
		
		pnlTFLogin.setBackground(new java.awt.Color(243, 243, 245));
		
		pnlLogin.add(pnlTFLogin, BorderLayout.CENTER);
		GridBagLayout gbl_pnlTFLogin = new GridBagLayout();
		gbl_pnlTFLogin.columnWidths = new int[]{254, 450, 230, 0};
		gbl_pnlTFLogin.rowHeights = new int[]{0, 0, 0, 38, 31, 49, 0, 0};
		gbl_pnlTFLogin.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTFLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTFLogin.setLayout(gbl_pnlTFLogin);
		
		txtNombreUsuario = new JTextField();
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreUsuario.gridx = 1;
		gbc_txtNombreUsuario.gridy = 0;
		pnlTFLogin.add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		ftxtContrasenia = new JFormattedTextField();
		GridBagConstraints gbc_ftxtContrasenia = new GridBagConstraints();
		gbc_ftxtContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtContrasenia.gridx = 1;
		gbc_ftxtContrasenia.gridy = 1;
		pnlTFLogin.add(ftxtContrasenia, gbc_ftxtContrasenia);
		ftxtContrasenia.setColumns(10);
		
		chckbxRecuerdame = new JCheckBox("Recuérdame");
		GridBagConstraints gbc_chckbxRecuerdame = new GridBagConstraints();
		gbc_chckbxRecuerdame.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRecuerdame.gridx = 1;
		gbc_chckbxRecuerdame.gridy = 2;
		pnlTFLogin.add(chckbxRecuerdame, gbc_chckbxRecuerdame);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(new Rectangle(0, 0, 100, 100));
		btnLogin.setMinimumSize(new Dimension(80, 50));
		btnLogin.setMaximumSize(new Dimension(70, 70));
		
		btnLogin.setBackground(new java.awt.Color(159, 177, 57));
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 4;
		pnlTFLogin.add(btnLogin, gbc_btnLogin);
		
		lblOlvido = new JLabel("Olvidé mi contraseña o usuario");
		GridBagConstraints gbc_lblOlvido = new GridBagConstraints();
		gbc_lblOlvido.insets = new Insets(0, 0, 0, 5);
		gbc_lblOlvido.gridx = 1;
		gbc_lblOlvido.gridy = 6;
		pnlTFLogin.add(lblOlvido, gbc_lblOlvido);
		
		lblInfoLegal = new JLabel("");
		frmCampingMudez.getContentPane().add(lblInfoLegal, BorderLayout.SOUTH);
	}

}
