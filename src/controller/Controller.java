package controller;

import modul.Destillering;
import modul.Kornsort;
import modul.Maltbatch;
import modul.Medarbejder;
import storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    public static Medarbejder createMedarbejder(String navn, String mobil, String initialer) {
        Medarbejder medarbejder = new Medarbejder(navn, mobil, initialer);
        Storage.addMedarbejder(medarbejder);
        return medarbejder;
    }

    public static List<Medarbejder> getMedarbejdere() {
        return Storage.getMedarbejdere();
    }

    public static Kornsort createKornsort(String navn, String ophav, String beskrivelse) {
        Kornsort kornsort = new Kornsort(navn, ophav, beskrivelse);
        Storage.addKornsort(kornsort);
        return kornsort;
    }

    public static List<Kornsort> getKornsorter() {
        return Storage.getKornsorter();
    }

    // Maltbatch oprettes igennem Kornsort på grund af komposition
    public static Maltbatch createMaltbatchForKornsort(Kornsort kornsort, int batchNummer, LocalDate dato, int mængdeKg) {
        return kornsort.createMaltbatch(batchNummer, dato, mængdeKg);
    }

    public static Destillering createDestillering(LocalDate dato, int mængdeLiter, boolean rygemateriale, List<Maltbatch> maltbatches, Medarbejder medarbejder) {
        Destillering destillering = new Destillering(dato, mængdeLiter, rygemateriale, maltbatches, medarbejder);
        Storage.addDestillering(destillering);
        return destillering;
    }

    public static List<Destillering> getDestilleringer() {
        return Storage.getDestilleringer();
    }
}