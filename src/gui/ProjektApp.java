package gui;

import controller.Controller;
import javafx.application.Application;

import java.util.HashMap;

public class ProjektApp {
    private final Controller controller = new Controller();

    public static void main(String[] args) {
        ProjektApp app = new ProjektApp();
        HashMap<String, Double> priser = new HashMap<>();
        priser.put("Wifi",2.0);
        priser.put("Morgenmad", 5.99);

        System.out.println(priser);
        Application.launch(GUI.class);
    }
}
