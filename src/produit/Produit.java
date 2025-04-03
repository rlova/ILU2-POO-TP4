package produit;

public class Produit {
	private String nomProduit;
	private String[] unite;
	
	
	public Produit(String nomProduit, String[] unite) {
		super();
		this.nomProduit = nomProduit;
		this.unite = unite;
	}

	public String getNomProduit() {
		return nomProduit;
	}
}
