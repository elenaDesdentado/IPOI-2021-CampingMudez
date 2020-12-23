package persistencia;

import java.util.ArrayList;

import dominio.Usuario;


public class Usuarios {
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuarios(ArrayList<Usuario> usuarios) {
		setUsuarios(usuarios);
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario (ArrayList<Usuario> usuarios, String nombreUsuario) {
		for (int i=0; i< usuarios.size(); i++) {
			if (usuarios.get(i).getNombreUsuario().equals(nombreUsuario))
				return usuarios.get(i);
		}
		return null;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUsuario(Usuario nuevoUsuario) {
		this.usuarios.add(nuevoUsuario);
	}
	
	public void eliminarUsuario(Usuario antiguoUsuario) {
		this.usuarios.remove(antiguoUsuario);
	}
}
