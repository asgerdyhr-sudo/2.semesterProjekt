package modul;

import java.time.LocalDate;

public class Destillat {
    private final double alkolholProcent;
    private final LocalDate påfyldningsDato;
    private final String signatur;
    private final MængdeDestillat mængdeDestillat;
    private Fad fad;
    private final Medarbejder medarbejder;

    public Destillat(int alkoholProcent, LocalDate påfyldningsDato, String signatur, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        this.alkolholProcent = alkoholProcent;
        this.påfyldningsDato = påfyldningsDato;
        this.signatur = signatur;
        this.mængdeDestillat = mængdeDestillat;
        this.medarbejder = medarbejder;
    }

    public double getAlkolholProcent() {
        return alkolholProcent;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public String getSignatur() {
        return signatur;
    }

    public MængdeDestillat getMængdeDestillat() {
        return mængdeDestillat;
    }

    public Fad getFad() {
        return fad;
    }

    public Medarbejder getMedarbejder() {
        return medarbejder;
    }
}
