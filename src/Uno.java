import java.util.ArrayList;


public class Uno {
	private AccionDeCartas accion;
	private ArrayList<Player> players;
	private Turnos turno;
	
	public Uno() {
		players = new ArrayList<Player>();
		this.players.add(new PersonPlayer("Mena"));
		this.players.add(new MachinePlayer("Dendy"));
		this.players.add(new MachinePlayer("Theo"));
		accion = new AccionDeCartas();
		//agregarJugadores();
		reglas();
		jugar();
	} 
	
	private void reglas() {
		System.out.println("Pendiente...");
	}
	
	private void agregarJugadores() {
		String name;
		char opc;
		name = Funciones.readString("Ingrese su nombre: \n");
		this.players.add(new PersonPlayer(name));
		do {
			name = Funciones.readString("Ingrese el nombre de su contrincante: \n");
			this.players.add(new MachinePlayer(name));
			opc = Funciones.readChar("Desea agregar otro jugador maquina? s/n: \n");
			while(opc != 's' && opc != 'S' && opc != 'n' && opc != 'N') {
				opc = Funciones.readChar("Debe utilizar \"s\" ó \"n\". Por favor intentelo de nuevo: \n");
			}
		}while(opc == 's' || opc == 'S');
	}
	
	private void jugar() {
		Player jugador;
		turno = new Turnos(this.players);
		this.accion.repartirCartasIniciales(players);
		this.accion.primeraCarta();
		int hayGanador = 3;
		do{
			jugador = turno.nextJugador();
			System.out.println(jugador.toString());
			this.accion.accionDeUltimaCartaAntesDeJugar(jugador);
			if(this.accion.puedeTirar(jugador) == true) {
				this.accion.comprobarCarta(jugador);
				this.accion.accionDeUltimaCartaDespuesDeJugar(jugador,turno);
				this.accion.hayCartas();
				this.accion.comprobarGanador(jugador, hayGanador(jugador));
			}else {
				System.out.println(jugador.toString() + " pasó su turno!");
			}
			if(jugador instanceof MachinePlayer) {
				jugador.showCartas();
			}
		}while(hayGanador != 1);
		System.out.println("GANADOR: " + jugador.toString());
	}
	
	public int hayGanador(Player jugador) {
		int DIJO_UNO_Y_CARTAS_IGUAL_1 = 1;
		int DIJO_UNO_Y_CARTAS_DISTINTO_1 = 2;
		int NO_DIJO_UNO = 3;
		if(jugador.uno()==true) {
			System.out.println(jugador.toString() + " dijo UNO!.");
			if(jugador.cantCartas() == 1) {
				return 1;
			}else {
				return 2;
			}
		}else {
			return 3;
		}
	}
}
