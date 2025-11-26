package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager {
    String navn;
    String adresse;
    String by;
    LocalDate ankomstdato;
    String firmanavn;
    Status status;
    int telefon;
    LocalDate afrejsedato;
    int firmatelefon;
    ArrayList<Bestilling> bestillinger = new ArrayList<>();
    ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Deltager(String navn, String adresse, String by, LocalDate ankomstdato, Status status, int telefon, LocalDate afrejsedato) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.ankomstdato = ankomstdato;
        this.status = status;
        this.telefon = telefon;
        this.afrejsedato = afrejsedato;
    }

    @Override
    public String toString() {
        String retur;

        retur = "Navn: " + navn + '\n' +
                "Adresse: " + adresse + '\n' +
                "By: " + by + '\n' +
                "Telefon: " + telefon + '\n' +
                "Status: " + status + '\n';
        if (firmanavn != null && !firmanavn.isEmpty() && firmatelefon != null && !firmatelefon.isEmpty()) {
            retur += "Firmanavn: " + firmanavn + '\n' +
                    "Firmatelefon: " + firmatelefon + '\n';
        }
        if (!ledsagere.isEmpty()) {
            retur += "Ledsagere navn: " + ledsagere + '\n';
        }

        return retur;
    }

    public void setFirmanavn(String navn) {
        firmanavn = navn;
    }

    public void setFirmatelefon(String telefon) {
        firmatelefon = telefon;
    }

    public String getNavn() {
        return navn;
    }

    public Status getStatus() {
        return status;
    }

    public int getTelefon() {
        return telefon;
    }

    public LocalDate getAfrejsedato() {
        return afrejsedato;
    }

    public int getFirmatelefon() {
        return firmatelefon;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn, this);
        ledsagere.add(ledsager);
        return ledsager;
    }


    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
    }
}