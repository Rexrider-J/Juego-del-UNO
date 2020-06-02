package Cartas;

public class CartaDoble extends CartaNormales{
	private TipoDeCarta tipo = TipoDeCarta.DOBLE;
	
	public CartaDoble(Color color) {
		super(color);
	}
	
	@Override
	public String showDetalles() {
		return "La siguiente persona deberá levantar 2 cartas del mazo, si se usa en una carta de suma se aumentará 2 más y se pasará al siguiente jugador";
	}

	@Override
	public String toString() {
		return "| Carta doble color " +  super.getColor() + " |";
	}

	@Override
	public TipoDeCarta getTipoCarta() {
		return tipo;
	}
}
