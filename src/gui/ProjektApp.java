package gui;

import controller.Controller;
import javafx.application.Application;
import model.Hotel;
import model.Konference;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProjektApp {
    public static void main(String[] args) {
        ProjektApp app = new ProjektApp();
        app.initStorage();
        Application.launch(StartVindue.class);
    }

    public void initStorage() {
        Konference havOgHimmel = Controller.createKonference("Hav og himmel", LocalDate.of(2025, 2, 15), LocalDate.of(2025, 2, 17), 1500);
        Controller.createUdflugt("Gå fjorden rundt", LocalDate.of(2025, 2, 16), 500, "Torben", LocalTime.of(15, 30), havOgHimmel);
        Hotel denHvideSvane = Controller.createHotel("Den Hvide Svane", 150, 350);
        Controller.createTilvalg("WIFI", 50, denHvideSvane);

        Konference datamatiker = Controller.createKonference("Datamatiker", LocalDate.of(2025, 2, 20), LocalDate.of(2025, 2, 25), 1000);
        Controller.createUdflugt("Gå fjorden rundt", LocalDate.of(2025, 2, 22), 150, "Rasmus", LocalTime.of(12, 30), datamatiker);
        Hotel parkHotel = Controller.createHotel("Park Hotel", 350, 600);
        Controller.createTilvalg("Wifi", 100, parkHotel);

        Konference systemudvikling = Controller.createKonference("Systemudvikling", LocalDate.of(2025, 5, 10), LocalDate.of(2025, 5, 12), 250);
        ;
        Controller.createUdflugt("Rundvisning på universitetet", LocalDate.of(2025, 5, 12), 225, "Kasper", LocalTime.of(11, 45), systemudvikling);
        Hotel luksusOvernatning = Controller.createHotel("Luksus overnatning", 100, 300);
        Controller.createTilvalg("Mad", 150, luksusOvernatning);

        Konference fit = Controller.createKonference("FIT", LocalDate.of(2025, 6, 2), LocalDate.of(2025, 6, 7), 375);
        Controller.createUdflugt("Gåtur ved kysten", LocalDate.of(2025, 6, 5), 50, "Mark", LocalTime.of(15, 30), fit);
        Hotel kystHotel = Controller.createHotel("Kyst Hotel", 150, 350);
        Controller.createTilvalg("Morgenmad", 150, kystHotel);

        Konference jonasVinderVerden = Controller.createKonference("Jonas vinder verden", LocalDate.of(2025, 8, 28), LocalDate.of(2025, 8, 31), 10000);
        Controller.createUdflugt("Tur i LegoLand", LocalDate.of(2025, 8, 17), 750, "Carsten", LocalTime.of(10, 0), jonasVinderVerden);
        Hotel teaterHotellet = Controller.createHotel("Teater Hotellet", 500, 1500);
        Controller.createTilvalg("WIFI", 100, teaterHotellet);
    }
}
