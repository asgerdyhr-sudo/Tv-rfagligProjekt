package model;

public class Hotel {
    String navn;
    double prisEnkel;
    double prisDobbelt;

    public Hotel(String navn, double prisEnkel, double prisDobbelt) {
        this.navn = navn;
        this.prisEnkel = prisEnkel;
        this.prisDobbelt = prisDobbelt;
    }

    public double getPris(Værelse værelse) {
        if (værelse == Værelse.ENKELT) {
            return prisEnkel;
        }
        return prisDobbelt;
    }
}