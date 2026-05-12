package controller;

import modul.*;
import storage.Istorage;
import storage.Storage;

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

    public Destillat createDestillat(int alkolholProcent, LocalDate påfyldningsDato, String signatur, MængdeDestillat mængdeDestillat, Medarbejder medarbejder) {
        Destillat destillat = new Destillat(alkolholProcent, påfyldningsDato, signatur, mængdeDestillat, medarbejder);
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

    public Leverandør createLeverandør (String navn, String land){
        Leverandør leverandør = new Leverandør(navn, land);
        storage.addLeverandør(leverandør);
        return leverandør;
    }

    public List<Medarbejder> getAllMedarbejder(){
        return storage.getAllMedarbejder();
    }



    public void createSomeObject(){
        createMedarbejder("Mads Madsen", "11223344", "MM");
        createMedarbejder("Jens Jensen", "22334455", "JJ");
        createMedarbejder("Hanne Hansen", "33445566", "HH");
        createMedarbejder("Sofie Sørensen", "44556677", "SS");
    }
}