package produits;

public abstract class Produit{
	private String nom;
	private Unicite unite;

	public Produit(String nom, Unicite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	public String getNom() {
		return nom;
	}
	
	public abstract String decrireProduit();
}
