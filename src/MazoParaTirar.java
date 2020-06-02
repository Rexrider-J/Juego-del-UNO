import Cartas.Carta;

public class MazoParaTirar extends Mazo{
	public static int ultimaCarta = -1;
	
	public MazoParaTirar() {
		
	}
	
	public void dejarCarta(Carta c) {
		super.addCarta(c);
		ultimaCarta += 1;
	}
	
	public Carta ultimaCarta() {
		return super.getCarta(ultimaCarta);
	}
	
}
