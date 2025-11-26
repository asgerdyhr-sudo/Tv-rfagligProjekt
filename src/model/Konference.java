package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Konference {
    private final String navn;
    private final LocalDate startdato;
    private final LocalDate slutdato;
    private final double pris;
    private final ArrayList<String> foredragsholdere;
    private final ArrayList<Bestilling> bestillinger;
    private final ArrayList<Hotel> hoteller;
    private final ArrayList<Udflugt> udflugter;

    public Konference(String navn, LocalDate startdato, LocalDate slutdato, double pris) {
        this.navn = navn;
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.pris = pris;
        foredragsholdere = new ArrayList<>();
        bestillinger = new ArrayList<>();
        hoteller = new ArrayList<>();
        udflugter = new ArrayList<>();
    }

    @Override
    public String toString() {
        String foredragsholdereString = "";
        for (String foredragsholder : foredragsholdere) {
            foredragsholdereString += foredragsholder + ", ";
        }

        return navn + ", fra " + startdato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " til " + slutdato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | " + pris + "kr \n Fordragsholder(e):" + foredragsholdereString;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public double getPris() {
        return pris;
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Udflugt createUdflugt(String navn, LocalDate dato, double pris, String tourGuide, LocalTime tidspunkt, Konference konference) {
        Udflugt udflugt = new Udflugt(navn, dato, pris, tourGuide, tidspunkt, this);
        udflugter.add(udflugt);
        return udflugt;
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }

    public Bestilling createBestilling(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference) {
        Bestilling bestilling = new Bestilling(ankomstDato, afrejseDato, deltager, konference);
        bestillinger.add(bestilling);
        return bestilling;
    }

    public void removeBestilling(Bestilling bestilling) {
        if (bestillinger.contains(bestilling)) {
            bestillinger.remove(bestilling);
        }
    }

    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
    }

    public void addForedragsholder(String foredragsholder) {
        if (!foredragsholdere.contains(foredragsholder)) {
            foredragsholdere.add(foredragsholder);
        }
    }

    public void removeForedragsholder(String foredragsholder) {
        if (foredragsholdere.contains(foredragsholder)) {
            foredragsholdere.remove(foredragsholder);
        }
    }
}