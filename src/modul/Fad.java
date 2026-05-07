package modul;

public class Fad {
    private final int fadNummer;
    private final String fadType;
    private final int størelseLiter;
    private final String tidligereIndhold;
    private final String leverandør;
    private Lagring lagring;
    private Plads plads;

    public Fad(int fadNummer, String fadType, int størelseLiter, String tidligereIndhold, String leverandør) {
        this.fadNummer = fadNummer;
        this.fadType = fadType;
        this.størelseLiter = størelseLiter;
        this.tidligereIndhold = tidligereIndhold;
        this.leverandør = leverandør;
    }

    public int getFadNummer() {
        return fadNummer;
    }

    public String getFadType() {
        return fadType;
    }

    public int getStørelseLiter() {
        return størelseLiter;
    }

    public String getTidligereIndhold() {
        return tidligereIndhold;
    }

    public String getLeverandør() {
        return leverandør;
    }

    public Lagring getLagring() {
        return lagring;
    }

    public Plads getPlads() {
        return plads;
    }
}
