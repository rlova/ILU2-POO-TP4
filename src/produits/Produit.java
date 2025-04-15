package produits;

public abstract class Produit implements IProduit {
	private String nom;
	private Unicite unite;

	protected Produit(String nom, Unicite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	public String getNom() {
		return nom;
	}
	
	// implémentation de calculer prix
	@Override
	public int calculerPrix(int prix) {
		return prix;
	}
}
