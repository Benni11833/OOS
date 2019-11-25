package prak_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenutzerVerwaltungAdminTest {
	
	BenutzerVerwaltungAdmin bva1, bva2;

	@BeforeEach
	void setUp() throws Exception {
		bva1 = new BenutzerVerwaltungAdmin();
		bva1.dbInitialisieren();
	}

	@Test
	void benutzerOkEintragenTest() {
		Benutzer b1 = new Benutzer("b1", "p1".toCharArray());
		assertFalse(bva1.benutzerOk(b1));
		
		try {
			bva1.benutzerEintragen(b1);
		} catch (NutzerVerwaltungException e) {
			fail("BenutzerEintragen sollte keine Exception werfen(b1)");
		}
		assertTrue(bva1.benutzerOk(b1));
		Benutzer b2 = new Benutzer("b1", "p2".toCharArray());
		try {
			bva1.benutzerEintragen(b2);
			fail("BenutzerEintragen wirft keine Exception, obwhol userId schon vergeben(b2)");
		} catch (NutzerVerwaltungException e) {
			;
		}
		
		try {
			bva1.benutzerEintragen(null);
			fail("BenutzerEIntragen sollte Exception werfen bei null");
		} catch (NutzerVerwaltungException e) {
			;
		}
	}
	
	@Test
	void benutzerLöschenTest() {
		Benutzer b1 = new Benutzer("b2", "pw1".toCharArray());
		
		try {
			bva1.benutzerEintragen(b1);
		} catch (NutzerVerwaltungException e) {
			fail("BenutzerLöschenTest: b1 sollte eingetragen werden");
		}
		assertTrue(bva1.benutzerOk(b1));
		
		try {
			bva1.benutzerLöschen(b1);
		} catch(NutzerVerwaltungException e) {
			fail("BenutzerLöschenTest: b1 sollte gelöscht werden");
		}
		assertFalse(bva1.benutzerOk(b1));
		
		try {
			bva1.benutzerLöschen(null);
			fail("BenutzerLöschenTEst: null sollte Exception auslösen");
		} catch (NutzerVerwaltungException e) {
			
		}
	}

}
