package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut petre un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurs(produit);
			int num = vendeurs.length;
			if (num<=0) {
				System.out.println("Désolé, personne ne vend se produit au marché.");
			} else {
				for (int i=1; i < num;i++) {
					System.out.println(i+" - "+vendeurs[i-1].getNom());
				}
				int choixVendeur = -1;
				do {
					choixVendeur = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des "+produit+" ?\n");
				} while (choixVendeur <0 || choixVendeur > num);
				int quantite = Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?\n");
				int numAcheter = controlAcheterProduit.acheterProduit(vendeurs[choixVendeur-1],quantite);
				String vendeur = vendeurs[choixVendeur-1].getNom();
				if (numAcheter<quantite) {
					System.out.print(nomAcheteur+" veut acheter"+quantite+" "+produit+", malheuresement ");
					if (numAcheter==0) {
					System.out.println("il n'y en a plus.");
					}else {
					System.out.println(vendeur+" n'en a plus que "+numAcheter+". "+nomAcheteur+" achète tout le stock de "+vendeur+".");
					}
				} else {
					System.out.println(nomAcheteur+" achète "+quantite+" "+produit+" à "+vendeur".");
				}
			}
		}
	}
}
