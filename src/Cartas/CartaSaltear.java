
package Cartas;

public class CartaSaltear extends CartaNormales{
	private TipoDeCarta tipo = TipoDeCarta.SALTEAR;

	public CartaSaltear(Color color) {
		super(color);
	}

	@Override
	public String showDetalles() {
		return "La siguiente persona de la ronda es \"salteada\" y pierde su turno ";
		
	}

	@Override
	public String toString() {
		return "| Carta saltear color " + super.getColor() + " |";
	}

	@Override
	public TipoDeCarta getTipoCarta() {
		return tipo;
	}

}
