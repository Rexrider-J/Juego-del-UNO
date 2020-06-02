import java.util.ArrayList;

import Cartas.Carta;

public abstract class Mazo {
	private ArrayList<Carta> c;
	
	public Mazo() {
		c = new ArrayList<>();
	}
	
	public void addCarta(Carta carta) {
		this.c.add(carta);
	}
	
	public void agregarVariasCartas(ArrayList<Carta> cartas) {
		c.addAll(cartas);
	}
	
	public Carta removeCarta(int carta) {
		return this.c.remove(carta);
	}
	
	public int cantCartas () {
		return this.c.size();
	}
	
	public Carta getCarta(int carta) {
		return c.get(carta);
	}
	
	public void setCarta(int n, Carta element) {
		this.c.set(n, element);
	}
}
