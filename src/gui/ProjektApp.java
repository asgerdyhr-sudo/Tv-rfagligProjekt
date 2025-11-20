package gui;

import controller.Controller;
import javafx.application.Application;

import java.util.HashMap;

public class ProjektApp {
    private final Controller controller = new Controller();

    public static void main(String[] args) {
        ProjektApp app = new ProjektApp();
        Application.launch(GUI.class);
    }
}
