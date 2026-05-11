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

    public Fad(int fadNr, String fadType, int størrelseLiter, String tidligereIndhold, Leverandør leverandør) {
        this.fadNr = fadNr;
        this.fadType = fadType;
        this.størrelseLiter = størrelseLiter;
        this.tidligereIndhold = tidligereIndhold;
        this.leverandør = leverandør;
    }

    public void addDestilat (Destillat destillat){
        if (!destilatList.contains(destillat)){
            destilatList.add(destillat);
        }
    }

    public void removeDestilat (Destillat destillat){
        if (destilatList.contains(destillat)){
            destilatList.remove(destillat);
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
