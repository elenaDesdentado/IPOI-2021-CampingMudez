package persistencia;

import java.util.ArrayList;

import dominio.Actividad;

public class Actividades {

	private ArrayList<Actividad> actividades = new ArrayList<Actividad>();

	public Actividades(ArrayList<Actividad> arrayList) {
		setActividades(arrayList);
	}

	public ArrayList<Actividad> getActividades() {
		return this.actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void addActividad(Actividad nuevaActividad) {
		this.actividades.add(nuevaActividad);
	}
	
	public void eliminarActividad(Actividad antiguaActividad) {
		this.actividades.remove(antiguaActividad);
	}
	
}
