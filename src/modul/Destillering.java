package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Destillering {
    private final LocalDate dato;
    private final double alkoholProcent;
    private final int newMakeNr;
    private final String maltbatch;
    private final String rygemateriale;
    private final Kornsort kornsort;
    private final MængdeDestillat mængdeDestillat;
    private final Medarbejder medarbejder;

    public Destillering(LocalDate dato, double alkoholProcent, int newMakeNr, String maltbatch, String rygemateriale, Kornsort kornsort, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        if (dato == null) {
            throw new IllegalArgumentException("Dato må ikke være tom.");
        }
        if (alkoholProcent <= 0 || alkoholProcent > 100) {
            throw new IllegalArgumentException("Alkoholprocent skal være mellem 0 og 100.");
        }
        if (newMakeNr <= 0) {
            throw new IllegalArgumentException("New Make Nummer skal være større end 0.");
        }
        if (maltbatch == null || maltbatch.trim().isEmpty()) {
            throw new IllegalArgumentException("Maltbatch skal udfyldes.");
        }
        if (kornsort == null) {
            throw new IllegalArgumentException("Kornsort skal vælges.");
        }

        this.dato = dato;
        this.alkoholProcent = alkoholProcent;
        this.newMakeNr = newMakeNr;
        this.maltbatch = maltbatch;
        this.rygemateriale = rygemateriale;
        this.kornsort = kornsort;
        this.mængdeDestillat = mængdeDestillat;
        this.medarbejder = medarbejder;
    }

    public LocalDate getDato() {
        return dato;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public int getNewMakeNr() {
        return newMakeNr;
    }

    public String getMaltbatch() {
        return maltbatch;
    }

    public Kornsort getKornsort() {
        return kornsort;
    }

    public MængdeDestillat getMængdeDestillat() {
        return mængdeDestillat;
    }

    public Medarbejder getMedarbejder() {
        return medarbejder;
    }

    public String getRygemateriale() {
        return rygemateriale;
    }
}