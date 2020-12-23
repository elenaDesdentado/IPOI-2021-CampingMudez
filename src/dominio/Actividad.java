package dominio;

import javax.swing.ImageIcon;

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
	private ImageIcon fotoActividad;

	public Actividad(String nombre, String monitor, int cupo, String destinatario, String area, String descripcion,
			String materiales, String horario, Double precio, ImageIcon fotoActividad) {
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

	public Actividad() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre.equals(""))
			throw new Exception();
		this.nombre = nombre;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) throws Exception {
		if(monitor.equals(""))
			throw new Exception();
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

	public void setDescripcion(String descripcion) throws Exception {
		if(descripcion.equals(""))
			throw new Exception();
		this.descripcion = descripcion;
	}

	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) throws Exception {
		if(materiales.equals(""))
			throw new Exception();
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

	public void setPrecio(Double precio) throws Exception {
		if(precio.toString().equals(""))
			throw new Exception();
		this.precio = precio;
	}

	public ImageIcon getFotoActividad() {
		return fotoActividad;
	}

	public void setFotoActividad(ImageIcon fotoActividad) {
		this.fotoActividad = fotoActividad;
	}

}
