package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheter.trouverHabitant(nomAcheteur)!=null) {
			System.out.println("Je suis désolée Bonemine mais il faut petre un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		
			int vendeur = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des "+produit+" ?\n");
		}
		
		
	}
}
