package modul;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lagring {
    private final LocalDate startDato;
    private final LocalDate slutDato;
    private final int mængdeVedStart;
    private final int spild;
    private Destilat destilat;
    private Fad fad;
    private ArrayList<WhiskeyProdukt> whiskeyProduktArrayList = new ArrayList<>();

    public Lagring(LocalDate startDato, LocalDate slutDato, int mængdeVedStart, int spild) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.mængdeVedStart = mængdeVedStart;
        this.spild = spild;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public int getMængdeVedStart() {
        return mængdeVedStart;
    }

    public int getSpild() {
        return spild;
    }

    public Destilat getDestilat() {
        return destilat;
    }

    public Fad getFad() {
        return fad;
    }

    public ArrayList<WhiskeyProdukt> getWhiskeyProduktArrayList() {
        return whiskeyProduktArrayList;
    }
}
