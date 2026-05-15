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
        // Når en hylde får et fad, skal fadet også pege tilbage på den hylde.
        // Når et fad fjernes, skal begge sider også opdateres.
        if (this.fad != fad) {
            // Gem det gamle fad, så vi kan fjerne koblingen fra den gamle side.
            Fad oldFad = this.fad;
            // Hvis hylden før havde et fad, så skal det gamle fad ikke længere pege på denne hylde.
            // Vi fjerner derfor koblingen fra fadets side.
            if (oldFad != null) {
                oldFad.setHylde(null);
            }
            // Opdater hyldens reference til fadet.
            this.fad = fad;
            // Hvis der sættes et nyt fad på hylden, skal fadet også opdateres,
            // så fadet peger tilbage på denne hylde.
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
