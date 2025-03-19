package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produitAcheter = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		int choixUtilisateur;
		Gaulois [] commercant = controlAcheterProduit.rechercherVendeurProduit(produitAcheter);
		int i = 0;
		do {
			StringBuilder question = new StringBuilder();
		question.append("Chez quel commerçant voulez-vous acheter des " + produitAcheter + "\n");

		for(;i<commercant.length;i++) {
			question.append(i+1 + "-" + commercant[i].getNom() );
		}
		choixUtilisateur = Clavier.entrerEntier(question.toString());
		}while(choixUtilisateur <1 || choixUtilisateur > commercant.length);
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + commercant[choixUtilisateur-1].getNom() + "\n");
		System.out.println("Bonjour "+ nomAcheteur);
		int nbProduitAcheter = Clavier.entrerEntier("Combien de " + produitAcheter + " voulez-vous acheter ?");
		System.out.println(nomAcheteur + " achète " + nbProduitAcheter + " " + produitAcheter + " à "+ commercant[choixUtilisateur-1].getNom());
	
	}
}
