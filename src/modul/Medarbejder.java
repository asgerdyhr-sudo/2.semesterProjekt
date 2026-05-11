package modul;

public class Medarbejder {
    private final String navn;
    private final String mobil;
    private final String initialer;

    public Medarbejder(String navn, String mobil, String initialer) {
        this.navn = navn;
        this.mobil = mobil;
        this.initialer = initialer;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getInitialer() {
        return initialer;
    }
}
