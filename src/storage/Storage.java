package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();

    public static void addKonference(Konference konference) {
        if (!konferencer.contains(konference)) {
            konferencer.add(konference);
        }
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
        }
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<Hotel>(hoteller);
    }

}
