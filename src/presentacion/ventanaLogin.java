package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import dominio.Usuario;
import persistencia.Usuarios;

import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private TextPrompt nombreUsuario;
	private TextPrompt contrasenia;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorResaltado = new Color(226, 224, 64);
	private Color colorBoton = new Color(159, 177, 57);
	
	private JButton btnEspaniol;
	private JButton btnIngles;
	
	File file = new File("./src/persistencia/credenciales-usuario.txt");
	private String USER;
	private String PASSWORD;
	Icon wrong = new ImageIcon(ventanaLogin.class.getResource("/presentacion/iconoWrong.png"));
	private JLabel lblWrongUsuario;
	private JLabel lblWrongPassword;
	private JLabel lblMensajeError;
	
	private Usuarios usuarios = new Usuarios();

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
	
	public JFrame getFrame() {
		return this.frmCampingMudez;
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
		gbl_pnlTFLogin.columnWidths = new int[] { 254, 423, 254, 0 };
		gbl_pnlTFLogin.rowHeights = new int[] { 0, 0, 0, 0, 27, 0, 37, 0, 0 };
		gbl_pnlTFLogin.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlTFLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		
		lblWrongUsuario = new JLabel("");
		GridBagConstraints gbc_lblWrongUsuario = new GridBagConstraints();
		gbc_lblWrongUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblWrongUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblWrongUsuario.gridx = 2;
		gbc_lblWrongUsuario.gridy = 0;
		pnlTFLogin.add(lblWrongUsuario, gbc_lblWrongUsuario);
		
		GridBagConstraints gbc_pwfContrasenia = new GridBagConstraints();
		gbc_pwfContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_pwfContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwfContrasenia.gridx = 1;
		gbc_pwfContrasenia.gridy = 1;
		pnlTFLogin.add(pwfContrasenia, gbc_pwfContrasenia);
		pwfContrasenia.setColumns(10);
		
		pwfContrasenia.setEchoChar('*');
		
		lblWrongPassword = new JLabel("");
		GridBagConstraints gbc_lblWrongPassword = new GridBagConstraints();
		gbc_lblWrongPassword.anchor = GridBagConstraints.WEST;
		gbc_lblWrongPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblWrongPassword.gridx = 2;
		gbc_lblWrongPassword.gridy = 1;
		pnlTFLogin.add(lblWrongPassword, gbc_lblWrongPassword);
		
		lblMensajeError = new JLabel("");
		GridBagConstraints gbc_lblMensajeError = new GridBagConstraints();
		gbc_lblMensajeError.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensajeError.gridx = 1;
		gbc_lblMensajeError.gridy = 2;
		pnlTFLogin.add(lblMensajeError, gbc_lblMensajeError);

		chckbxRecuerdame = new JCheckBox("Recuérdame");
		chckbxRecuerdame.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_chckbxRecuerdame = new GridBagConstraints();
		gbc_chckbxRecuerdame.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRecuerdame.gridx = 1;
		gbc_chckbxRecuerdame.gridy = 3;
		pnlTFLogin.add(chckbxRecuerdame, gbc_chckbxRecuerdame);
		chckbxRecuerdame.setBackground(colorFondo);

		btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new BtnLoginKeyListener());
		btnLogin.addActionListener(new BtnLoginActionListener());
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();

		btnLogin.setBackground(colorBoton);

		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 5;
		pnlTFLogin.add(btnLogin, gbc_btnLogin);

		lblOlvido = new JLabel("<html><u>Olvidé mi contraseña o usuario</u></html>");
		lblOlvido.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlvido.addMouseListener(new LblOlvidoMouseListener());
		lblOlvido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOlvido.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblOlvido = new GridBagConstraints();
		gbc_lblOlvido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOlvido.insets = new Insets(0, 0, 0, 5);
		gbc_lblOlvido.gridx = 1;
		gbc_lblOlvido.gridy = 7;
		pnlTFLogin.add(lblOlvido, gbc_lblOlvido);

		lblInfoLegal = new JLabel("Done by: elena.desdentado@alu.uclm.es and ruben.grande@alu.uclm.es");
		lblInfoLegal.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLegal.setForeground(Color.BLACK);
		lblInfoLegal.setBackground(Color.WHITE);
		frmCampingMudez.getContentPane().add(lblInfoLegal, BorderLayout.SOUTH);
		
		update();
		
		// Text Prompt para indicar lo que hay que escribir en los text field
		nombreUsuario = new TextPrompt("Nombre de usuario", txtNombreUsuario);
		contrasenia = new TextPrompt("Contraseña", pwfContrasenia);
		
		
	}
	
	public void update() {
		try {
	          if(file.exists()){

	            Scanner scan = new Scanner(file);
	            USER = scan.nextLine();
	            PASSWORD = scan.nextLine();
	            txtNombreUsuario.setText(USER);  
	            pwfContrasenia.setText(PASSWORD);
	            chckbxRecuerdame.setSelected(true);
	            scan.close();
	          } else {
	        	  File credencialesIniciales = new File("./credenciales.txt");
	        	  Scanner scan = new Scanner(credencialesIniciales);
		          USER = scan.nextLine();
		          PASSWORD = scan.nextLine();
	          }

	        } catch (FileNotFoundException e) {         
	            e.printStackTrace();
	        } 
	}

	public void save() {
		try {
            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(txtNombreUsuario.getText()); //write the name
            bw.newLine(); //leave a new Line
            bw.write(pwfContrasenia.getPassword()); //write the password
            bw.close(); //close the BufferdWriter

        } catch (IOException e) { e.printStackTrace(); } 
	}
	
	public boolean delete() {
		return file.delete();
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
			Usuario nuevoUsuario = new Usuario(new ImageIcon(VentanaInicio.class.getResource("/presentacion/avatarUsuario.png")), USER, PASSWORD);
			usuarios.addUsuario(nuevoUsuario);
			
			lblWrongUsuario.setIcon(null); lblWrongPassword.setIcon(null);
			// CHECKEO DE CREDENCIALES
			if(txtNombreUsuario.getText().equals(USER) && String.valueOf(pwfContrasenia.getPassword()).equals(PASSWORD)) {
				if(chckbxRecuerdame.isSelected()) save();
				else delete();
				VentanaInicio inicio = new VentanaInicio(USER, PASSWORD, usuarios);
				frmCampingMudez.dispose();
				inicio.setVisible(true);
				// Hacer que la frame ocupe toda la pantalla
				inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} else if(!(txtNombreUsuario.getText().equals(USER)) && !(String.valueOf(pwfContrasenia.getPassword()).equals(PASSWORD))) {
				lblWrongUsuario.setIcon(wrong);
				lblWrongPassword.setIcon(wrong);
				lblMensajeError.setText("Nombre de usuario y contraseña incorrectos. Intente de nuevo.");
				lblMensajeError.setForeground(Color.RED);
			} else if (!txtNombreUsuario.getText().equals(USER)){
				lblWrongUsuario.setIcon(wrong);
				lblMensajeError.setText("Nombre de usuario incorrecto. Intente de nuevo.");
				lblMensajeError.setForeground(Color.RED);
			} else if (!String.valueOf(pwfContrasenia.getPassword()).equals(PASSWORD)) {
				lblWrongPassword.setIcon(wrong);
				lblMensajeError.setText("Contraseña incorrecta. Intente de nuevo.");
				lblMensajeError.setForeground(Color.RED);
			}
		}
	}
	private class BtnLoginKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				// CHECKEO DE CREDENCIALES
				if(txtNombreUsuario.getText() == USER && String.valueOf(pwfContrasenia.getPassword()) == PASSWORD) {
					if(chckbxRecuerdame.isSelected()) save();
					else delete();
					VentanaInicio inicio = new VentanaInicio(USER, PASSWORD, usuarios);
					frmCampingMudez.dispose();
					inicio.setVisible(true);
					// Hacer que la frame ocupe toda la pantalla
					inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
				else {
					lblWrongUsuario.setIcon(wrong);
					lblWrongPassword.setIcon(wrong);
					if (!txtNombreUsuario.getText().equals(USER)) {
						lblMensajeError.setText("Nombre de usuario incorrecto. Intente de nuevo.");
						lblMensajeError.setForeground(Color.RED);
					}
					else {
						lblMensajeError.setText("Contraseña incorrecta. Intente de nuevo.");
						lblMensajeError.setForeground(Color.RED);
					}
				}
		    }
		}
	}
	private class LblOlvidoMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(frmCampingMudez, "Pedira cambiar la contraseña o el usuario", "Reestablecer credenciales", JOptionPane.INFORMATION_MESSAGE);;
		}
	}
}
