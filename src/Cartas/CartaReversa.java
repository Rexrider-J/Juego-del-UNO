package Cartas;

public class CartaReversa extends CartaNormales{
	private TipoDeCarta tipo = TipoDeCarta.REVERSA;
	
	public CartaReversa(Color color) {
		super(color);
	}

	@Override
	public String showDetalles() {
		return "Esta carta cambiará la dirección de la ronda";
	}


	@Override
	public String toString() {
		return "| Carta reversa color " +  super.getColor() + " |";
	}

	@Override
	public TipoDeCarta getTipoCarta() {
		return tipo;
	}
}
