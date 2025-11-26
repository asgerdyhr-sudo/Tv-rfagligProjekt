package model;

import java.util.ArrayList;

public class Hotel {
    private final String navn;
    private final double prisEnkel;
    private final double prisDobbelt;
    private final ArrayList<Tilvalg> tilvalgListe;

    public Hotel(String navn, double prisEnkel, double prisDobbelt) {
        this.navn = navn;
        this.prisEnkel = prisEnkel;
        this.prisDobbelt = prisDobbelt;
        tilvalgListe = new ArrayList<>();
    }

    @Override
    public String toString() {
        return navn + " | Pris enkel værelse: " + prisEnkel + " | pris dobbelt værelse: " + prisDobbelt;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris(Værelse værelse) {
        if (værelse == Værelse.ENKELT) {
            return prisEnkel;
        }
        return prisDobbelt;
    }

    public ArrayList<Tilvalg> getTilvalg() {
        return new ArrayList<>(tilvalgListe);
    }

    public Tilvalg createTilvalg(String navn, double pris, Hotel hotel){
        Tilvalg tilvalg = new Tilvalg(navn, pris, hotel);
        tilvalgListe.add(tilvalg);
        return tilvalg;
    }
}