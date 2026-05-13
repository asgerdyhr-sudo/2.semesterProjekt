package controller;

import modul.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Istorage;
import static org.mockito.Mockito.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ControllerTestRegisterPåfyldning {
    private Controller controller;
    private Istorage storage;
    private Fad fad;
    private Destillat destillat;

    @BeforeEach
    void setUp() {
        //Laver et mock af interfacet istedet for at bruge det rigtige storage
        this.storage = mock(Istorage.class);
        this.controller = new Controller(storage);
        Leverandør leverandør = mock(Leverandør.class);
         fad = new Fad("Fransk Eg",250,"Bourbon", leverandør);
        Medarbejder medarbejder = mock(Medarbejder.class);
        MængdeDestillat mængdeDestillat = mock(MængdeDestillat.class);
         destillat = new Destillat(60, LocalDate.now(), mængdeDestillat,medarbejder);
    }

    @Test
    void TC1_registrerPåfyldning_koblingSkabesFraFadTilDestillat() {
        //Arrange
        //Act
        controller.registrerPåfyldning(destillat,fad);

        //Assert
        assertTrue(fad.getDestilatList().contains(destillat));
    }

    @Test
    void TC2_registrerPåfyldning_koblingSkabesFraDestillatTilFad() {
        //Arrange
        //Act
        controller.registrerPåfyldning(destillat,fad);

        //Assert
        assertEquals(fad,destillat.getFad());
    }

    @Test
    void TC3_registrerPåfyldning_fadGemmesIFyldteFadeStorage() {
        //Arrange
        //Act
        controller.registrerPåfyldning(destillat,fad);

        //Assert
        assertTrue(storage.getAllFyldteFad().contains(fad));
        assertFalse(storage.getAlleTommeFad().contains(fad));
    }
}