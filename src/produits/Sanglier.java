package produits;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unicite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de "+poids+" chassé par "+chasseur;
	}
}
