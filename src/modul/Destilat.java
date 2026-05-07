package modul;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destilat {
    private final int mængdeLiter;
    private final LocalDate påfyldningsDato;
    private final String signatur;
    private final int alkoholProcent;
    private final int newMakeNummer;
    private ArrayList<Lagring> lagringArrayList = new ArrayList<>();

    public Destilat(int mængdeLiter, LocalDate påfyldningsDato, String signatur, int alkoholProcent, int newMakeNummer) {
        this.mængdeLiter = mængdeLiter;
        this.påfyldningsDato = påfyldningsDato;
        this.signatur = signatur;
        this.alkoholProcent = alkoholProcent;
        this.newMakeNummer = newMakeNummer;
    }

    public int getMængdeLiter() {
        return mængdeLiter;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public String getSignatur() {
        return signatur;
    }

    public int getAlkoholProcent() {
        return alkoholProcent;
    }

    public int getNewMakeNummer() {
        return newMakeNummer;
    }

    public ArrayList<Lagring> getLagringArrayList() {
        return lagringArrayList;
    }
}
