import java.util.ArrayList;

import Cartas.Carta;
import Cartas.CartaCambioDeColorMasCuatro;
import Cartas.CartaCambioDeColorNormal;
import Cartas.CartaConNumeros;
import Cartas.CartaDoble;
import Cartas.CartaReversa;
import Cartas.CartaSaltear;
import Cartas.Color;
import Cartas.TipoDeCarta;

	public class AccionDeCartas {
		
		private MazoParaSacar mazoParaSacar;
		private MazoParaTirar mazoParaTirar;
		
		public AccionDeCartas(){
			mazoParaSacar= new MazoParaSacar();
			mazoParaTirar= new MazoParaTirar();
		}
		public void repartirCartasIniciales(ArrayList<Player> players) {
			final int CANT_CARTAS_DE_INICIO = 7;
			ArrayList<Carta> c = new ArrayList<>();
			c = this.mazoParaSacar.sacarMuchasCartas(CANT_CARTAS_DE_INICIO);
			for (int i = 0; i < players.size(); i++) {
				players.get(i).agregarVariasCartas(c);
				c = this.mazoParaSacar.sacarMuchasCartas(CANT_CARTAS_DE_INICIO);
			}
		}
		public void accionDeUltimaCartaAntesDeJugar(Player j) {
			Carta ultimaCarta = this.mazoParaTirar.ultimaCarta(); 
			int CANT_CARTAS_DOBLE = 2;
			int CANT_CARTAS_MASCUATRO = 4;
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.DOBLE){
				System.out.println("¡La ultima carta fue una carta doble!" + j.toString() + " Te llevas 2 cartas.");
				j.agregarVariasCartas(this.mazoParaSacar.sacarMuchasCartas(CANT_CARTAS_DOBLE));
			}
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.CAMBIOCOLORMASCUATRO){	
				System.out.println("¡La ultima carta fue una carta con un +4!" + j.toString() + " Te llevas 4 cartas.");
				j.agregarVariasCartas(this.mazoParaSacar.sacarMuchasCartas( CANT_CARTAS_MASCUATRO));
			}
		}
		
		public void accionDeUltimaCartaDespuesDeJugar(Player j, Turnos turno) {                         //ACA PUEDE SALTAR UN PROBLEMA  
			Carta ultimaCarta = this.mazoParaTirar.ultimaCarta(); 
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.REVERSA){
				turno.Reversa();
			}
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.SALTEAR){	
				turno.Saltear();
			}
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.CAMBIOCOLOR) {
				System.out.println("Se cambio el color de la ronda a " + ((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar());
			}
			if(ultimaCarta.getTipoCarta() == TipoDeCarta.CAMBIOCOLORMASCUATRO) {
				System.out.println("Se cambio el color de la ronda a " + ((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar());
			}
		}
		
		public void comprobarCarta(Player j) {
			Carta ultimaCarta = this.mazoParaTirar.ultimaCarta(); 
			boolean esValida = false;
			Carta c = null;  																	
			switch(ultimaCarta.getTipoCarta()) {
					case NUMERICA:
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
										esValida = true;
									}
									else if(((CartaConNumeros) c).getNumero() == ((CartaConNumeros)ultimaCarta).getNumero()){
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:
									if(((CartaDoble) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case REVERSA:
									if(((CartaReversa) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case SALTEAR:
									if(((CartaSaltear) c).getColor().equals(((CartaConNumeros)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
					case REVERSA:
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:
									if(((CartaDoble) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case REVERSA:
										esValida = true;
										break;
								case SALTEAR:
									if(((CartaSaltear) c).getColor().equals(((CartaReversa)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
					case SALTEAR:
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:
									if(((CartaDoble) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case REVERSA:
									if(((CartaReversa) c).getColor().equals(((CartaSaltear)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case SALTEAR:
										esValida = true;
										break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
					case DOBLE:			
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:																		
										esValida = true;
									break;
								case REVERSA:
									if(((CartaReversa) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case SALTEAR:
									if(((CartaSaltear) c).getColor().equals(((CartaDoble)ultimaCarta).getColor())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);	
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
					case CAMBIOCOLOR:
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:
									if(((CartaDoble) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case REVERSA:
									if(((CartaReversa) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case SALTEAR:
									if(((CartaSaltear) c).getColor().equals(((CartaCambioDeColorNormal)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
					case CAMBIOCOLORMASCUATRO:
							c = escogerUnaCarta(j);
							switch(c.getTipoCarta()) {
								case NUMERICA:
									if(((CartaConNumeros) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case DOBLE:
									if(((CartaDoble) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case REVERSA:
									if(((CartaReversa) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case SALTEAR:
									if(((CartaSaltear) c).getColor().equals(((CartaCambioDeColorMasCuatro)ultimaCarta).obtenerColorACambiar())) {
										esValida = true;
									}
									else {
										esValida = false;
									}
									break;
								case CAMBIOCOLOR:
									Color cambio = this.cambioDeColor(j);
									((CartaCambioDeColorNormal)c).colorACambiar(cambio);
									esValida = true;
									break;
								case CAMBIOCOLORMASCUATRO:
									Color cambio2 = this.cambioDeColor(j);
									((CartaCambioDeColorMasCuatro)c).colorACambiar(cambio2);
									esValida = true;
									break;
							}
						break;
			}
			if(esValida == true) {
				this.mazoParaTirar.dejarCarta(c);
				if(j instanceof MachinePlayer) {
					System.out.println(j.toString() + " jugó la carta: " + c.toString());
				}
			}else {
				System.out.println(j.toString() + " jugó la carta: " + c.toString());
				System.out.println("La carta es incorrecta, se te agregan 2 cartas más al mazo");
				j.agregarUnaCarta(c);
				j.agregarVariasCartas(this.mazoParaSacar.sacarMuchasCartas(2));
			}
		}
		
	private Carta escogerUnaCarta(Player j) {
		int opc = j.escogerCarta(ultimaCarta());
		if(j instanceof PersonPlayer){
			opc -= 1;
		}
		Carta c = j.tirarCarta(opc);
		return c;
	}
	
	public boolean puedeTirar(Player j) {
		if(j.puedeTirar(ultimaCarta()) == false) {
			j.agregarUnaCarta(this.mazoParaSacar.sacarUnaCarta());
			return false;
		}else {
			return true;
		}
	}

	private Carta ultimaCarta() {
		return this.mazoParaTirar.ultimaCarta();
	}
		
	public void primeraCarta() {
		Carta c =this.mazoParaSacar.sacarUnaCarta();
		while(!(c instanceof CartaConNumeros)) {
			this.mazoParaSacar.addCarta(c);
			c = this.mazoParaSacar.sacarUnaCarta();
		}
		this.mazoParaTirar.dejarCarta(c);
		System.out.println("La primera carta --->" + c.toString());
	}
	
	public void hayCartas() {
		if(this.mazoParaSacar.cantCartas() == 0) {
			for (int i = 0; i < this.mazoParaTirar.cantCartas()-1; i++) {
				this.mazoParaSacar.addCarta(this.mazoParaTirar.removeCarta(i));
			}
			this.mazoParaSacar.mezclarCartas();
		}
	}
	
	public void comprobarGanador(Player jugador,int opc) {
		int CANT_CARTAS_X_ERROR = 2;
		if(opc == 2) {
			System.out.println("¡Un jugador descubrio tu error! Te llevas 2 cartas.");
			jugador.agregarVariasCartas(this.mazoParaSacar.sacarMuchasCartas(CANT_CARTAS_X_ERROR));
		}
	}
	
	private Color cambioDeColor(Player j) {
		int opc;
		if(j instanceof PersonPlayer) {
			System.out.println("Elige a que color cambiar la ronda: \n[1]" + Color.AMARILLO + "\n[2]" + Color.AZUL + "\n[3]" + Color.ROJO + "\n[4]" + Color.VERDE + "\n-->");
			do{
				opc = Funciones.entrada.nextInt();
			}while(opc < 0 && opc > 4);			
		}else {
			opc = Funciones.numRandomEntre(1, 4);
		}
		switch(opc) {
			case 1:return Color.AMARILLO;
			case 2:return Color.AZUL;
			case 3:return Color.ROJO;
			case 4:return Color.VERDE;
			default: return Color.AMARILLO;
		}
	}
}
