package villagegaulois;

import personnages.Gaulois;
import produits.Produit;

public interface IEtal {
	Gaulois getVendeur();
	int contientProduit(String produit, int quantiteSouhaitee);
	int acheterProduit(int quantiteSouhaitee);
	String etatEtal();

}