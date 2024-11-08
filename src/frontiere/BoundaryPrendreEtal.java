package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			} else {
				installerVendeur(nomVendeur);
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n"
				+ "Il me faudrait quelques renseignements.\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous prendre ?\n");
		int nEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (nEtal !=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+nEtal);
		}
		
	}
}
