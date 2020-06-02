import Cartas.Carta;

public class PersonPlayer extends Player{
	
	
	public PersonPlayer(String name) {
		super(name);
	}
	@Override
	public int escogerCarta(Carta ultimaCarta) {
		int opc;
		System.out.print("Escoja una carta de su mazo:");
		opc = Funciones.entrada.nextInt();
		while(opc > super.cantCartas() || opc < 0) {
			System.out.print("Esa carta no se encuentra en su mazo. Intente de nuevo: ");
			opc = Funciones.entrada.nextInt();
		}
		if(opc > 0 && opc < super.cantCartas()) {
			showDetalles(opc - 1);
		}
		return opc;
	}
	 public boolean puedeTirar(Carta ultimaCarta) {
		 System.out.println("La ultima carta es " + ultimaCarta.toString() + " y posees estas cartas: ");
		 showCartas();
		 char resp = Funciones.readChar("¿Quiere jugar o ceder el turno? j/p: ");
		 while(resp != 'j' && resp != 'J' && resp != 'p' && resp != 'P') {
			 resp = Funciones.readChar("Opción inválida. Por favor intentelo de nuevo: \n");
		 }
		 if(resp == 'j' || resp == 'J') {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	
	public void showCartas() {
		for (int j = 0; j < super.cantCartas(); j++) {
			System.out.println("[ " + (j+1) + " ]" + super.getCarta(j).toString());
		}
	}
	
	private void showDetalles(int c) {
		char resp;
		resp = Funciones.readChar("Desea ver más detalles de la carta? s/n:");
		while(resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
			resp = Funciones.readChar("Debe utilizar \"s\" ó \"n\". Por favor intentelo de nuevo: \n");
		}
		if(resp == 's' || resp == 'S') {
			System.out.println(super.getCarta(c).showDetalles());
		}
	}
	
	@Override
	public boolean uno() {
		char opc = Funciones.readChar("¿Desea decir \"Uno\"? s/n:");
		if(opc == 's' || opc == 'S') {
			return true;
		}
		else {
			return false;
		}
	}

}
