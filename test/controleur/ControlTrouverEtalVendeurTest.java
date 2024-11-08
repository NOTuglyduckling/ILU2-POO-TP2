package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
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
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Vermine"));
		village.installerVendeur(vermine, "produits",1000);
		assertTrue(controlTrouverEtalVendeur.trouverEtalVendeur("Vermine").isEtalOccupe());
	}

}
