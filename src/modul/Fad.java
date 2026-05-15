package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fad {
    private static int antalFade = 0;

    private final int fadNr;
    private final String fadType;
    private final int størrelseLiter;
    private final String tidligereIndhold;
    private List<Destillat> destilatList = new ArrayList<>();
    private Hylde hylde;
    private final Leverandør leverandør;

    public Fad(String fadType, int størrelseLiter, String tidligereIndhold, Leverandør leverandør) {
        antalFade++;

        if (fadType == null || fadType.isBlank()) {
            throw new IllegalArgumentException("Fadtypen skal være angivet");
        }
        if (størrelseLiter <= 0) {
            throw new IllegalArgumentException("Fadets størrelse kan ikke være 0 L eller negativt");
        }
        if (tidligereIndhold == null || tidligereIndhold.isBlank()) {
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

    public boolean klarTilTapning() {
        for (Destillat destillat : destilatList) {
            if (destillat.klarTilAftapning()) {
                return true;
            }
        }
        return false;
    }

    public void setHylde(Hylde hylde) {
        // Hvis fadet flyttes til en ny hylde, skal den gamle hylde frigøres og den nye hylde skal pege på fadet.
        if (this.hylde != hylde) {
            // Gem den gamle hylde, så vi kan rydde den, hvis fadet flyttes væk.
            Hylde oldHylde = this.hylde;
            // Hvis fadet før lå på en hylde, så skal den hylde ikke længere pege på fadet.
            // Vi fjerner koblingen fra hyldens side.
            if (oldHylde != null) {
                oldHylde.setFad(null);
            }
            // Opdater fadets reference til hylden.
            this.hylde = hylde;
            // Hvis der sættes en ny hylde (ikke null), skal hylden også opdateres,
            // så den peger tilbage på dette fad.
            if (hylde != null) {
                hylde.setFad(this);
            }
        }
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

    @Override
    public String toString() {
        return "| Fad " + fadNr + " (" + fadType + " - " + størrelseLiter + "L)";
    }
}
