package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    String navn;
    LocalDate startdato;
    LocalDate slutdato;
    ArrayList<String> foredragsholdere;
    ArrayList<Bestilling> bestillinger;
    int pris;

    public Konference(String navn, LocalDate startdato, LocalDate slutdato, int pris) {
        this.navn = navn;
        this.startdato = startdato;
        this.slutdato = slutdato;
        foredragsholdere = new ArrayList<>();
        bestillinger = new ArrayList<>();
        this.pris = pris;
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

    public int getPris() {
        return pris;
    }

    public ArrayList<String> getForedragsholdere() {
        return new ArrayList<>(foredragsholdere);
    }

    public Bestilling createBestilling(LocalDate dato, Deltager deltager, Konference konference) {
        Bestilling bestilling = new Bestilling(dato, deltager, konference);
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
