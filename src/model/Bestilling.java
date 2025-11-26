package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Bestilling {
    private final LocalDate ankomstDato;
    private final LocalDate afrejseDato;
    private final int bestillingsNr;
    private static int antalBestillinger = 0;
    private final Konference konference;
    private final Deltager deltager;
    private final ArrayList<Udflugt> udflugter;
    private Hotel hotel;
    private final ArrayList<Tilvalg> tilvalg;

    Bestilling(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference) {
        antalBestillinger++;
        bestillingsNr = antalBestillinger;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.konference = konference;
        this.deltager = deltager;
        udflugter = new ArrayList<>();
        tilvalg = new ArrayList<>();
    }

    public ArrayList<Tilvalg> getTilvalg() {
        return new ArrayList<>(tilvalg);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    private double antalDage() {
        return ChronoUnit.DAYS.between(getAnkomstDato(), getAfrejseDato());
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void addTilvalg(Tilvalg tilvalg) {
        if (!this.tilvalg.contains(tilvalg) && tilvalg != null) {
            this.tilvalg.add(tilvalg);
        }
    }

    public int getBestillingsNr() {
        return bestillingsNr;
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
            sum += tilvalg.getPris() * antalDage();
        }

        sum += hotel.getPris(værelse) * antalDage();

        if (deltager.getStatus() != Status.FOREDRAGSHOLDER) {
            sum += konference.getPris() * antalDage();
        }

        return sum;
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }
}
