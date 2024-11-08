package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
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
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertTrue(controlVerifierIdentite.verifierIdentite("Vermine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Nexistepas"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}
}
