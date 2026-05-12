package modul;

import java.util.ArrayList;
import java.util.List;

public class Leverandør {
    private final String navn;
    private final String land;

    public Leverandør(String navn, String land) {
        this.navn = navn;
        this.land = land;
    }

    @Override
    public String toString() {
        return "| Navn: " + navn + " - " +
                "Land: " + land + " |";
    }

    public String getNavn() {
        return navn;
    }

    public String getLand() {
        return land;
    }
}