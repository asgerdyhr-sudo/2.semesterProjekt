package modul;

import java.util.ArrayList;
import java.util.List;

public class MængdeDestillat {
    private final double mængdeLiter;
    private List<Destillat> destillatList = new ArrayList<>();
    private List<Destillering> destilleringList = new ArrayList<>();

    public MængdeDestillat(double mængdeLiter) {
        this.mængdeLiter = mængdeLiter;
    }

    @Override
    public String toString() {
        return mængdeLiter + "L";
    }

    public void addDestillat (Destillat destillat){
        if (!destillatList.contains(destillat)){
            destillatList.add(destillat);
        }
    }

    public void removeDestillat (Destillat destillat){
        if (destillatList.contains(destillat)){
            destillatList.remove(destillat);
        }
    }

    public void addDestillering (Destillering destillering){
        if (!destilleringList.contains(destillering)){
            destilleringList.add(destillering);
        }
    }

    public void removeDestillering (Destillering destillering){
        if (destilleringList.contains(destillering)){
            destilleringList.remove(destillering);
        }
    }

    public double getMængdeLiter() {
        return mængdeLiter;
    }

    public List<Destillat> getDestillatList() {
        return new ArrayList<>(destillatList);
    }

    public List<Destillering> getDestilleringList() {
        return new ArrayList<>(destilleringList);
    }
}
