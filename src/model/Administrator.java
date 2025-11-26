package model;

public class Administrator {
    private String name;
    private int idNr;

    public Administrator(String name, int idNr) {
        this.name = name;
        this.idNr = idNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNr() {
        return idNr;
    }

    public void setIdNr(int idNr) {
        this.idNr = idNr;
    }
}
