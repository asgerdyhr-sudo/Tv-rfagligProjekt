package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private final LocalDate dato;
    private final int bestillingsNr;
    private static int antalBestillinger = 0;
    private final Konference konference;
    private final Deltager deltager;
    private final ArrayList<Udflugt> udflugter;
    private Hotel hotel;
    private final ArrayList<Tilvalg> tilvalg;

    Bestilling(LocalDate dato, Deltager deltager, Konference konference) {
        antalBestillinger++;
        bestillingsNr = antalBestillinger;
        this.dato = dato;
        this.konference = konference;
        this.deltager = deltager;
        udflugter = new ArrayList<>();
        tilvalg = new ArrayList<>();
    }

    public int getBestillingsNr() {
        return bestillingsNr;
    }

    public Konference getKonference() {
        return konference;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public double samletPris(Værelse værelse) {
        double sum = 0;

        for (Udflugt udflugt : udflugter) {
            sum += udflugt.getPris();
        }
        for (Tilvalg tilvalg : tilvalg) {
            sum += tilvalg.getPris();
        }

        sum += hotel.getPris(værelse);

        if (deltager.getStatus() != Status.FOREDRAGSHOLDER) {
            sum += konference.getPris();
        }

        return sum;
    }
}
