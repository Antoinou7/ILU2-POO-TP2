package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String [] infosMarche= controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			int i = 0;
			while(infosMarche.length<0) {
				System.out.println("-"+ infosMarche[i] + " qui vend ");
				i++;
				System.out.println(infosMarche[i]);
				i++;
				System.out.println(" ");
				System.out.println(infosMarche[i]);
			}
		}
		
		
	}
}
