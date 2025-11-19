package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Udflugter {
    String navn;
    LocalDate dato;
    int pris;
    String tourGuide;
    ArrayList<Ledsager> ledsagere;
    LocalTime tidspunkt;
}
