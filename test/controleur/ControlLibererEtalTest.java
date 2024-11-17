package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		assertNotNull(controlLibererEtal,"Conestructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		assertFalse(controlLibererEtal.isVendeur("Vermine"));
		village.installerVendeur(vermine, "fleur", 1);
		assertTrue(controlLibererEtal.isVendeur("Vermine"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		Gaulois vermine = new Gaulois("Vermine",3);
		village.ajouterHabitant(vermine);
		village.installerVendeur(vermine, "fleur", 1);
		String[] donnees = controlLibererEtal.libererEtal("Vermine");
		assertEquals(donnees[0],"true");
		assertEquals(donnees[1],"Vermine");
		assertEquals(donnees[2],"fleur");
		assertEquals(donnees[3],"1");
		assertEquals(donnees[4],"0");
		
	}

}
