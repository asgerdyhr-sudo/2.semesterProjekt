package modul;

public class Lager {
    private final String navn;
    private final String lokation;
    private final int antalReoler;
    private final int antalHylder;
    private Plads plads;

    public Lager(String navn, String lokation, int antalReoler, int antalHylder, Plads plads) {
        this.navn = navn;
        this.lokation = lokation;
        this.antalReoler = antalReoler;
        this.antalHylder = antalHylder;
        this.plads = plads;
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

    public Plads getPlads() {
        return plads;
    }
}
