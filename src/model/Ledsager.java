package model;

import java.util.ArrayList;

public class Ledsager {
    private final String navn;
    private final Deltager deltager;
    private final ArrayList<Udflugt> udflugter;

    Ledsager(String navn, Deltager deltager) {
        this.navn = navn;
        this.deltager = deltager;
        udflugter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  navn;
    }

    public String udskrift() {
        return navn + " (" + deltager.getNavn() + " " + deltager.getTelefon() + ") ";
    }

    public String getNavn() {
        return navn;
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt) && udflugt != null) {
            udflugter.add(udflugt);
            udflugt.addLedsager(this);
        }
    }
    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeLedsager(this);
        }
    }
}
