package modul;

public class Plads {
    private final int pladsNummer;
    private final int reol;
    private boolean ledig;
    private Fad fad;

    public Plads(int pladsNummer, int reol, boolean ledig, Fad fad) {
        this.pladsNummer = pladsNummer;
        this.reol = reol;
        this.ledig = ledig;
        this.fad = fad;
    }

    public int getPladsNummer() {
        return pladsNummer;
    }

    public int getReol() {
        return reol;
    }

    public boolean isLedig() {
        return ledig;
    }

    public Fad getFad() {
        return fad;
    }
}
