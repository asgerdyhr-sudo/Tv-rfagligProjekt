package model;

public class Tilvalg {
    private final String navn;
    private final double pris;
    private Hotel hotel;

    Tilvalg(String navn, double pris, Hotel hotel) {
        this.navn = navn;
        this.pris = pris;
        this.hotel = hotel;
    }
    public double getPris() {
        return pris;
    }
    @Override
    public String toString() {
        return navn + " " + pris + "kr.";
    }
}
