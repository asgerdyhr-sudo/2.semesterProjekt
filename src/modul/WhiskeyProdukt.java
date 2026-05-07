package modul;

import java.time.LocalDate;

public class WhiskeyProdukt {
    private final int flaskeNummer;
    private final LocalDate tapningsDato;
    private final int volumen;
    private final String navn;
    private final int årgang;
    private final String beskrivelse;
    private Lagring lagring;

    public WhiskeyProdukt(int flaskeNummer, LocalDate tapningsDato, int volumen, String navn, int årgang, String beskrivelse) {
        this.flaskeNummer = flaskeNummer;
        this.tapningsDato = tapningsDato;
        this.volumen = volumen;
        this.navn = navn;
        this.årgang = årgang;
        this.beskrivelse = beskrivelse;
    }

    public int getFlaskeNummer() {
        return flaskeNummer;
    }

    public LocalDate getTapningsDato() {
        return tapningsDato;
    }

    public int getVolumen() {
        return volumen;
    }

    public String getNavn() {
        return navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public Lagring getLagring() {
        return lagring;
    }
}
