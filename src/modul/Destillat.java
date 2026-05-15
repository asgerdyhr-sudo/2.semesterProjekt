package modul;

import java.time.LocalDate;

public class Destillat {
    private final double alkoholProcent;
    private final LocalDate påfyldningsDato;
    private final MængdeDestillat mængdeDestillat;
    private Fad fad;
    private final Medarbejder medarbejder;

    public Destillat(double alkoholProcent, LocalDate påfyldningsDato, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        this.alkoholProcent = alkoholProcent;
        this.påfyldningsDato = påfyldningsDato;
        this.mængdeDestillat = mængdeDestillat;
        if (mængdeDestillat != null) {
            mængdeDestillat.addDestillat(this);
        }
        this.medarbejder = medarbejder;
    }

    @Override
    public String toString() {
        String liter = (mængdeDestillat != null) ? mængdeDestillat.getMængdeLiter() + " L" : "Ukendt mængde";
        String destilleringInfo = "";

        if (mængdeDestillat != null && !mængdeDestillat.getDestilleringList().isEmpty()) {
            Destillering d = mængdeDestillat.getDestilleringList().getFirst();
            destilleringInfo = " | NM-" + d.getNewMakeNr() + ", " + d.getKornsort() + ", Batch: " + d.getMaltbatch();
        }

        return "Destillat | Dato: " + påfyldningsDato + " | Alkohol: " + alkoholProcent + "% | Mængde: " + liter + destilleringInfo;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
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

    //Ikke triviel metode 1
    public void setFad(Fad fad) {
        if (this.fad != fad) {
            Fad oldFad = this.fad;
            if (oldFad != null) {
                oldFad.removeDestilat(this);
            }
            this.fad = fad;
            if (fad != null) {
                fad.addDestilat(this);
            }
        }
    }
}
