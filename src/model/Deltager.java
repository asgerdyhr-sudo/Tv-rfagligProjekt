package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager {
    private final String navn;
    private final String adresse;
    private final String by;
    private String firmanavn;
    private final Status status;
    private final String telefon;
    private String firmatelefon;
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Deltager(String navn, String adresse, String by, Status status, String telefon) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.status = status;
        this.telefon = telefon;
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

    public String getTelefon() {
        return telefon;
    }

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn, this);
        ledsagere.add(ledsager);
        return ledsager;
    }
}