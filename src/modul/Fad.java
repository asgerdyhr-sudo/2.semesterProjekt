package modul;

import java.util.ArrayList;
import java.util.List;

public class Fad {
    private final int fadNr;
    private final String fadType;
    private final int størrelseLiter;
    private final String tidligereIndhold;
    private List<Destillat> destilatList = new ArrayList<>();
    private Hylde hylde;
    private final Leverandør leverandør;

    public Fad(String fadType, int størrelseLiter, String tidligereIndhold, Leverandør leverandør) {
        int antalFade = 0;
        antalFade++;

        if (fadType == null) {
            throw new IllegalArgumentException("Fadtypen skal være angivet");
        }
        if (størrelseLiter <= 0) {
            throw new IllegalArgumentException("Fadets størrelse kan ikke være 0 L eller negativt");
        }
        if (tidligereIndhold == null) {
            throw new IllegalArgumentException("Tidligere indhold skal vøære angivet");
        }
        if (leverandør == null) {
            throw new IllegalArgumentException("Leverandør skal være angivet");
        }

        this.fadNr = antalFade;
        this.fadType = fadType;
        this.størrelseLiter = størrelseLiter;
        this.tidligereIndhold = tidligereIndhold;
        this.leverandør = leverandør;
    }

    public void addDestilat(Destillat destillat) {
        if (!destilatList.contains(destillat)) {
            destilatList.add(destillat);
            destillat.setFad(this);
        }
    }

    public void removeDestilat(Destillat destillat) {
        if (destilatList.contains(destillat)) {
            destilatList.remove(destillat);
            destillat.setFad(null);
        }

    }

    public int getFadNr() {
        return fadNr;
    }

    public String getFadType() {
        return fadType;
    }

    public int getStørrelseLiter() {
        return størrelseLiter;
    }

    public String getTidligereIndhold() {
        return tidligereIndhold;
    }

    public List<Destillat> getDestilatList() {
        return new ArrayList<>(destilatList);
    }

    public Hylde getHylde() {
        return hylde;
    }

    public Leverandør getLeverandør() {
        return leverandør;
    }
}
