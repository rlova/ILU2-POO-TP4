package scenarioTest;

import personnages.Gaulois;
import produits.Poisson;
import produits.Produit;
import produits.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {

	public static void acheterProduit(Etal<?>[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante > 0; i++) {
			Etal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible > 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".");
	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		Gaulois ordralfabelix = new Gaulois("Ordralfabetix",9);
		Gaulois obelix = new Gaulois("Obelix",20);
		Gaulois asterix = new Gaulois("Asterix",6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sanglierAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal<Sanglier> etalObelix = new Etal();
		Etal<Sanglier> etalAsterix = new Etal();
		Etal<Poisson> etalOrddralfabelix = new Etal();
		
		etalObelix.installerVendeur(obelix, sangliersObelix, 8);
		etalAsterix.installerVendeur(asterix, sanglierAsterix, 10);
		etalOrddralfabelix.installerVendeur(ordralfabelix, poissons, 7);
		
		// 1) Afficher les étals du marché
		System.out.println(etalObelix.etatEtal());
		System.out.println(etalAsterix.etatEtal());
		System.out.println(etalOrddralfabelix.etatEtal());
		
		// 2) Acheter 3 sangliers
		// création d'un tableau d'étals (? : pour contenir n'importe quel type d'étal
		Etal<?>[] marche = {etalAsterix, etalObelix, etalOrddralfabelix};
		acheterProduit(marche, "sanglier", 3);
		
		// 3) Afficher les étals du marché
		System.out.println("\n");
		System.out.println(etalAsterix.etatEtal());
		System.out.println(etalObelix.etatEtal());
		System.out.println(etalOrddralfabelix.etatEtal());
	}
}
