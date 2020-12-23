package dominio;

import javax.swing.ImageIcon;

public class Usuario {
	
	private ImageIcon avatar;
	private String nombreUsuario;
	private String password;

	public Usuario(ImageIcon avatar, String nombreUsuario, String password) {
		this.avatar = avatar;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	public ImageIcon getAvatar() {
		return avatar;
	}
	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
