package produits;

public class Poisson extends Produit {
	private String datePeche;

	public Poisson(String datePeche) {
		super("poisson",Unicite.PIECE);
		this.datePeche = datePeche;
	}
	
	@Override
	public String decrireProduit() {
		return "poisson pêchés "+ datePeche;
	}
	
	// prix à l'unité pour les poissons
	@Override
	public int calculerPrix(int prixUnite) {
		return super.calculerPrix(prixUnite);
	}
}
