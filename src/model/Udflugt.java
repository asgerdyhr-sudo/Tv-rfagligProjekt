package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Udflugt {
    String navn;
    LocalDate dato;
    int pris;
    String tourGuide;
    ArrayList<Ledsager> ledsagere;
    LocalTime tidspunkt;

    public Udflugt(String navn, LocalDate dato, int pris, String tourGuide, LocalTime tidspunkt) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
        this.tourGuide = tourGuide;
        this.tidspunkt = tidspunkt;
        ledsagere = new ArrayList<>(ledsagere);
    }

    public int getPris() {
        return pris;
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
        }
    }

    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
            ledsager.removeUdflugt(this);
        }
    }
}
