package model;

import java.util.ArrayList;

public class Ledsager {
    String navn;
    Deltager deltager;
    ArrayList<Udflugt> udflugter;

    public Ledsager(String navn, Deltager deltager) {
        this.navn = navn;
        this.deltager = deltager;
        udflugter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt) && udflugt != null) {
            udflugter.add(udflugt);
        }
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeLedsager(this);
        }
    }
}
