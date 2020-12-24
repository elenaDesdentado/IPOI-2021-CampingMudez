package dominio;

import javax.swing.ImageIcon;

public class Bungalow extends Alojamiento {

	private boolean jardin;
	private int capacidadMinima;
	private boolean wifi, piscina, barbacoa;
	private boolean golf, carbon, garaje, cama, limpieza, lavavajillas;

	public Bungalow(String area, int valoracion, String nombre, String descripcion, double tamanio, double precio,
			String disponibilidad, boolean jardin, int capacidadMinima, boolean wifi, boolean piscina, boolean barbacoa,
			boolean golf, boolean carbon, boolean garaje, boolean cama, boolean limpieza, boolean lavavajillas, ImageIcon foto) {
		super(area, valoracion, nombre, descripcion, tamanio, precio, disponibilidad, foto);
		this.jardin = jardin;
		this.capacidadMinima = capacidadMinima;
		this.wifi = wifi;
		this.piscina = piscina;
		this.barbacoa = barbacoa;
		this.golf = golf;
		this.carbon = carbon;
		this.garaje = garaje;
		this.cama = cama;
		this.limpieza = limpieza;
		this.lavavajillas = lavavajillas;
	}

	public Bungalow() {

	}

	public boolean isJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public int getCapacidadMinima() {
		return capacidadMinima;
	}

	public void setCapacidadMinima(int capacidadMinima) {
		this.capacidadMinima = capacidadMinima;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isBarbacoa() {
		return barbacoa;
	}

	public void setBarbacoa(boolean barbacoa) {
		this.barbacoa = barbacoa;
	}

	public boolean isGolf() {
		return golf;
	}

	public void setGolf(boolean golf) {
		this.golf = golf;
	}

	public boolean isCarbon() {
		return carbon;
	}

	public void setCarbon(boolean carbon) {
		this.carbon = carbon;
	}

	public boolean isGaraje() {
		return garaje;
	}

	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}

	public boolean isCama() {
		return cama;
	}

	public void setCama(boolean cama) {
		this.cama = cama;
	}

	public boolean isLimpieza() {
		return limpieza;
	}

	public void setLimpieza(boolean limpieza) {
		this.limpieza = limpieza;
	}

	public boolean isLavavajillas() {
		return lavavajillas;
	}

	public void setLavavajillas(boolean lavavajillas) {
		this.lavavajillas = lavavajillas;
	}

}
