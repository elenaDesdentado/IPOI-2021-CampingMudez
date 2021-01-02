package dominio;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ruta {
	
	private String nombre;
	private String dia;
	private String horario;
	private String encuentro;
	private String dificultad;
	private String descripcion;
	private ArrayList<Monitor> monitores;
	private int cupo;
	private ImageIcon foto;
	
	public Ruta() {
		
	}

	public Ruta(String nombre, String dia, String horario, String encuentro, String dificultad, String descripcion,
			ArrayList<Monitor> monitores, int cupo, ImageIcon foto) {
		this.nombre = nombre;
		this.dia = dia;
		this.horario = horario;
		this.encuentro = encuentro;
		this.dificultad = dificultad;
		this.descripcion = descripcion;
		this.monitores = monitores;
		this.cupo = cupo;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(ArrayList<Monitor> monitores) {
		this.monitores = monitores;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}
	
}
