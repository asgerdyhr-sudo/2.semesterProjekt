package modul;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {

    private Maltbatch mockMaltbatch1;
    private Maltbatch mockMaltbatch2;
    private Medarbejder mockMedarbejder;
    private List<Maltbatch> validMaltbatchList;

    @BeforeEach
    void setUp() {
        mockMaltbatch1 = new Maltbatch(1, LocalDate.of(2023, 10, 1), 500);
        mockMaltbatch2 = new Maltbatch(2, LocalDate.of(2023, 10, 2), 600);

        validMaltbatchList = new ArrayList<>();
        validMaltbatchList.add(mockMaltbatch1);

        mockMedarbejder = new Medarbejder("Jens Hansen", "12345678", "JH");
    }

    /**
     * Denne test sikrer, at konstruktøren opretter et objekt korrekt,
     * når alle de nødvendige og gyldige informationer gives.
     */
    @Test
    void testConstructorGyldigDestillering() {
        // Arrange (Forberedelse)
        LocalDate forventetDato = LocalDate.now();
        int forventetMængde = 1000;
        boolean forventetRygemateriale = true;

        // Act (Udførelse)
        Destillering destillering = new Destillering(
                forventetDato,
                forventetMængde,
                forventetRygemateriale,
                validMaltbatchList,
                mockMedarbejder
        );

        // Assert (Bekræftelse)
        assertNotNull(destillering, "Destillerings-objektet bør ikke være null");
        assertEquals(forventetDato, destillering.getDato());
        assertEquals(forventetMængde, destillering.getMængdeLiter());
        assertTrue(destillering.isRygemateriale());
        assertEquals(1, destillering.getMaltbatches().size());
        assertEquals(mockMedarbejder, destillering.getMedarbejder());
    }

    /**
     * Denne test bekræfter, at systemet kaster den korrekte fejl (Exception),
     * hvis man forsøger at oprette en destillering uden en medfølgende maltbatch.
     */
    @Test
    void testConstructorKasterExceptionVedTomMaltbatchListe() {
        // Arrange (Forberedelse)
        List<Maltbatch> tomListe = new ArrayList<>();
        LocalDate dato = LocalDate.now();

        // Act (Udførelse) & Assert (Bekræftelse)
        // Vi angiver Act og Assert i samme blok for at fange afvigelsen.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Destillering(dato, 1000, true, tomListe, mockMedarbejder);
        });

        // Assert (Bekræftelse fortsat: Tjekker vi får den rigtige fejlbesked)
        assertEquals("Der skal være minimum 1 maltbatch knyttet til en destillering.", exception.getMessage());
    }

    /**
     * Denne test bekræfter, at der kastes en korrekt fejl,
     * hvis medarbejderen der tilknyttes er sat til null.
     */
    @Test
    void testConstructorKasterExceptionVedNullMedarbejder() {
        // Arrange (Forberedelse)
        LocalDate dato = LocalDate.now();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Destillering(dato, 1000, true, validMaltbatchList, null);
        });

        // Assert (Bekræftelse fortsat: Tjekker vi får den rigtige fejlbesked)
        assertEquals("En destillering skal have tilknyttet en medarbejder.", exception.getMessage());
    }

    /**
     * Denne test verificerer, at en ny maltbatch kan tilføjes til eksisterende destillering,
     * og at den faktiske liste opdateres.
     */
    @Test
    void testAddMaltbatch() {
        // Arrange (Forberedelse)
        Destillering destillering = new Destillering(LocalDate.now(), 1000, false, validMaltbatchList, mockMedarbejder);

        // Act (Udførelse)
        destillering.addMaltbatch(mockMaltbatch2);

        // Assert (Bekræftelse)
        List<Maltbatch> opdateretListe = destillering.getMaltbatches();
        assertEquals(2, opdateretListe.size(), "Størrelsen på maltbatch listen burde nu være 2");
        assertTrue(opdateretListe.contains(mockMaltbatch2), "Listen burde indeholde den ny-tilføjede maltbatch");
    }

    /**
     * Test der tjekker, at man kan ændre den tilknyttede medarbejder på destilleringen
     * til en ny og gyldig medarbejder.
     */
    @Test
    void testSetMedarbejderGyldig() {
        // Arrange (Forberedelse)
        Destillering destillering = new Destillering(LocalDate.now(), 1000, false, validMaltbatchList, mockMedarbejder);
        Medarbejder nyMedarbejder = new Medarbejder("Peter Jensen", "87654321", "PJ");

        // Act (Udførelse)
        destillering.setMedarbejder(nyMedarbejder);

        // Assert (Bekræftelse)
        assertEquals(nyMedarbejder, destillering.getMedarbejder(), "Medarbejderen bør være opdateret til den nye");
    }

    /**
     * Forhindrer at en medarbejder kan ændres til være tom (null) efterfølgende.
     */
    @Test
    void testSetMedarbejderKasterExceptionVedNull() {
        // Arrange (Forberedelse)
        Destillering destillering = new Destillering(LocalDate.now(), 1000, false, validMaltbatchList, mockMedarbejder);

        // Act & Assert (Forventer fejl når man sætter til null)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            destillering.setMedarbejder(null);
        });

        // Assert
        assertEquals("Medarbejder må ikke være null.", exception.getMessage());
    }

    // --- TEST AF GRÆNSEVÆRDIER OG BEVIDSTE FEJL (NEGATIVE TESTS) ---
    // Bemærk: Nogle af disse tests vil fejle (være røde) i din test-kørsel lige nu.
    // Det gør de bevidst, fordi systemet (Destillering.java) endnu ikke afviser disse
    // "ulovlige" grænseværdier. Det synliggør, hvilken validering du evt. mangler i din kode.

    /**
     * Test der forventer en fejl, hvis man forsøger at oprette en destillering
     * med en negativ mængde liter (f.eks. -10).
     */
    @Test
    void testOpretDestilleringFejlerVedNegativMængdeLiter() {
        // Arrange
        int negativMængde = -10;

        // Act & Assert
        // Forventer at Destillering kaster en IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Destillering(LocalDate.now(), negativMængde, false, validMaltbatchList, mockMedarbejder);
        }, "Forventede en fejl ved negativ mængde liter, men den blev ikke kastet.");
    }

    /**
     * Test der undersøger nedre grænseværdi (0 liter).
     * Forventer en fejl, da en destillering antageligvis bør have en mængde større end 0.
     */
    @Test
    void testOpretDestilleringFejlerVedNulMængdeLiter() {
        // Arrange
        int nulMængde = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Destillering(LocalDate.now(), nulMængde, false, validMaltbatchList, mockMedarbejder);
        }, "Forventede en fejl ved 0 liter, men den blev ikke kastet.");
    }

    /**
     * Test der forventer en fejl, hvis datoen er sat i fremtiden.
     * Man bør ikke kunne registrere en destillering, der endnu ikke er sket.
     */
    @Test
    void testOpretDestilleringFejlerVedFremtidsDato() {
        // Arrange
        LocalDate fremtidsDato = LocalDate.now().plusDays(10); // 10 dage ude i fremtiden

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Destillering(fremtidsDato, 1000, false, validMaltbatchList, mockMedarbejder);
        }, "Forventede en fejl ved fremtidsdato, men den blev ikke kastet.");
    }
}
