package storage;

import com.sun.javafx.collections.ElementObservableListDecorator;
import modul.*;

import java.util.ArrayList;
import java.util.List;

public class Storage implements Istorage {
    List<Destillering> destilleringList = new ArrayList<>();
    List<Fad> fadList = new ArrayList<>();
    List<Lager> lagerList = new ArrayList<>();
    List<Destillat> destillatList = new ArrayList<>();
    List<Medarbejder> medarbejderList = new ArrayList<>();
    List<MængdeDestillat> mængdeDestillatList = new ArrayList<>();
    List<Leverandør> leverandørList = new ArrayList<>();
    List<WhiskyProdukt> whiskyProduktList = new ArrayList<>();

    @Override
    public void addDestillering(Destillering destillering) {
        if (!destilleringList.contains(destillering)) {
            destilleringList.add(destillering);
        }
    }

    @Override
    public void removeDestillering(Destillering destillering) {
        if (destilleringList.contains(destillering)) {
            destilleringList.remove(destillering);
        }
    }

    @Override
    public List<Destillering> getAllDestilleringer() {
        return destilleringList;
    }

    @Override
    public void addFad(Fad fad) {
        if (!fadList.contains(fad)) {
            fadList.add(fad);
        }
    }

    @Override
    public void removeFad(Fad fad) {
        if (fadList.contains(fad)) {
            fadList.remove(fad);
        }
    }

    @Override
    public List<Fad> getAllFad() {
        return fadList;
    }

    @Override
    public List<Fad> getAllFyldteFad() {
        List<Fad> temp = new ArrayList<>();
        for (Fad fad : fadList) {
            if (!fad.getDestilatList().isEmpty()) {
                temp.add(fad);
            }
        }
        return temp;
    }

    @Override
    public List<Fad> getAlleTommeFad() {
        List<Fad> temp = new ArrayList<>();
        for (Fad fad : fadList) {
            if (fad.getDestilatList().isEmpty()) {
                temp.add(fad);
            }
        }
        return temp;
    }

    @Override
    public void addLager(Lager lager) {
        if (!lagerList.contains(lager)) {
            lagerList.add(lager);
        }
    }

    @Override
    public void removeLager(Lager lager) {
        if (lagerList.contains(lager)) {
            lagerList.remove(lager);
        }
    }

    @Override
    public List<Lager> getAllLager() {
        return lagerList;
    }

    @Override
    public void addDestilat(Destillat destillat) {
        if (!destillatList.contains(destillat)) {
            destillatList.add(destillat);
        }
    }

    @Override
    public void removeDestilat(Destillat destillat) {
        if (destillatList.contains(destillat)) {
            destillatList.remove(destillat);
        }
    }

    @Override
    public List<Destillat> getAllDestilat() {
        return destillatList;
    }

    @Override
    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejderList.contains(medarbejder)) {
            medarbejderList.add(medarbejder);
        }
    }

    @Override
    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejderList.contains(medarbejder)) {
            medarbejderList.add(medarbejder);
        }
    }

    @Override
    public List<Medarbejder> getAllMedarbejder() {
        return medarbejderList;
    }

    @Override
    public void addMængdeDestilat(MængdeDestillat mængdeDestillat) {
        if (!mængdeDestillatList.contains(mængdeDestillat)) {
            mængdeDestillatList.add(mængdeDestillat);
        }
    }

    @Override
    public void removeMængdeDestilat(MængdeDestillat mængdeDestillat) {
        if (mængdeDestillatList.contains(mængdeDestillat)) {
            mængdeDestillatList.remove(mængdeDestillat);
        }
    }

    @Override
    public List<MængdeDestillat> getAllMængdeDestilat() {
        return mængdeDestillatList;
    }

    @Override
    public void addLeverandør(Leverandør leverandør) {
        if (!leverandørList.contains(leverandør)) {
            leverandørList.add(leverandør);
        }
    }

    @Override
    public void removeLeverandør(Leverandør leverandør) {
        if (leverandørList.contains(leverandør)) {
            leverandørList.remove(leverandør);
        }
    }

    @Override
    public List<Leverandør> getAllLeverandør() {
        return leverandørList;
    }

    @Override
    public void addWhiskyProdukt(WhiskyProdukt whiskyProdukt) {
        if (!whiskyProduktList.contains(whiskyProdukt)) {
            whiskyProduktList.add(whiskyProdukt);
        }
    }

    @Override
    public void removeWhiskyProdukt(WhiskyProdukt whiskyProdukt) {
        if (whiskyProduktList.contains(whiskyProdukt)) {
            whiskyProduktList.remove(whiskyProdukt);
        }
    }
}