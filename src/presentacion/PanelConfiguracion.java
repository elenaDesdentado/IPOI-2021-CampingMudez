package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PanelConfiguracion extends JPanel {
	private JLabel lblAvatar;
	private JButton btnCambiarAvatar;
	private JLabel lblCambiarNombre;
	private JLabel lblCambiarContrasenia;
	private JTextField txtNombreUsuario;
	private JTextField txtPassword;
	private JButton btnAplicarCambios;
	private Color colorBoton = new Color(159, 177, 57);
	private JLabel lblConfirmarContrasenia;
	private JTextField txtPasswordConfirmada;
	private JLabel lblWrongPassword;
	private JLabel lblWrongNombreUsuario;
	private JLabel lblWrongPasswordConfirmation;
	
	public PanelConfiguracion(JFrame framePadre) {
				
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{72, 0, 0, 64, 79, 61, 0, 52, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{68, 0, 0, 0, 47, 15, 15, 20, 0, 44, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAvatar = new JLabel();
		//lblAvatar.setIcon();
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.gridwidth = 3;
		gbc_lblAvatar.gridheight = 2;
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridx = 1;
		gbc_lblAvatar.gridy = 1;
		add(lblAvatar, gbc_lblAvatar);
		
		btnCambiarAvatar = new JButton("Cambiar avatar...");
		GridBagConstraints gbc_btnCambiarAvatar = new GridBagConstraints();
		gbc_btnCambiarAvatar.gridwidth = 3;
		gbc_btnCambiarAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarAvatar.gridx = 1;
		gbc_btnCambiarAvatar.gridy = 3;
		add(btnCambiarAvatar, gbc_btnCambiarAvatar);
		
		lblCambiarNombre = new JLabel("Cambiar nombre de usuario:");
		GridBagConstraints gbc_lblCambiarNombre = new GridBagConstraints();
		gbc_lblCambiarNombre.anchor = GridBagConstraints.EAST;
		gbc_lblCambiarNombre.gridwidth = 3;
		gbc_lblCambiarNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambiarNombre.gridx = 1;
		gbc_lblCambiarNombre.gridy = 5;
		add(lblCambiarNombre, gbc_lblCambiarNombre);
		
		txtNombreUsuario = new JTextField();
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.gridwidth = 3;
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreUsuario.gridx = 4;
		gbc_txtNombreUsuario.gridy = 5;
		add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		lblWrongNombreUsuario = new JLabel("");
		GridBagConstraints gbc_lblWrongNombreUsuario = new GridBagConstraints();
		gbc_lblWrongNombreUsuario.gridwidth = 3;
		gbc_lblWrongNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongNombreUsuario.gridx = 7;
		gbc_lblWrongNombreUsuario.gridy = 5;
		add(lblWrongNombreUsuario, gbc_lblWrongNombreUsuario);
		
		lblCambiarContrasenia = new JLabel("Cambiar contraseña:");
		GridBagConstraints gbc_lblCambiarContrasenia = new GridBagConstraints();
		gbc_lblCambiarContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblCambiarContrasenia.gridwidth = 3;
		gbc_lblCambiarContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambiarContrasenia.gridx = 1;
		gbc_lblCambiarContrasenia.gridy = 6;
		add(lblCambiarContrasenia, gbc_lblCambiarContrasenia);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.gridwidth = 5;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 4;
		gbc_txtPassword.gridy = 6;
		add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		lblWrongPassword = new JLabel("");
		GridBagConstraints gbc_lblWrongPassword = new GridBagConstraints();
		gbc_lblWrongPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongPassword.gridx = 9;
		gbc_lblWrongPassword.gridy = 6;
		add(lblWrongPassword, gbc_lblWrongPassword);
		
		lblConfirmarContrasenia = new JLabel("Confirmar contraseña:");
		GridBagConstraints gbc_lblConfirmarContrasenia = new GridBagConstraints();
		gbc_lblConfirmarContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasenia.gridx = 3;
		gbc_lblConfirmarContrasenia.gridy = 8;
		add(lblConfirmarContrasenia, gbc_lblConfirmarContrasenia);
		
		txtPasswordConfirmada = new JTextField();
		GridBagConstraints gbc_txtPasswordConfirmada = new GridBagConstraints();
		gbc_txtPasswordConfirmada.gridwidth = 5;
		gbc_txtPasswordConfirmada.insets = new Insets(0, 0, 5, 5);
		gbc_txtPasswordConfirmada.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasswordConfirmada.gridx = 4;
		gbc_txtPasswordConfirmada.gridy = 8;
		add(txtPasswordConfirmada, gbc_txtPasswordConfirmada);
		txtPasswordConfirmada.setColumns(10);
		
		lblWrongPasswordConfirmation = new JLabel("");
		GridBagConstraints gbc_lblWrongPasswordConfirmation = new GridBagConstraints();
		gbc_lblWrongPasswordConfirmation.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongPasswordConfirmation.gridx = 9;
		gbc_lblWrongPasswordConfirmation.gridy = 8;
		add(lblWrongPasswordConfirmation, gbc_lblWrongPasswordConfirmation);
		
		btnAplicarCambios = new JButton("Aplicar cambios");
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		gbc_btnAplicarCambios.gridwidth = 2;
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 5, 5);
		gbc_btnAplicarCambios.gridx = 8;
		gbc_btnAplicarCambios.gridy = 10;
		add(btnAplicarCambios, gbc_btnAplicarCambios);
	}

}
