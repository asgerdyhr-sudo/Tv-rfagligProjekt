package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Udflugt {
    private final String navn;
    private final LocalDate dato;
    private final double pris;
    private final String tourGuide;
    private final ArrayList<Ledsager> ledsagere;
    private final LocalTime tidspunkt;
    private final Konference konference;

    public Udflugt(String navn, LocalDate dato, double pris, String tourGuide, LocalTime tidspunkt, Konference konference) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
        this.konference = konference;
        this.tourGuide = tourGuide;
        this.tidspunkt = tidspunkt;
        ledsagere = new ArrayList<>();
    }

    @Override
    public String toString() {
        return navn + ", D. " + dato + ", Kl: " + tidspunkt +
                " | Guide: " + tourGuide + " | Pris. " + pris + "kr";
    }

    public double getPris() {
        return pris;
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.addUdflugt(this);
        }
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
            ledsager.removeUdflugt(this);
        }
    }
}