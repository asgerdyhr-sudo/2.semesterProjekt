package storage;

import modul.*;

import java.util.List;

public interface Istorage {

    void addDestillering(Destillering destillering);

    void removeDestillering(Destillering destillering);

    List<Destillering> getAllDestilleringer();

    void addFad(Fad fad);

    void removeFad(Fad fad);

    List<Fad> getAllFad();

    List<Fad> getAllFyldteFad();

    List<Fad> getAlleTommeFad();

    void addLager(Lager lager);

    void removeLager(Lager lager);

    List<Lager> getAllLager();

    void addDestilat(Destillat destillat);

    void removeDestilat(Destillat destillat);

    List<Destillat> getAllDestilat();

    void addMedarbejder(Medarbejder medarbejder);

    void removeMedarbejder(Medarbejder medarbejder);

    List<Medarbejder> getAllMedarbejder();

    void addMængdeDestilat(MængdeDestillat mængdeDestillat);

    void removeMængdeDestilat(MængdeDestillat mængdeDestillat);

    List<MængdeDestillat> getAllMængdeDestilat();

    void addLeverandør(Leverandør leverandør);

    void removeLeverandør(Leverandør leverandør);

    List<Leverandør> getAllLeverandør();

    void addWhiskyProdukt(WhiskyProdukt whiskyProdukt);

    void removeWhiskyProdukt(WhiskyProdukt whiskyProdukt);
}
