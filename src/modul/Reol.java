package modul;

import java.util.ArrayList;
import java.util.List;

public class Reol {
    private final int reolNr;
    private final List<Hylde> hyldeList = new ArrayList<>();
    private final Lager lager;

    public Reol(int reolNr, Lager lager) {
        this.reolNr = reolNr;
        this.lager = lager;
    }

    public Hylde createHylde(int hyldeNr) {
        Hylde hylde = new Hylde(hyldeNr, this);
        hyldeList.add(hylde);
        return hylde;
    }

    public void removeHylde(Hylde hylde) {
        if (hyldeList.contains(hylde)) {
            hyldeList.remove(hylde);
        }
    }

    public int getReolNr() {
        return reolNr;
    }

    public List<Hylde> getHyldeList() {
        return hyldeList;
    }

    public Lager getLager() {
        return lager;
    }
}
