package dominio;

import javax.swing.ImageIcon;

public class Parcela extends Alojamiento {

	private String sombra;
	private String suelo;
	private String banio;
	private String restaurante;
	private boolean golf, corriente, parking, wifi, acampada, mascotas;

	public Parcela(String area, int valoracion, String nombre, String descripcion, double tamanio, double precio,
			String disponibilidad, String sombra, String suelo, String banio, String restaurante, boolean golf,
			boolean corriente, boolean parking, boolean wifi, boolean acampada, boolean mascotas, ImageIcon foto) {
		super(area, valoracion, nombre, descripcion, tamanio, precio, disponibilidad, foto);
		this.sombra = sombra;
		this.suelo = suelo;
		this.banio = banio;
		this.restaurante = restaurante;
		this.golf = golf;
		this.corriente = corriente;
		this.parking = parking;
		this.wifi = wifi;
		this.acampada = acampada;
		this.mascotas = mascotas;
	}
	
	public Parcela() {
		
	}

	public String getSombra() {
		return sombra;
	}

	public void setSombra(String sombra) {
		this.sombra = sombra;
	}

	public String getSuelo() {
		return suelo;
	}

	public void setSuelo(String suelo) {
		this.suelo = suelo;
	}

	public String getBanio() {
		return banio;
	}

	public void setBanio(String banio) {
		this.banio = banio;
	}

	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public boolean isGolf() {
		return golf;
	}

	public void setGolf(boolean golf) {
		this.golf = golf;
	}

	public boolean isCorriente() {
		return corriente;
	}

	public void setCorriente(boolean corriente) {
		this.corriente = corriente;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isAcampada() {
		return acampada;
	}

	public void setAcampada(boolean acampada) {
		this.acampada = acampada;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}

}
