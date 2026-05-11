package modul;

public class Hylde {
    private final int hyldeNr;
    private final Reol reol;
    private Fad fad;

    public Hylde(int hyldeNr, Reol reol) {
        this.hyldeNr = hyldeNr;
        this.reol = reol;
    }

    public int getHyldeNr() {
        return hyldeNr;
    }

    public Reol getReol() {
        return reol;
    }

    public Fad getFad() {
        return fad;
    }
}
