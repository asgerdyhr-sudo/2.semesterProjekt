package modul;

import java.util.ArrayList;
import java.util.List;

public class Lager {
    private final String navn;
    private final String lokation;
    private final int antalReoler;
    private final int antalHylder;
    private List<Reol> reolList = new ArrayList<>();

    public Lager(String navn, String lokation, int antalReoler, int antalHylder) {
        this.navn = navn;
        this.lokation = lokation;
        this.antalReoler = antalReoler;
        this.antalHylder = antalHylder;
    }

    public Reol createReol(int reolNr) {
        Reol reol = new Reol(reolNr, this);
        reolList.add(reol);
        return reol;
    }

    public void removeReol(Reol reol) {
        if (reolList.contains(reol)) {
            reolList.remove(reol);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getLokation() {
        return lokation;
    }

    public int getAntalReoler() {
        return antalReoler;
    }

    public int getAntalHylder() {
        return antalHylder;
    }

    public List<Reol> getReolList() {
        return reolList;
    }
}
