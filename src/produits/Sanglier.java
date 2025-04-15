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
		return "sanglier de "+poids+" "+Unicite.KILOGRAMME+" chassé par "+chasseur.getNom();
	}
	
	// calcul du prix en fonction du poids
	@Override
	public int calculerPrix(int prixAuKilo) {
		super.calculerPrix(prixAuKilo);
		return ((poids*prixAuKilo)/1000);
	}
}
