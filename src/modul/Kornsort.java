package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kornsort {
    private final String navn;
    private final String ophav;
    private final String beskrivelse;
    private final List<Maltbatch> maltbatches = new ArrayList<>();

    public Kornsort(String navn, String ophav, String beskrivelse) {
        this.navn = navn;
        this.ophav = ophav;
        this.beskrivelse = beskrivelse;
    }

    public String getNavn() {
        return navn;
    }

    public String getOphav() {
        return ophav;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public Maltbatch createMaltbatch(int batchNummer, LocalDate dato, int mængdeKg) {
        Maltbatch maltbatch = new Maltbatch(batchNummer, dato, mængdeKg);
        this.maltbatches.add(maltbatch);
        return maltbatch;
    }

    public void removeMaltbatch(Maltbatch maltbatch) {
        this.maltbatches.remove(maltbatch);
    }

    public List<Maltbatch> getMaltbatches() {
        return new ArrayList<>(maltbatches);
    }
}