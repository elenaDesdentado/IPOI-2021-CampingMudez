package persistencia;

import java.util.ArrayList;

import dominio.Alojamiento;

public class Alojamientos {

	private ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
	
	public Alojamientos(ArrayList<Alojamiento> alojamientos) {
		setAlojamientos(alojamientos);
	}

	public ArrayList<Alojamiento> getAlojamientos() {
		return this.alojamientos;
	}

	public void setAlojamientos(ArrayList<Alojamiento> Alojamientos) {
		this.alojamientos = Alojamientos;
	}
	
	public void addAlojamiento(Alojamiento nuevoAlojamiento) {
		this.alojamientos.add(nuevoAlojamiento);
	}
	
	public void eliminarAlojamiento(Alojamiento antiguoAlojamiento) {
		this.alojamientos.remove(antiguoAlojamiento);
	}
}
