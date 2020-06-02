import java.util.ArrayList;

import Cartas.Carta;

public abstract class Player{
	private String name;
	private MazoDeJugador mazo;
	
	public Player(String name){
		this.name = name;
		mazo = new MazoDeJugador();
	}
	
	public Carta getCarta(int i) {
		return this.mazo.getCarta(i);
	}
	
	public void agregarCartasIniciales(ArrayList<Carta> c) {
		this.mazo.agregarVariasCartas(c);
	}
	
	public int cantCartas () {
		return this.mazo.cantCartas();
	}
	
	public Carta tirarCarta(int numCarta) {
		return mazo.removeCarta(numCarta);
	}
	public void agregarVariasCartas(ArrayList<Carta> c) {
		this.mazo.agregarVariasCartas(c);
	}
	public void agregarUnaCarta(Carta c) {
		this.mazo.addCarta(c);
	}
	public abstract int escogerCarta(Carta ultimaCarta);
	public abstract boolean puedeTirar(Carta ultimaCarta);
	public abstract void showCartas();
	public abstract boolean uno();
	@Override
	public String toString() {
		return "[Jugador: " + name + "]";
	}
}
