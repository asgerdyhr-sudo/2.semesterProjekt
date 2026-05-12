package modul;

public class Hylde {
    private final int hyldeNr;
    private final Reol reol;
    private Fad fad;

    public Hylde(int hyldeNr, Reol reol) {
        this.hyldeNr = hyldeNr;
        this.reol = reol;
    }

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            Fad oldFad = this.fad;
            if (oldFad != null) {
                oldFad.setHylde(null);
            }
            this.fad = fad;
            if (fad != null) {
                fad.setHylde(this);
            }
        }
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

    @Override
    public String toString() {
        return "Hylde " + hyldeNr;
    }
}
