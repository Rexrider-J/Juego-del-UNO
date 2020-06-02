package Cartas;
public class CartaCambioDeColorMasCuatro extends CartaCambioColor {
	private TipoDeCarta tipo = TipoDeCarta.CAMBIOCOLORMASCUATRO;
	private Color cambio;

	@Override
	public String showDetalles() {
		return "El jugador que tiré esta carta elije el color de cartas de la ronda y obliga al siguiente jugador a agarrar 4 cartas. \n Si se encontraba una carta de suma";
	}

	@Override
	public String toString() {
		return "| Carta de cambio de color +4 |";
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
