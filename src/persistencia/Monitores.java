package persistencia;

import java.util.ArrayList;

import dominio.Monitor;

public class Monitores {

	private ArrayList<Monitor> monitores = new ArrayList<Monitor>();

	public Monitores(ArrayList<Monitor> monitores) {
		setMonitores(monitores);
	}

	public ArrayList<Monitor> getMonitores() {
		return this.monitores;
	}

	public void setMonitores(ArrayList<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	public void addMonitor(Monitor nuevoMonitor) {
		this.monitores.add(nuevoMonitor);
	}
	
	public void eliminarMonitor(Monitor antiguoMonitor) {
		this.monitores.remove(antiguoMonitor);
	}
	
}
