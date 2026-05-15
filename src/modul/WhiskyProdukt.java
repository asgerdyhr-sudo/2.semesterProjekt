package modul;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WhiskyProdukt {
    private final String navn;
    private final double alkoholProcent;
    private final String whiskyType;
    private final String beskrivelse;
    private final Destillat destillat;
    private final List<Flaske> flaskeList = new ArrayList<>();

    public WhiskyProdukt(String navn, double alkoholProcent, String whiskyType, String beskrivelse, Destillat destillat) {
        this.navn = navn;
        this.alkoholProcent = alkoholProcent;
        this.whiskyType = whiskyType;
        this.beskrivelse = beskrivelse;
        this.destillat = destillat;
    }

    public String getNavn() {
        return navn;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    //Her kan Whiskytype beregnes
    public String getWhiskyType() {
        return whiskyType;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public ArrayList<Flaske> getFlaskeList() {
        return new ArrayList<>(flaskeList);
    }

    public void removeFlaske(Flaske flaske) {
        if (flaskeList.contains(flaske)) {
            flaskeList.remove(flaske);
        }
    }

    //Opretter det givne antal Flaske-objekter
    public List<Flaske> createFlasker(LocalDate tapningsDato, double volumen, Status status) {
        List<Flaske> flasker = new ArrayList<>();
        int antal = beregnAntalFlasker(volumen);
        for (int i = 1; i <= antal; i++) {
            Flaske flaske = new Flaske(i, tapningsDato, volumen, status, this);
            flasker.add(flaske);
            flaskeList.add(flaske);
        }
        return flasker;
    }

    private int beregnAntalFlasker(double volumenPrFlaske) {
        return (int) (this.getMængdeLiter()/volumenPrFlaske);
    }

    private double getMængdeLiter(){
        return destillat.getMængdeLiter();
    }

    public Destillat getDestillat() {
        return destillat;
    }
}
