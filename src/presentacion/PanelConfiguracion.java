package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dominio.Usuario;
import persistencia.Usuarios;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PanelConfiguracion extends JPanel {
	private JLabel lblAvatar;
	private JButton btnCambiarAvatar;
	private JLabel lblNuevoNombre;
	private JLabel lblCambiarContrasenia;
	private JTextField txtNombreUsuario;
	private JPasswordField pwfPassword;
	private JButton btnAplicarCambios;
	private Color colorBoton = new Color(159, 177, 57);
	private JLabel lblConfirmarContrasenia;
	private JPasswordField pwfPasswordConfirmada;
	private JLabel lblWrongPassword;
	private JLabel lblWrongNombreUsuario;
	private JLabel lblWrongPasswordConfirmation;

	private Usuario usuarioPrincipal;

	private File file = new File("./src/persistencia/credenciales-usuario.txt");
	private JLabel lblMensajeError;
	
	private JFrame framePadre;
	private Usuarios usuarios;

	public PanelConfiguracion(JFrame framePadre, Usuarios usuarios, Usuario usuario) {
		this.framePadre = framePadre;
		this.usuarios = usuarios;
		this.usuarioPrincipal = usuario;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 72, 0, 0, 64, 79, 61, 112, 112, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 68, 0, 0, 10, 0, 47, 15, 15, 20, 0, 15, 0, 15, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblAvatar = new JLabel();
		lblAvatar.setIcon(usuarioPrincipal.getAvatar());
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.gridwidth = 3;
		gbc_lblAvatar.gridheight = 2;
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridx = 1;
		gbc_lblAvatar.gridy = 1;
		add(lblAvatar, gbc_lblAvatar);

		btnCambiarAvatar = new JButton("Cambiar avatar...");
		btnCambiarAvatar.addActionListener(new BtnCambiarAvatarActionListener());
		GridBagConstraints gbc_btnCambiarAvatar = new GridBagConstraints();
		gbc_btnCambiarAvatar.gridwidth = 3;
		gbc_btnCambiarAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarAvatar.gridx = 1;
		gbc_btnCambiarAvatar.gridy = 4;
		add(btnCambiarAvatar, gbc_btnCambiarAvatar);

		lblNuevoNombre = new JLabel("Nuevo nombre de usuario:");
		GridBagConstraints gbc_lblNuevoNombre = new GridBagConstraints();
		gbc_lblNuevoNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNuevoNombre.gridwidth = 3;
		gbc_lblNuevoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoNombre.gridx = 1;
		gbc_lblNuevoNombre.gridy = 6;
		add(lblNuevoNombre, gbc_lblNuevoNombre);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText(usuarioPrincipal.getNombreUsuario());
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.gridwidth = 3;
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreUsuario.gridx = 4;
		gbc_txtNombreUsuario.gridy = 6;
		add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblWrongNombreUsuario = new JLabel("");
		GridBagConstraints gbc_lblWrongNombreUsuario = new GridBagConstraints();
		gbc_lblWrongNombreUsuario.gridwidth = 3;
		gbc_lblWrongNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongNombreUsuario.gridx = 7;
		gbc_lblWrongNombreUsuario.gridy = 6;
		add(lblWrongNombreUsuario, gbc_lblWrongNombreUsuario);

		lblCambiarContrasenia = new JLabel("Nueva contraseña:");
		GridBagConstraints gbc_lblCambiarContrasenia = new GridBagConstraints();
		gbc_lblCambiarContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblCambiarContrasenia.gridwidth = 3;
		gbc_lblCambiarContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambiarContrasenia.gridx = 1;
		gbc_lblCambiarContrasenia.gridy = 7;
		add(lblCambiarContrasenia, gbc_lblCambiarContrasenia);

		pwfPassword = new JPasswordField();
		TextPrompt passwordPrompt = new TextPrompt("Nueva contraseña", pwfPassword);
		pwfPassword.setEchoChar('*');
		GridBagConstraints gbc_pwfPassword = new GridBagConstraints();
		gbc_pwfPassword.gridwidth = 5;
		gbc_pwfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwfPassword.gridx = 4;
		gbc_pwfPassword.gridy = 7;
		add(pwfPassword, gbc_pwfPassword);
		pwfPassword.setColumns(10);

		lblWrongPassword = new JLabel("");
		GridBagConstraints gbc_lblWrongPassword = new GridBagConstraints();
		gbc_lblWrongPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongPassword.gridx = 9;
		gbc_lblWrongPassword.gridy = 7;
		add(lblWrongPassword, gbc_lblWrongPassword);

		lblConfirmarContrasenia = new JLabel("Confirmar nueva contraseña:");
		GridBagConstraints gbc_lblConfirmarContrasenia = new GridBagConstraints();
		gbc_lblConfirmarContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasenia.gridx = 3;
		gbc_lblConfirmarContrasenia.gridy = 9;
		add(lblConfirmarContrasenia, gbc_lblConfirmarContrasenia);

		pwfPasswordConfirmada = new JPasswordField();
		pwfPasswordConfirmada.setEchoChar('*');
		TextPrompt passwordConfPrompt = new TextPrompt("Introduzca la contraseña de nuevo", pwfPasswordConfirmada);
		GridBagConstraints gbc_pwfPasswordConfirmada = new GridBagConstraints();
		gbc_pwfPasswordConfirmada.gridwidth = 5;
		gbc_pwfPasswordConfirmada.insets = new Insets(0, 0, 5, 5);
		gbc_pwfPasswordConfirmada.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwfPasswordConfirmada.gridx = 4;
		gbc_pwfPasswordConfirmada.gridy = 9;
		add(pwfPasswordConfirmada, gbc_pwfPasswordConfirmada);
		pwfPasswordConfirmada.setColumns(10);

		lblWrongPasswordConfirmation = new JLabel("");
		GridBagConstraints gbc_lblWrongPasswordConfirmation = new GridBagConstraints();
		gbc_lblWrongPasswordConfirmation.insets = new Insets(0, 0, 5, 5);
		gbc_lblWrongPasswordConfirmation.gridx = 9;
		gbc_lblWrongPasswordConfirmation.gridy = 9;
		add(lblWrongPasswordConfirmation, gbc_lblWrongPasswordConfirmation);

		btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.addActionListener(new BtnAplicarCambiosActionListener());

		lblMensajeError = new JLabel("");
		lblMensajeError.setForeground(Color.RED);
		GridBagConstraints gbc_lblMensajeError = new GridBagConstraints();
		gbc_lblMensajeError.anchor = GridBagConstraints.WEST;
		gbc_lblMensajeError.gridwidth = 6;
		gbc_lblMensajeError.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensajeError.gridx = 4;
		gbc_lblMensajeError.gridy = 11;
		add(lblMensajeError, gbc_lblMensajeError);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		gbc_btnAplicarCambios.gridwidth = 2;
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 5, 5);
		gbc_btnAplicarCambios.gridx = 8;
		gbc_btnAplicarCambios.gridy = 13;
		add(btnAplicarCambios, gbc_btnAplicarCambios);
	}

	private class BtnCambiarAvatarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(null);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				Image imagenOriginal;
				try {
					imagenOriginal = ImageIO.read(file);
					Image imagenEscalada = imagenOriginal.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
					ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
					lblAvatar.setIcon(iconoLabel);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private class BtnAplicarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!(pwfPassword.getPassword().length == 0)) {
				if (!(txtNombreUsuario.getText().equals(""))) {
					String[] options = { "Sí", "No" };
					int seleccion = JOptionPane.showOptionDialog(null, "¿Está seguro de realizar" + " los cambios?",
							"Cambios cuenta de usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							options, options[0]);
					if (seleccion == 0) {
						if (pwfPassword.getPassword().toString()
								.equals(pwfPasswordConfirmada.getPassword().toString())) {
							usuarios.eliminarUsuario(usuarioPrincipal);
							usuarioPrincipal.setAvatar((ImageIcon) lblAvatar.getIcon());
							usuarioPrincipal.setNombreUsuario(txtNombreUsuario.getText());
							usuarioPrincipal.setPassword(pwfPassword.getPassword().toString());
							usuarios.addUsuario(usuarioPrincipal);
						}

						try {
							if (!file.exists())
								file.createNewFile(); // if the file !exist create a new one

							BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
							bw.write(txtNombreUsuario.getText()); // write the name
							bw.newLine(); // leave a new Line
							bw.write(pwfPassword.getPassword()); // write the password
							bw.close(); // close the BufferdWriter

						} catch (IOException e) {
							e.printStackTrace();
						}
						
						framePadre.repaint();
						framePadre.revalidate();
						
					} else if (seleccion == 1) {
						pwfPassword.setText("");
						pwfPasswordConfirmada.setText("");
						txtNombreUsuario.setText(usuarioPrincipal.getNombreUsuario());
						lblAvatar.setIcon(usuarioPrincipal.getAvatar());
					}
				} else {
					lblMensajeError.setText(
							"La contraseña o el nombre de usuario no pueden estar vacíos. Inténtelo de nuevo.");
				}
			} else {
				lblMensajeError
						.setText("La contraseña no puede estar vacía. Inténtelo de nuevo.");
			}
		}
	}
}
