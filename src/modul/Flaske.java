package modul;

import java.time.LocalDate;

public class Flaske {
    private final int flaskeNr;
    private final LocalDate tapningsDato;
    private final double volumen;
    private Status status;
    private final WhiskyProdukt whiskyProdukt;

    public Flaske(int flaskeNr, LocalDate tapningsDato, double volumen, Status status, WhiskyProdukt whiskyProdukt) {
        this.flaskeNr = flaskeNr;
        this.tapningsDato = tapningsDato;
        this.volumen = volumen;
        this.status = status;
        this.whiskyProdukt = whiskyProdukt;
    }

    public int getFlaskeNr() {
        return flaskeNr;
    }

    public LocalDate getTapningsDato() {
        return tapningsDato;
    }

    public double getVolumen() {
        return volumen;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public WhiskyProdukt getWhiskyProdukt() {
        return whiskyProdukt;
    }
}
