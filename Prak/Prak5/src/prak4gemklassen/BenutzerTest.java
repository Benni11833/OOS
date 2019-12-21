package prak4gemklassen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.*;

class BenutzerTest {

	Benutzer b1, b2;

	@BeforeEach
	void setUp() throws Exception {
		b1 = new Benutzer("1337", "passwort123".toCharArray());
		b2 = new Benutzer("","".toCharArray());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void generalBenutzer(){
		assertEquals(b1.userId, "1337");
		assertTrue(Arrays.equals(b1.passWort, "passwort123".toCharArray()));
	}

	@Test
	void testBenutzerToString() {
		assertEquals("Benutzer(1337, passwort123)", b1.toString());
		assertEquals("Benutzer(, )", b2.toString());
	}

	@Test
	void testBenutzerEquals() {
		assertFalse(b1.equals(b2));
		b2 = new Benutzer("1337", "passwort123".toCharArray());
		assertTrue(b2.equals(b1));
		b2 = new Benutzer("1337", "falschesPw".toCharArray());
		assertFalse(b2.equals(b1));
		b2 = new Benutzer("2201", "passwort123".toCharArray());
		assertFalse(b2.equals(b1));
		assertFalse(b1.equals(null));
		//test fuer !(object o instanceof Benutzer)
		assertFalse(b1.equals("Test"));
	}

}
