package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation(){
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourcix",01,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(), new ControlTrouverEtalVendeur(), village);
		assertNotNull(controlAcheterProduit,"Conestructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(), new ControlTrouverEtalVendeur(), village);
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertTrue(controlAcheterProduit.verifierIdentite("Vermine"));
		assertFalse(controlAcheterProduit.verifierIdentite("Existe pas"));
	}

	@Test
	void testTrouverVendeurs() {
		ControlAfficherVillage controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(), new ControlTrouverEtalVendeur(), village);
		
	}

	@Test
	void testAcheterProduit() {
		ControlAfficherVillage controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(), new ControlTrouverEtalVendeur(), village);
		
	}

}
