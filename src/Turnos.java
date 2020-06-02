import java.util.ArrayList;

public class Turnos {
	private static ArrayList<Player> jugadores;
	private static int numJugadores;
	
	public Turnos(ArrayList<Player> j) {
		jugadores = new ArrayList<>();
		this.jugadores.addAll(j);
	}
	
	public Player nextJugador(){
        Player jugador = this.jugadores.get(0);
        if(Turnos.jugadores.size() != 0){
            jugador = Turnos.jugadores.get(Turnos.numJugadores % Turnos.jugadores.size());
        }
        Turnos.numJugadores += 1;
        return jugador; 
    }
	
	public void Saltear() {
		Turnos.numJugadores += 1;
	}
	
	public void Reversa() {
		ArrayList<Player> aux = new ArrayList<Player>();
	    for (int i = Turnos.jugadores.size()-1; i>=0; i--) {
	        aux.add(Turnos.jugadores.remove(i));
	    }
	    jugadores.addAll(aux);
	    aux.clear();
	    int posicionDelSiguienteJugador = jugadores.size() - (Turnos.numJugadores - 1);
	    Turnos.numJugadores = posicionDelSiguienteJugador;
	}
}
