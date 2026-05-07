package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Destillering {
    private final LocalDate dato;
    private final int mængdeLiter;
    private final boolean rygemateriale;
    private final List<Maltbatch> maltbatches;
    private Medarbejder medarbejder;

    public Destillering(LocalDate dato, int mængdeLiter, boolean rygemateriale, List<Maltbatch> maltbatches, Medarbejder medarbejder) {
        this.dato = dato;
        this.mængdeLiter = mængdeLiter;
        this.rygemateriale = rygemateriale;

        if (maltbatches == null || maltbatches.isEmpty()) {
            throw new IllegalArgumentException("Der skal være minimum 1 maltbatch knyttet til en destillering.");
        }
        this.maltbatches = new ArrayList<>(maltbatches);

        if (medarbejder == null) {
            throw new IllegalArgumentException("En destillering skal have tilknyttet en medarbejder.");
        }
        this.medarbejder = medarbejder;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getMængdeLiter() {
        return mængdeLiter;
    }

    public boolean isRygemateriale() {
        return rygemateriale;
    }

    public void addMaltbatch(Maltbatch maltbatch) {
        if (!this.maltbatches.contains(maltbatch)) {
            this.maltbatches.add(maltbatch);
        }
    }

    public List<Maltbatch> getMaltbatches() {
        return new ArrayList<>(maltbatches);
    }

    public Medarbejder getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(Medarbejder medarbejder) {
        if (medarbejder == null) {
            throw new IllegalArgumentException("Medarbejder må ikke være null.");
        }
        this.medarbejder = medarbejder;
    }
}