package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

	    if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
	        System.out.println("Je suis désolé " + nomAcheteur + ", mais il faut être un habitant du village pour commercer ici.");
	        return; 
	    }

	    String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
	    
	   
	    Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeurProduit(produit);
	    
	   
	    if (vendeurs == null || vendeurs.length == 0) {
	        System.out.println("Désolé, personne ne vend ce produit au marché.");
	        return; 
	    }

	 
	    int choixUtilisateur;
	    do {
	        StringBuilder question = new StringBuilder();
	        question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");

	        for (int i = 0; i < vendeurs.length; i++) {
	            question.append((i + 1) + " - " + vendeurs[i].getNom() + "\n");
	        }

	        choixUtilisateur = Clavier.entrerEntier(question.toString());
	    } while (choixUtilisateur < 1 || choixUtilisateur > vendeurs.length);

	    Gaulois vendeurChoisi = vendeurs[choixUtilisateur - 1];

	   
	    System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurChoisi.getNom() + "\n");
	    System.out.println("Bonjour " + vendeurChoisi.getNom() + " !");
	    System.out.println("Bonjour " + nomAcheteur + " !");

	    
	    int nbProduitAcheter = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
	    int quantiteAchetee = controlAcheterProduit.acheterProduit(vendeurChoisi.getNom(), nbProduitAcheter);

	   
	    if (quantiteAchetee == 0) {
	        System.out.println(nomAcheteur + " veut acheter " + nbProduitAcheter + " " + produit + ", malheureusement il n’y en a plus !");
	    } else if (quantiteAchetee < nbProduitAcheter) {
	        System.out.println(nomAcheteur + " voulait acheter " + nbProduitAcheter + " " + produit +
	                ", mais il ne restait que " + quantiteAchetee + ".");
	    } else {
	        System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + vendeurChoisi.getNom());
	    }
	}

}
