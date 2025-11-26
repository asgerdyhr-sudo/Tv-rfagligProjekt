package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {
    public static Konference createKonference(String navn, LocalDate startdato, LocalDate slutdato, int prisPrDag) {
        Konference konference = new Konference(navn, startdato, slutdato, prisPrDag);
        Storage.addKonference(konference);
        return konference;
    }

    public static Deltager createDeltager(String navn, String adresse, String by, Status status, String telefon) {
        Deltager deltager = new Deltager(navn, adresse, by, status, telefon);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Bestilling createBestilling(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference) {
        Bestilling bestilling = konference.createBestilling(ankomstDato, afrejseDato, deltager, konference);
        return bestilling;
    }

    public static Hotel createHotel(String navn, double prisEnkel, double prisDobbelt) {
        Hotel hotel = new Hotel(navn, prisEnkel, prisDobbelt);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Tilvalg createTilvalg(String navn, double pris, Hotel hotel) {
        Tilvalg tilvalg = hotel.createTilvalg(navn, pris, hotel);
        return tilvalg;
    }

    public static Udflugt createUdflugt(String navn, LocalDate dato, int pris, String tourGuide, LocalTime tidspunkt, Konference konference) {
        Udflugt udflugt = konference.createUdflugt(navn, dato, pris, tourGuide, tidspunkt, konference);
        return udflugt;
    }
}
