package produits;

public enum Unicite {
	GRAMME("g"),
	KILOGRAMME("kg"),
	LITRE("l"),
	CENTILITRE("cl"),
	MILILITRE("ml"),
	PIECE("piece");

	private String systeme;
	
	Unicite(String systeme) {
		this.systeme = systeme;
	}
	
	@Override
	public String toString() {
		return systeme;
	}
}
