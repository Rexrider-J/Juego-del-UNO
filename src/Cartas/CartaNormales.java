package Cartas;

public abstract class CartaNormales implements Carta {
	private Color color;
	
	public CartaNormales(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
}
