package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    String navn;
    LocalDate startdato;
    LocalDate slutdato;
    Deltager fordragsholder;
    ArrayList<Deltager> tilmeldt;
    ArrayList<Deltager> deltog;
    int pris;
}
