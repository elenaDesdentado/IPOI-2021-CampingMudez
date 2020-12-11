package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaLogin {

	private JFrame frmCampingMudez;
	private JPanel pnlIdioma;
	private JPanel pnlLogin;
	private JLabel lblLogoCamping;
	private JLabel lblInfoLegal;
	private JPanel pnlTFLogin;
	private JTextField txtNombreUsuario;
	private JPasswordField pwfContrasenia;
	private JCheckBox chckbxRecuerdame;
	private JButton btnLogin;
	private JLabel lblOlvido;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorResaltado = new Color(226, 224, 64);
	private Color colorBoton = new Color(159, 177, 57);
	
	private JButton btnEspaniol;
	private JButton btnIngles;

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
		frmCampingMudez.setTitle("Camping Mudez");
		frmCampingMudez.setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaLogin.class.getResource("/presentacion/campingMudez.png")));
		frmCampingMudez.setResizable(false);

		frmCampingMudez.setBounds(275, 20, 850, 600);
		frmCampingMudez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Center of the screen
		frmCampingMudez.setLocationRelativeTo(null);

		pnlIdioma = new JPanel();

		// Background color change
		pnlIdioma.setBackground(colorFondo);

		frmCampingMudez.getContentPane().add(pnlIdioma, BorderLayout.NORTH);
		GridBagLayout gbl_pnlIdioma = new GridBagLayout();
		gbl_pnlIdioma.columnWidths = new int[] { 679, 50, 40, 0, 0 };
		gbl_pnlIdioma.rowHeights = new int[] { 16, 10, 0 };
		gbl_pnlIdioma.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlIdioma.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pnlIdioma.setLayout(gbl_pnlIdioma);
		
		btnEspaniol = new JButton("");
		btnEspaniol.setFocusable(false);
		btnEspaniol.setIcon(new ImageIcon(ventanaLogin.class.getResource("/presentacion/espaniol.png")));
		btnEspaniol.setBackground(colorFondo);
		GridBagConstraints gbc_btnEspaniol = new GridBagConstraints();
		gbc_btnEspaniol.insets = new Insets(0, 0, 0, 5);
		gbc_btnEspaniol.gridx = 1;
		gbc_btnEspaniol.gridy = 1;
		pnlIdioma.add(btnEspaniol, gbc_btnEspaniol);
		
		btnIngles = new JButton("");
		btnIngles.setFocusable(false);
		btnIngles.setIcon(new ImageIcon(ventanaLogin.class.getResource("/presentacion/ingles.png")));
		btnIngles.setBackground(colorFondo);
		GridBagConstraints gbc_btnIngles = new GridBagConstraints();
		gbc_btnIngles.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngles.gridx = 2;
		gbc_btnIngles.gridy = 1;
		pnlIdioma.add(btnIngles, gbc_btnIngles);

		pnlLogin = new JPanel();

		// Background color change
		pnlLogin.setBackground(colorFondo);

		frmCampingMudez.getContentPane().add(pnlLogin, BorderLayout.CENTER);
		pnlLogin.setLayout(new BorderLayout(0, 0));

		lblLogoCamping = new JLabel("");
		lblLogoCamping.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoCamping.setIcon(new ImageIcon(ventanaLogin.class.getResource("/presentacion/campingMudez.png")));
		lblLogoCamping.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlLogin.add(lblLogoCamping, BorderLayout.NORTH);

		pnlTFLogin = new JPanel();

		// Background color change
		pnlTFLogin.setBackground(colorFondo);

		pnlLogin.add(pnlTFLogin, BorderLayout.CENTER);
		GridBagLayout gbl_pnlTFLogin = new GridBagLayout();
		gbl_pnlTFLogin.columnWidths = new int[] { 254, 450, 230, 0 };
		gbl_pnlTFLogin.rowHeights = new int[] { 0, 0, 0, 27, 0, 37, 0, 0 };
		gbl_pnlTFLogin.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlTFLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlTFLogin.setLayout(gbl_pnlTFLogin);

		txtNombreUsuario = new JTextField();
		
		txtNombreUsuario.addFocusListener(new MiFocusListener());
		
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreUsuario.gridx = 1;
		gbc_txtNombreUsuario.gridy = 0;
		pnlTFLogin.add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		pwfContrasenia = new JPasswordField();
		
		pwfContrasenia.addFocusListener(new MiFocusListener());
		
		GridBagConstraints gbc_pwfContrasenia = new GridBagConstraints();
		gbc_pwfContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_pwfContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwfContrasenia.gridx = 1;
		gbc_pwfContrasenia.gridy = 1;
		pnlTFLogin.add(pwfContrasenia, gbc_pwfContrasenia);
		pwfContrasenia.setColumns(10);
		
		pwfContrasenia.setEchoChar('*');

		chckbxRecuerdame = new JCheckBox("Recuérdame");
		GridBagConstraints gbc_chckbxRecuerdame = new GridBagConstraints();
		gbc_chckbxRecuerdame.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRecuerdame.gridx = 1;
		gbc_chckbxRecuerdame.gridy = 2;
		pnlTFLogin.add(chckbxRecuerdame, gbc_chckbxRecuerdame);
		chckbxRecuerdame.setBackground(colorFondo);

		btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new BtnLoginKeyListener());
		btnLogin.addActionListener(new BtnLoginActionListener());
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();

		btnLogin.setBackground(colorBoton);

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

		lblInfoLegal = new JLabel("Done by: elena.desdentado@alu.uclm.es and ruben.grande@alu.uclm.es");
		lblInfoLegal.setForeground(Color.BLACK);
		lblInfoLegal.setBackground(Color.WHITE);
		frmCampingMudez.getContentPane().add(lblInfoLegal, BorderLayout.SOUTH);
		
		// Text Prompt para indicar lo que hay que escribir en los text field
		TextPrompt nombreUsuario = new TextPrompt("Nombre de usuario", txtNombreUsuario);
		TextPrompt contrasenia = new TextPrompt("Contraseña", pwfContrasenia);
	}
	

	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorResaltado);
		}
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorFondo);
		}
	}
	private class BtnLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// CHECKEO DE CREDENCIALES 
			VentanaInicio inicio = new VentanaInicio();
			frmCampingMudez.dispose();
			inicio.setVisible(true);
			// Hacer que la frame ocupe toda la pantalla
			inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
	}
	private class BtnLoginKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				VentanaInicio inicio = new VentanaInicio();
				frmCampingMudez.dispose();
				inicio.setVisible(true);
				// Hacer que la frame ocupe toda la pantalla
				inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		    }
		}
	}
}
