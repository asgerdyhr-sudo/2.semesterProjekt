package storage;

import modul.Destillering;
import modul.Kornsort;
import modul.Medarbejder;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Medarbejder> medarbejdere = new ArrayList<>();
    private static final List<Kornsort> kornsorter = new ArrayList<>();
    private static final List<Destillering> destilleringer = new ArrayList<>();

    // Medarbejder
    public static void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    public static List<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    // Kornsort
    public static void addKornsort(Kornsort kornsort) {
        kornsorter.add(kornsort);
    }

    public static List<Kornsort> getKornsorter() {
        return new ArrayList<>(kornsorter);
    }

    // Destillering
    public static void addDestillering(Destillering destillering) {
        destilleringer.add(destillering);
    }

    public static List<Destillering> getDestilleringer() {
        return new ArrayList<>(destilleringer);
    }
}