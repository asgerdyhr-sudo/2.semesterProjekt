package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Destillering {
    private final int mængdeLiter;
    private final LocalDate påfyldningsDato;
    private final String signatur;
    private final int alkoholProcent;
    private final int newMakeNummer;
    private final List<Maltbatch> maltbatches;

    public Destillering(int mængdeLiter, LocalDate påfyldningsDato, String signatur, int alkoholProcent, int newMakeNummer, List<Maltbatch> maltbatches) {
        this.mængdeLiter = mængdeLiter;
        this.påfyldningsDato = påfyldningsDato;
        this.signatur = signatur;
        this.alkoholProcent = alkoholProcent;
        this.newMakeNummer = newMakeNummer;
        if (maltbatches == null || maltbatches.isEmpty()) {
            throw new IllegalArgumentException("Maltbatch skal være oprettet for at lave en destillering");
        }
        this.maltbatches = new ArrayList<>(maltbatches);
    }

    public void addMaltbatch(Maltbatch maltbatch) {
        if (!maltbatches.contains(maltbatch)) {
            maltbatches.add(maltbatch);
        }
    }

    public void removeMaltbatch(Maltbatch maltbatch) {
        if (maltbatches.contains(maltbatch)) {
            maltbatches.remove(maltbatch);
        }
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

    public List<Maltbatch> getMaltbatches() {
        return maltbatches;
    }
}


