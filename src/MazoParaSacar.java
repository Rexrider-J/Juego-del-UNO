import java.util.ArrayList;

import Cartas.Carta;
import Cartas.CartaCambioDeColorMasCuatro;
import Cartas.CartaCambioDeColorNormal;
import Cartas.CartaDoble;
import Cartas.CartaReversa;
import Cartas.CartaSaltear;
import Cartas.CartaConNumeros;
import Cartas.Color;

public class MazoParaSacar extends Mazo{
	
	public MazoParaSacar () {
		generarCartas();
		mezclarCartas();
	}
	
	public void generarCartas() {
		for (Color colour : Color.values()) {
			for (int i = 0; i < 10; i++) {
				super.addCarta(new CartaConNumeros (colour,i));
				super.addCarta(new CartaConNumeros (colour,i));
			}
			for (int i = 0; i < 2; i++) {
				super.addCarta(new CartaSaltear (colour));
			}
			for (int i = 0; i < 2; i++) {
				super.addCarta(new CartaReversa(colour));
			}
			for (int i = 0; i < 2; i++) {
				super.addCarta(new CartaDoble(colour));
			}
			super.addCarta(new CartaCambioDeColorMasCuatro());
			super.addCarta(new CartaCambioDeColorNormal());
		}
	}
	
	public void mezclarCartas() {
		int a, b;
        Carta aux;
        for (int i = 0; i < 300; i++) {
            a = Funciones.numRandomEntre(0, super.cantCartas()-1);
            b = Funciones.numRandomEntre(0, super.cantCartas()-1);
            aux = super.getCarta(a);
            super.setCarta(a, super.getCarta(b));
            super.setCarta(b, aux);
        }
	}
	
	public ArrayList<Carta> sacarMuchasCartas(int cant) {
		ArrayList<Carta> c = new ArrayList<>();
		for (int i = 0; i < cant; i++) {
			c.add(super.removeCarta(0));
		}
		return c;
	}
	
	public Carta sacarUnaCarta() {
		return super.removeCarta(0);
	}

}
