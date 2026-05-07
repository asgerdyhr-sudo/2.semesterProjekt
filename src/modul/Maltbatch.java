package modul;


import java.time.LocalDate;

public class Maltbatch {
private final int bacthNummer;
private final LocalDate dato;
private final int mængdeKg;

    public Maltbatch(int bacthNummer, LocalDate dato, int mængdeKg) {
        this.bacthNummer = bacthNummer;
        this.dato = dato;
        this.mængdeKg = mængdeKg;
    }

    public int getBacthNummer() {
        return bacthNummer;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getMængdeKg() {
        return mængdeKg;
    }
}