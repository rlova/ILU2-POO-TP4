package scenarioTest;

import java.security.PublicKey;

import personnages.Gaulois;
import produits.Poisson;
import produits.Produit;
import produits.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
		    private IEtal<?>[] etals = new IEtal<?>[3]; // Tableau pour stocker les étals
		    
		    @Override
		    public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
		        etal.installerVendeur(vendeur, produit, prix);
		        // Ajouter l'étal au tableau
		        for (int i = 0; i < etals.length; i++) {
		            if (etals[i] == null) {
		                etals[i] = etal;
		                return true;
		            }
		        }
		        return false;
		    }
		    
		    @Override
		    public void acheterProduit(String produit, int quantiteSouhaitee) {
		        // Implémentation similaire à ScenarioTest.acheterProduit()
		        int quantiteRestante = quantiteSouhaitee;
		        for (int i = 0; i < etals.length && quantiteRestante > 0; i++) {
		            if (etals[i] != null) {
		                int quantiteDisponible = etals[i].contientProduit(produit, quantiteRestante);
		                if (quantiteDisponible > 0) {
		                    int prix = etals[i].acheterProduit(quantiteDisponible);
		                    String chaineProduit = quantiteDisponible > 1 ? produit + "s" : produit;
		                    System.out.println("A l'étal n° " + (i + 1) + ", j'achète " + quantiteDisponible + " " + chaineProduit
		                            + " et je paye " + prix + " sous.");
		                    quantiteRestante -= quantiteDisponible;
		                }
		            }
		        }
		        String chaineProduit = quantiteSouhaitee > 1 ? produit + "s" : produit;
		        System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
		                + (quantiteSouhaitee - quantiteRestante) + ".");
		    }
		    
		    @Override
		    public String toString() {
		        StringBuilder sb = new StringBuilder();
		        for (IEtal<?> etal : etals) {
		            if (etal != null) {
		                sb.append(etal.etatEtal());
		            }
		        }
		        return sb.toString();
		    }
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		IEtal<Sanglier> etalSanglierObelix = new Etal<>();
		IEtal<Sanglier> etalSanglierAsterix = new Etal<>();
		IEtal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
