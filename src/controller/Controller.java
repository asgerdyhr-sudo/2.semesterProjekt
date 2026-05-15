package controller;

import modul.*;
import storage.Istorage;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    Istorage storage;

    public Controller(Istorage storage) {
        this.storage = storage;
    }

    public Destillering createDestillering(LocalDate dato, double alkoholProcent, int newMakeNr, String maltbatch, String rygemateriale, Kornsort kornsort, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        Destillering destillering = new Destillering(dato, alkoholProcent, newMakeNr, maltbatch, rygemateriale, kornsort, mængdeDestillat, medarbejder);
        storage.addDestillering(destillering);
        return destillering;
    }

    public Fad createFad(String fadType, int størrelseLiter, String tidligereIndhold, Leverandør leverandør) {
        Fad fad = new Fad(fadType, størrelseLiter, tidligereIndhold, leverandør);
        storage.addFad(fad);
        return fad;
    }

    public Lager createLager(String navn, String lokation, int antalReoler, int antalHylder) {
        Lager lager = new Lager(navn, lokation, antalReoler, antalHylder);
        storage.addLager(lager);
        return lager;
    }

    public Destillat createDestillat(double alkolholProcent, LocalDate påfyldningsDato, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        Destillat destillat = new Destillat(alkolholProcent, påfyldningsDato, mængdeDestillat, medarbejder);
        storage.addDestilat(destillat);
        return destillat;
    }

    public Medarbejder createMedarbejder(String navn, String mobil, String initialer) {
        Medarbejder medarbejder = new Medarbejder(navn, mobil, initialer);
        storage.addMedarbejder(medarbejder);
        return medarbejder;
    }

    public MængdeDestillat createMængdeDestillat(double mængdeLiter) {
        MængdeDestillat mængdeDestillat = new MængdeDestillat(mængdeLiter);
        storage.addMængdeDestilat(mængdeDestillat);
        return mængdeDestillat;
    }

    public Leverandør createLeverandør(String navn, String land) {
        Leverandør leverandør = new Leverandør(navn, land);
        storage.addLeverandør(leverandør);
        return leverandør;
    }

    public WhiskyProdukt createWhiskyProdukt(String navn, double alkoholProcent, String whiskyType, String beskrivelse, Destillat destillat) {
        WhiskyProdukt whiskyProdukt = new WhiskyProdukt(navn, alkoholProcent, whiskyType, beskrivelse, destillat);
        storage.addWhiskyProdukt(whiskyProdukt);
        return whiskyProdukt;
    }

    public List<Medarbejder> getAllMedarbejder() {
        return storage.getAllMedarbejder();
    }

    public List<Leverandør> getAllLeverandør() {
        return storage.getAllLeverandør();
    }

    public List<Lager> getAllLager() {
        return storage.getAllLager();
    }

    public List<Fad> getAllFad() {
        return storage.getAllFad();
    }

    public List<Destillat> getAllDestillat() {
        return storage.getAllDestilat();
    }

    public List<Destillering> getAllDestillering(){return storage.getAllDestilleringer();}

    public void registerFadPlacering(Fad fad, Hylde hylde) {
        if (hylde.getFad() != null) {
            throw new IllegalArgumentException("Hylden er allerede optaget af et andet fad.");
        }
        fad.setHylde(hylde);
    }

    public void registrerPåfyldning(Destillat destillat, Fad fad) {
        destillat.setFad(fad);
    }

    public void createSomeObjects() {
        Medarbejder m1 = createMedarbejder("Mads Madsen", "11223344", "MM");
        createMedarbejder("Jens Jensen", "22334455", "JJ");
        createMedarbejder("Hanne Hansen", "33445566", "HH");
        createMedarbejder("Sofie Sørensen", "44556677", "SS");

        Leverandør l1 = createLeverandør("Pedro Barrels", "Spanien");
        createLeverandør("Francois Tonneaux", "Frankrig");
        createLeverandør("Scottish Cask Co.", "Skotland");
        createLeverandør("American Oak Inc.", "USA");

        MængdeDestillat md1 = createMængdeDestillat(500.0);
        createDestillering(LocalDate.of(2019,2,12), 65.0, 1, "MaltBatch1", "ingen", Kornsort.STAIRWAY, md1, m1);
        createDestillat(63.5, LocalDate.of(2024,12,20), md1, m1);

        createFad("Egetræ", 250, "Sherry", l1);
        createFad("Bark", 500, "Burbon", l1);

        createLager("Hovedlager", "Bygning A", 5, 10);
        createLager("Ekstra lager", "Gårdspladsen", 5, 10);
    }
}