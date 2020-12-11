package dominio;

import java.util.ArrayList;

public class Actividad {
	private String nombre;
	private String monitor;
	private int cupo;
	private String destinatario;
	private String area;
	private String descripcion;
	private String materiales;
	private String horario;
	private Double precio;
	private String fotoActividad;
	
	public Actividad(String nombre, String monitor, int cupo, String destinatario, String area, String descripcion,
			String materiales, String horario, Double precio, String fotoActividad) {
		this.nombre = nombre;
		this.monitor = monitor;
		this.cupo = cupo;
		this.destinatario = destinatario;
		this.area = area;
		this.descripcion = descripcion;
		this.materiales = materiales;
		this.horario = horario;
		this.precio = precio;
		this.fotoActividad = fotoActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFotoActividad() {
		return fotoActividad;
	}

	public void setFotoActividad(String fotoActividad) {
		this.fotoActividad = fotoActividad;
	}

}
