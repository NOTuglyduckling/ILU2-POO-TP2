package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation(){
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles",10,1);
		abraracourcix = new Chef("Abraracourcix",01,village);
		village.setChef(abraracourcix);
		
	}
	
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		village.installerVendeur(vermine, "produits",1000);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertTrue(controlPrendreEtal.prendreEtal("Vermine","fleurs",10)==0);
		Gaulois bob = new Gaulois("Bob",3);
		village.ajouterHabitant(bob);
		assertTrue(controlPrendreEtal.prendreEtal("Bob","fleurs",10)==-1);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertFalse(controlPrendreEtal.verifierIdentite("Vermine"));
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertTrue(controlPrendreEtal.verifierIdentite("Vermine"));
	}

}
