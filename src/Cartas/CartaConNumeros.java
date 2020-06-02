package Cartas;

public class CartaConNumeros extends CartaNormales{
	private TipoDeCarta tipo = TipoDeCarta.NUMERICA;
	private int numero;

	public CartaConNumeros(Color color, int numero) {
		super(color);
		this.numero = numero;
	}

	@Override
	public String showDetalles() {
		return "Haga coincidir en color o en número con la última carta jugada del oponente";
	}
	
	@Override
	public String toString() {
		return "| Carta normal: "+ (this.numero + 1)  + " " + super.getColor() + " |";
	}

	@Override
	public TipoDeCarta getTipoCarta() {
		return tipo;
	}
	public int getNumero() {
		return this.numero;
	}
}
