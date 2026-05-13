package controller;

import modul.Fad;
import modul.Leverandør;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Istorage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTestCreateFad {
    private Controller controller;
    private Istorage storage;

    @BeforeEach
    void setUp() {
        //Laver et mock af interfacet istedet for at bruge det rigtige storage
        this.storage = mock(Istorage.class);
        this.controller = new Controller(storage);
    }

    @Test
    void TC1_createFad_gyldigeData1() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Spanien");

        //Act
        Fad fad = controller.createFad("Portpipe", 500, "Bourbon", leverandør);

        //Assert
        assertNotNull(fad);
        assertEquals(1, fad.getFadNr());
        assertEquals("Portpipe", fad.getFadType());
        assertEquals(500, fad.getStørrelseLiter());
        assertEquals("Bourbon", fad.getTidligereIndhold());
        assertEquals(leverandør, fad.getLeverandør());

        // Test af at controlleren gemmer fadet i storage (kalder addFad præcis én gang)
        verify(storage, times(1)).addFad(fad);
    }

    @Test
    void TC2_createFad_gyldigeData2() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Frankrig");

        //Act
        Fad fad = controller.createFad("Portpipe", 250, "Sherry", leverandør);

        //Assert
        assertNotNull(fad);
        assertEquals(1, fad.getFadNr());
        assertEquals("Portpipe", fad.getFadType());
        assertEquals(250, fad.getStørrelseLiter());
        assertEquals("Sherry", fad.getTidligereIndhold());
        assertEquals(leverandør, fad.getLeverandør());

        // Test af at controlleren gemmer fadet i storage (kalder addFad præcis én gang)
        verify(storage, times(1)).addFad(fad);
    }

    @Test
    void TC3_createFad_fadtypeNull() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Frankrig");

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> controller.createFad(null, 250, "Sherry", leverandør));
    }

    @Test
    void TC4_createFad_størrelseLiter0() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Frankrig");

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> controller.createFad("Portpipe", 0, "Sherry", leverandør));
    }

    @Test
    void TC5_createFad_størrelseLiterNegativ() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Frankrig");

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> controller.createFad("Portpipe", -1, "Sherry", leverandør));
    }

    @Test
    void TC6_createFad_tidligereIndholdNull() {
        //Arrange
        Leverandør leverandør = new Leverandør("Leverandør", "Frankrig");

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> controller.createFad("Portpipe", 500, null, leverandør));
    }

    @Test
    void TC7_createFad_leverandørNegativ() {
        //Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> controller.createFad("Portpipe", 400, "Sherry", null));
    }
}