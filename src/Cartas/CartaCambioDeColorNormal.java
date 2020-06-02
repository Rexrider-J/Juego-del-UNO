package Cartas;
import Cartas.TipoDeCarta;

public class CartaCambioDeColorNormal extends CartaCambioColor{
	private TipoDeCarta tipo = TipoDeCarta.CAMBIOCOLOR;
	private Color cambio;
	@Override
	public String showDetalles() {
		return "El jugador que tiré esta carta elije el color de cartas de la ronda";
	}

	@Override
	public String toString() {
		return "| Carta de cambio de color normal |";
	}

	@Override
	public TipoDeCarta getTipoCarta() {
		return tipo;
	}
	public void colorACambiar(Color c) {
		this.cambio = c;
	}
	public Color obtenerColorACambiar() {
		return this.cambio;
	}
}
