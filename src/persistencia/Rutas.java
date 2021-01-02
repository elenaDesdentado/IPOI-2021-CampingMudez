package persistencia;

import java.util.ArrayList;

import dominio.Ruta;

public class Rutas {

private ArrayList<Ruta> Rutas = new ArrayList<Ruta>();
	
	public Rutas(ArrayList<Ruta> Rutas) {
		setRutas(Rutas);
	}

	public ArrayList<Ruta> getRutas() {
		return this.Rutas;
	}

	public void setRutas(ArrayList<Ruta> Rutas) {
		this.Rutas = Rutas;
	}
	
	public void addRuta(Ruta nuevaRuta) {
		this.Rutas.add(nuevaRuta);
	}
	
	public void eliminarRuta(Ruta antiguaRuta) {
		this.Rutas.remove(antiguaRuta);
	}
	
}
