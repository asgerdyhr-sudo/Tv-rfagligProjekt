package model;

public class Tilvalg {
    String navn;
    double pris;

    Tilvalg(String navn, double pris, Hotel hotel) {
        this.navn = navn;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }
}
