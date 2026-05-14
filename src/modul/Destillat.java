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
        String info = "Dato: " + påfyldningsDato + " | " + alkoholProcent + "%";

        if (mængdeDestillat != null) {
            info += " | Liter: " + mængdeDestillat.getMængdeLiter();

            if (!mængdeDestillat.getDestilleringList().isEmpty()) {
                Destillering destillering = mængdeDestillat.getDestilleringList().getFirst();
                info += " | Destillering: NM-" + destillering.getNewMakeNr() +
                        ", " + destillering.getKornsort() +
                        ", Maltbatch: " + destillering.getMaltbatch();
            }
        }
        return info;
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
