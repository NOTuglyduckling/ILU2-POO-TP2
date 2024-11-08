package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 = new StringBuilder("Quelle est votre force ?\n");
					int force = -1;
					do {		
					force = Clavier.entrerEntier(question2.toString());
					} while (force <0);
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question2 = new StringBuilder("Quelle est votre force ?\n");
		int force = Clavier.entrerEntier(question2.toString());
		int effetPotionMax = -1;
		int effetPotionMin =-1;
		while (effetPotionMax ==-1 || effetPotionMin == -1) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?\n");
			if (effetPotionMax < effetPotionMin) {
				System.out
				.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum\n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur,force,effetPotionMin,effetPotionMax);
		
	}
}
