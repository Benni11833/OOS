package prak4gemklassen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prak4client.Client;
import prak4client.ClientOrb;
import prak4serv.Server;
import prak4serv.ServerOrb;
import sample.BenutzerVerwaltungAdmin;

import java.io.IOException;

class RemoteTests {

    ClientOrb bva1;
    BenutzerVerwaltungAdmin bva2;
    Thread serverT = new Thread(() -> {
        try {
            new ServerOrb(new BenutzerVerwaltungAdmin(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    @BeforeEach
    void setUp() throws Exception {
        /*serverT.start();  //-> nullPointerException
        Thread.sleep(200);
        ClientOrb bva1 = new ClientOrb();*/
    }

    @Test
    void benutzerOkEintragenTest() throws InterruptedException {

        serverT.start();
        Thread.sleep(200);
        ClientOrb bva1 = new ClientOrb();

        Benutzer b1 = new Benutzer("b1", "p1".toCharArray());
        try {
            assertFalse(bva1.benutzerOk(b1));
        } catch (NutzerVerwaltungException e) {
            fail("benutzerOkEintragenTest - sollte keine Exception werfen, sondern false zurückgeben");
        }

        try {
            bva1.benutzerEintragen(b1);
        } catch (NutzerVerwaltungException e) {
            fail("BenutzerEintragen sollte keine Exception werfen(b1)");
        }

        try {
            assertTrue(bva1.benutzerOk(b1));
        } catch (NutzerVerwaltungException e) {
            fail("benutzerOkEintragenTest - sollte keine Exception werfen, sondern true zurückgeben");
        }

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
    void benutzerLöschenTest() throws InterruptedException {

        serverT.start();
        Thread.sleep(200);
        ClientOrb bva1 = new ClientOrb();

        Benutzer b1 = new Benutzer("b2", "pw1".toCharArray());

        try {
            bva1.benutzerEintragen(b1);
        } catch (NutzerVerwaltungException e) {
            fail("BenutzerLöschenTest: b1 sollte eingetragen werden");
        }

        try {
            assertTrue(bva1.benutzerOk(b1));
        } catch (NutzerVerwaltungException e) {
            fail("benutzerLöschenTest - sollte keine Exception werfen, sondern true zurückgeben");
        }

        try {
            bva1.benutzerLöschen(b1);
        } catch(NutzerVerwaltungException e) {
            fail("BenutzerLöschenTest: b1 sollte gelöscht werden");
        }

        try {
            assertFalse(bva1.benutzerOk(b1));
        } catch (NutzerVerwaltungException e) {
            fail("benutzerLöschenTest - sollte keine Exception werfen, sondern false zurückgeben");
        }

        try {
            bva1.benutzerLöschen(null);
            fail("BenutzerLöschenTEst: null sollte Exception auslösen");
        } catch (NutzerVerwaltungException e) {
            ;
        }
    }

}
