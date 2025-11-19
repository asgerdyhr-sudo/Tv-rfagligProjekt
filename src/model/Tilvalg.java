package model;

public class Tilvalg {
    String navn;
    double pris;

    public Tilvalg(String navn, double pris) {
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
