package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois GauloisVendeur = village.trouverHabitant(nomVendeur);
		Etal etal = null;
		if(GauloisVendeur!=null) {
			etal = village.rechercherEtal(GauloisVendeur);
		}
		return etal;
	}
}
