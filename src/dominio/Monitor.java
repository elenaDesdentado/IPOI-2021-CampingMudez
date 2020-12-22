package dominio;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Monitor {
	private String nombre;
	private String apellidos;
	private String dni;
	private String movil;
	private String fijo;
	private String correo;
	private String estudios;
	private String disponibilidad;
	private String horario;
	private Double sueldo;
	private int edad;
	ArrayList<String> idiomas;
	private ImageIcon avatar;

	public Monitor(String nombre, String apellidos, String dni, String movil, String fijo, String correo,
			String estudios, String disponibilidad, String horario, Double sueldo, int edad, ArrayList<String> idiomas, ImageIcon avatar) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.movil = movil;
		this.fijo = fijo;
		this.correo = correo;
		this.estudios = estudios;
		this.disponibilidad = disponibilidad;
		this.horario = horario;
		this.sueldo = sueldo;
		this.edad = edad;
		this.idiomas = idiomas;
		this.avatar = avatar;
	}
	
	public Monitor() {
		
	}

	public ImageIcon getAvatar() {
		return avatar;
	}

	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre.equals("")) {
			System.out.println("Sisi nombre es : "+ nombre);
			throw new Exception();
		}
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) throws Exception {
		if(apellidos.equals(""))
			throw new Exception();
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws Exception {
		if(dni.equals("XXXXXXX X"))
			throw new Exception();
		this.dni = dni;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) throws Exception {
		if(movil.equals("*** ** ** **"))
			throw new Exception();
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) throws Exception {
		if(correo.equals(""))
			throw new Exception();
		this.correo = correo;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) throws Exception {
		if(sueldo.toString().equals(""))
			throw new Exception();
		this.sueldo = sueldo;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

}
