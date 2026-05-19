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
        Medarbejder medarbejder = mock(Medarbejder.class);
        MængdeDestillat mængdeDestillat = mock(MængdeDestillat.class);

        fad = controller.createFad("Fransk Eg", 250, "Bourbon", leverandør);
        destillat = controller.createDestillat(60, LocalDate.now(), mængdeDestillat, medarbejder);
    }

    @Test
    void TC1_registrerFadPåfyldning_koblingSkabesFraFadTilDestillat() {
        //Arrange
        //Act
        controller.registrerFadPåfyldning(destillat, fad);

        //Assert
        assertTrue(fad.getDestilatList().contains(destillat));
    }

    @Test
    void TC2_registrerFadPåfyldning_koblingSkabesFraDestillatTilFad() {
        //Arrange
        //Act
        controller.registrerFadPåfyldning(destillat, fad);

        //Assert
        assertEquals(fad, destillat.getFad());
    }

    @Test
    void TC3_registrerFadPåfyldning_fadGemmesIFyldteFadeStorage() {
        //Arrange
        //Act
        controller.registrerFadPåfyldning(destillat, fad);

        //Assert
        verify(storage).addFad(fad);
        verify(storage).addDestilat(destillat);
    }
}