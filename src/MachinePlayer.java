import Cartas.Carta;
import Cartas.CartaCambioDeColorMasCuatro;
import Cartas.CartaCambioDeColorNormal;
import Cartas.CartaConNumeros;
import Cartas.CartaDoble;
import Cartas.CartaReversa;
import Cartas.CartaSaltear;

public class MachinePlayer extends Player{
	
	public MachinePlayer(String name) {
		super(name);
	}

	@Override
	public int escogerCarta(Carta ultimaCarta) {
		boolean cartaElegida = false;
		int RESTO_EL_ULTIMO_CONT = -1;
		int cont = 0;
		Carta c;
		while(cont < super.cantCartas() && cartaElegida != true) {
			c = super.getCarta(cont);
			cartaElegida = inspeccionarMazo(ultimaCarta,c);
			cont ++;
		}
		if(cartaElegida == true) {
			return (cont + RESTO_EL_ULTIMO_CONT);
		}else {
			return -1;
		}
	}
	
	private boolean inspeccionarMazo(Carta ultimaCarta, Carta c ) {
		switch(ultimaCarta.getTipoCarta()) {
			case NUMERICA:
					switch(c.getTipoCarta()) {
						case NUMERICA:
							if(((CartaConNumeros) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
								return true;
							}
							else if(((CartaConNumeros) c).getNumero() == ((CartaConNumeros)ultimaCarta).getNumero()){
								return true;
							}
							else {
								return false;
							}
						case DOBLE:
							if(((CartaDoble) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case REVERSA:
							if(((CartaReversa) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case SALTEAR:
							if(((CartaSaltear) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case CAMBIOCOLOR:
							return true;
						case CAMBIOCOLORMASCUATRO:
							return true;
				}
				break;	
			case REVERSA:
					switch(c.getTipoCarta()) {
					case NUMERICA:
						if(((CartaConNumeros) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case DOBLE:
						if(((CartaDoble) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case REVERSA:
							return true;
					case SALTEAR:
						if(((CartaSaltear) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case CAMBIOCOLOR:
						return true;
					case CAMBIOCOLORMASCUATRO:
						return true;
				}
				break;
			case SALTEAR:
					switch(c.getTipoCarta()) {
						case NUMERICA:
							if(((CartaConNumeros) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case DOBLE:
							if(((CartaDoble) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case REVERSA:
							if(((CartaReversa) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
								return true;
							}
							else {
								return false;
							}
						case SALTEAR:
								return true;
						case CAMBIOCOLOR:
								return true;
						case CAMBIOCOLORMASCUATRO:
							return true;
				}
				break;
			case DOBLE:
					switch(c.getTipoCarta()) {
					case NUMERICA:
						if(((CartaConNumeros) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case DOBLE:																		
							return true;
					case REVERSA:
						if(((CartaReversa) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case SALTEAR:
						if(((CartaSaltear) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
							return true;
						}
						else {
							return false;
						}
					case CAMBIOCOLOR:
						return true;
					case CAMBIOCOLORMASCUATRO:
						return true;
				}
				break;
			case CAMBIOCOLOR:
					switch(c.getTipoCarta()) {
					case NUMERICA:
						if(((CartaConNumeros) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case DOBLE:
						if(((CartaDoble) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case REVERSA:
						if(((CartaReversa) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case SALTEAR:
						if(((CartaSaltear) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case CAMBIOCOLOR:
						return true;
					case CAMBIOCOLORMASCUATRO:
						return true;
				}
				break;
			case CAMBIOCOLORMASCUATRO:
				switch(c.getTipoCarta()) {
					case NUMERICA:
						if(((CartaConNumeros) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case DOBLE:
						if(((CartaDoble) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case REVERSA:
						if(((CartaReversa) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case SALTEAR:
						if(((CartaSaltear) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
							return true;
						}
						else {
							return false;
						}
					case CAMBIOCOLOR:
						return true;
					case CAMBIOCOLORMASCUATRO:
						return true;
				}
				break;
			}
		return false;
		}
	
	public void showCartas() {
		for (int j = 0; j < super.cantCartas(); j++) {
			System.out.println("[ " + (j+1) + " ]" + super.getCarta(j).toString());
		}
	}

	@Override
	public boolean puedeTirar(Carta ultimaCarta) {
		if(this.escogerCarta(ultimaCarta) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean uno() {
		if(super.cantCartas() == 1) {
			return true;
		}else {
			return false;
		}
	}

}
