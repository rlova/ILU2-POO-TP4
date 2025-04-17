package villagegaulois;
 
 import personnages.Gaulois;
import produits.IProduit;
import produits.Produit;
 
 public class Etal <P extends IProduit> implements IEtal {
 	private Gaulois vendeur;
 	private P[] produit;
 	private int nbProduit;
 	private int quantiteDebutMarche;
 	private int quantite;
 	private boolean etalOccupe = false;
 	private int prix;
 
 	public boolean isEtalOccupe() {
 		return etalOccupe;
 	}
 
 	public Gaulois getVendeur() {
 		return vendeur;
 	}
 
 	public int getQuantite() {
 		return quantite;
 	}
 	
 	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
 		this.vendeur = vendeur;
 		this.produit = produit;
 		this.prix = prix;
 		this.nbProduit = produit.length; // initialisation pour avoir le nbProduit
 		this.quantiteDebutMarche = produit.length; // ------ || ---------
 		this.etalOccupe = true;
 	}
 
 	public void occuperEtal(Gaulois vendeur, int quantite) {
 		this.vendeur = vendeur;
 		this.produit = (P[]) new IProduit[100];
 		this.nbProduit = 0;
 		this.quantite = quantite;
 		quantiteDebutMarche = quantite;
 		etalOccupe = true;
 	}
 
 	@Override
 	public int contientProduit(String produit, int quantiteSouhaitee) {
 		int quantiteAVendre = 0;
 		if (nbProduit == 0 || !this.produit[0].getNom().equals(produit)) {
 	        quantiteAVendre = quantiteSouhaitee;
 	    }
 	    if (quantiteSouhaitee > nbProduit) {
 	        quantiteAVendre = nbProduit;
 	    } else {
 	        quantiteAVendre = quantiteSouhaitee;
 	    }
 	    // La répartition sur plusieurs étals
 	    if (quantiteSouhaitee > 2 && quantiteAVendre > 2) {
 	        quantiteAVendre = 2;
 	    }
 	   return quantiteAVendre;
 	}
 
 	@Override
 	public int acheterProduit(int quantiteSouhaitee) {
 		int prixPaye = 0;
 		for (int i=nbProduit-1; i>nbProduit-quantiteSouhaitee-1 && i>0; i--) { 
 			prixPaye += produit[i].calculerPrix(prix);
 		}
 		if (nbProduit>=quantiteSouhaitee) {
 			nbProduit -= quantiteSouhaitee;
 		} else {
 			nbProduit = 0;
 		}
 		return prixPaye;
 	}
 
 	public void libererEtal() {
 		etalOccupe = false;
 	}
 
 	@Override
 	public String etatEtal() {
 		StringBuilder chaine = new StringBuilder(vendeur.getNom());
 		if (nbProduit>0) {
 			chaine.append(" vend ");
 			chaine.append(nbProduit+" produits: ");
 			for (int i=0; i<nbProduit; i++) {
 				chaine.append("\n- "+produit[i].decrireProduit());
 			}
 		} else {
 			chaine.append(" n'a plus rien à vendre.");
 		}
 		chaine.append("\n");
 		return chaine.toString();
 	}
 
 }