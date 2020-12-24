package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;

public class Alojamiento {

	private String area;
	private int valoracion;
	private String nombre;
	private String descripcion;
	private double tamanio;
	private double precio;
	private String disponibilidad;
	private ImageIcon foto;
	ArrayList<Calendar> fechasReservadas;	//Consturctor o no?
	
	public Alojamiento(String area, int valoracion, String nombre, String descripcion, double tamanio, double precio,
			String disponibilidad, ImageIcon foto) {
		this.area = area;
		this.valoracion = valoracion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tamanio = tamanio;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.foto = foto;
	}
	
	public Alojamiento() {
		
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getTamanio() {
		return tamanio;
	}

	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public ArrayList<Calendar> getFechasReservadas() {
		return fechasReservadas;
	}

	public void setFechasReservadas(ArrayList<Calendar> fechasReservadas) {
		this.fechasReservadas = fechasReservadas;
	}

}
