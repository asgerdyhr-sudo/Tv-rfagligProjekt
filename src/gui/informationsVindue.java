package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import storage.Storage;

import java.util.ArrayList;

public class informationsVindue {
    Label deltagerNavnLabel = new Label("Navn");
    TextField deltagerNavnTextField = new TextField();
    ListView findDeltagerListView = new ListView<>();
    Button findDeltagerButton = new Button("Find Deltager");
    Button lukVindueButton = new Button("Luk Vindue");
    ListView konferencerListView = new ListView<>();
    ListView konferenceDeltagereListView = new ListView<>();
    ListView udflugtListView = new ListView<>();
    ListView udflugtsdeltagereListView = new ListView<>();
    ListView hotellerListView = new ListView<>();
    ListView hotelGæsterListView = new ListView<>();

    public void showWindow() {
        Stage stage = new Stage();
        stage.setTitle("Find Information(er)");
        GridPane deltagerPane = new GridPane();
        GridPane konferencePane = new GridPane();
        GridPane udflugtPane = new GridPane();
        GridPane hotelPane = new GridPane();
        initContent(deltagerPane, konferencePane, udflugtPane, hotelPane);

        HBox root = new HBox(10);
        root.getChildren().addAll(deltagerPane, konferencePane, udflugtPane, hotelPane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void initContent(GridPane deltagerPane, GridPane konferencePane, GridPane udflugtPane, GridPane hotelPane) {
        paneSettings(deltagerPane, konferencePane, udflugtPane, hotelPane);

        firstLine(deltagerPane);

        secondLine(konferencePane);

        thirdLine(udflugtPane, hotelPane);

        Label findHotelLabel = new Label("Find Hotel");
        findHotelLabel.setStyle("-fx-font-size: 24px");
        hotelPane.add(findHotelLabel, 0, 0);

        Label hotelLabel = new Label("Hoteller");
        hotelPane.add(hotelLabel,0,1);

        hotellerListView.setPrefSize(250, 250);
        hotellerListView.setEditable(false);
        hotellerListView.getItems().addAll(Storage.getHoteller());
        hotelPane.add(hotellerListView, 0, 2);
        hotellerListView.setOnMouseClicked(event -> {
            Hotel selectedHotel = (Hotel) hotellerListView.getSelectionModel().getSelectedItem();
            if (selectedHotel != null){
                clickHotel(selectedHotel);
            }
        });

        Label hotelGæsterLabel = new Label("Hotel Gæster");
        hotelPane.add(hotelGæsterLabel,0,3);

        hotelGæsterListView.setPrefSize(250,250);
        hotelGæsterListView.setEditable(false);
        hotelPane.add(hotelGæsterListView,0,4);

        hotelPane.add(lukVindueButton,0,5);
        lukVindueButton.setOnAction(event -> {
            Stage stage = (Stage) lukVindueButton.getScene().getWindow();
            stage.close();
        });
        lukVindueButton.setPrefWidth(250);


    }

    private static void paneSettings(GridPane deltagerPane, GridPane konferencePane, GridPane udflugtPane, GridPane hotelPane) {
        // set padding of the pane
        deltagerPane.setPadding(new Insets(20));
        // set horizontal gap between components
        deltagerPane.setHgap(10);
        // set vertical gap between components
        deltagerPane.setVgap(10);

        // set padding of the pane
        konferencePane.setPadding(new Insets(20));
        // set horizontal gap between components
        konferencePane.setHgap(10);
        // set vertical gap between components
        konferencePane.setVgap(10);

        // set padding of the pane
        udflugtPane.setPadding(new Insets(20));
        // set horizontal gap between components
        udflugtPane.setHgap(10);
        // set vertical gap between components
        udflugtPane.setVgap(10);

        // set padding of the pane
        hotelPane.setPadding(new Insets(20));
        // set horizontal gap between components
        hotelPane.setHgap(10);
        // set vertical gap between components
        hotelPane.setVgap(10);
    }

    private void firstLine(GridPane deltagerPane) {
        Label findDeltager = new Label("Find Deltager");
        findDeltager.setStyle("-fx-font-size: 24px");
        deltagerPane.add(findDeltager, 0, 0);

        deltagerPane.add(deltagerNavnLabel, 0, 1);
        deltagerPane.add(deltagerNavnTextField, 0, 2);

        Label deltager = new Label("Deltager");
        deltagerPane.add(deltager, 0, 3);
        findDeltagerListView.setEditable(false);
        deltagerPane.add(findDeltagerListView, 0, 4);

        findDeltagerButton.setOnAction(event -> findDeltager());
        findDeltagerButton.setPrefSize(250, 50);
        deltagerPane.add(findDeltagerButton, 0, 5);
    }

    private void secondLine(GridPane konferencePane) {
        Label findKonferenceLabel = new Label("Find Konference");
        findKonferenceLabel.setStyle("-fx-font-size: 24px");
        konferencePane.add(findKonferenceLabel, 0, 0);

        Label konferenceLabel = new Label("Konferencer");
        konferencePane.add(konferenceLabel, 0, 1);

        konferencerListView.setPrefSize(250, 250);
        konferencerListView.setEditable(false);
        konferencerListView.getItems().addAll(Storage.getKonferencer());
        konferencePane.add(konferencerListView, 0, 2);
        konferencerListView.setOnMouseClicked(event -> {
            Konference selectedkonference = (Konference) konferencerListView.getSelectionModel().getSelectedItem();
            if (selectedkonference != null) {
                clickKonference(selectedkonference);
            }
        });

        Label konferenceDeltagerLabel = new Label("Deltagere til konferencen");
        konferencePane.add(konferenceDeltagerLabel, 0, 3);

        konferenceDeltagereListView.setPrefSize(250, 250);
        konferenceDeltagereListView.setEditable(false);
        konferencePane.add(konferenceDeltagereListView, 0, 4);
    }

    private void thirdLine(GridPane udflugtPane, GridPane hotelPane) {
        Label findUdflugtLabel = new Label("Find Udflugt");
        findUdflugtLabel.setStyle("-fx-font-size: 24px");
        udflugtPane.add(findUdflugtLabel, 0, 0);

        Label udflugtLabel = new Label("Udflugter");
        udflugtPane.add(udflugtLabel, 0, 1);

        udflugtListView.setPrefSize(250, 250);
        udflugtListView.setEditable(false);
        ArrayList<Udflugt> alleUdflugterArrayList = new ArrayList<>();

        for (Konference konference : Storage.getKonferencer()) {
            alleUdflugterArrayList.addAll(konference.getUdflugter());
        }

        udflugtListView.getItems().setAll(alleUdflugterArrayList);
        udflugtListView.setOnMouseClicked(event -> {
            Udflugt selectedUdflugt = (Udflugt) udflugtListView.getSelectionModel().getSelectedItem();
            if (selectedUdflugt != null) {
                clickUdflugt(selectedUdflugt);
            }
        });
        udflugtPane.add(udflugtListView, 0, 2);

        Label udlugtsDeltagereLabel = new Label("Udflugt(s) deltager(e)");
        udflugtPane.add(udlugtsDeltagereLabel, 0, 3);

        udflugtsdeltagereListView.setPrefSize(250, 250);
        udflugtsdeltagereListView.setEditable(false);
        udflugtPane.add(udflugtsdeltagereListView, 0, 4);
    }

    private void findDeltager() {
        findDeltagerListView.getItems().clear();
        String navn = deltagerNavnTextField.getText().toLowerCase();

        for (Deltager deltager : Storage.getDeltagere()) {
            if (deltager.getNavn().toLowerCase().contains(navn)) {
                findDeltagerListView.getItems().add(deltager);
            }
        }
    }

    private void clickKonference(Konference konference) {
        konferenceDeltagereListView.getItems().clear();
        if (konference.getBestillinger() != null) {
            for (Bestilling bestilling : konference.getBestillinger()) {
                konferenceDeltagereListView.getItems().add(bestilling.getDeltager());
            }
        }
    }

    private void clickUdflugt(Udflugt udflugt) {
        udflugtsdeltagereListView.getItems().clear();
        if (udflugt.getLedsagere() != null) {
            for (Ledsager ledsager : udflugt.getLedsagere()) {
                udflugtsdeltagereListView.getItems().add(ledsager.udskrift());
            }
        }
    }

    private void clickHotel(Hotel hotel) {
        hotelGæsterListView.getItems().clear();
        for (Konference konference : Storage.getKonferencer()) {
            for (Bestilling bestilling : konference.getBestillinger()) {
                if (bestilling.getHotel() != null && bestilling.getHotel().equals(hotel)) {
                    hotelGæsterListView.getItems().add(bestilling.getDeltager());
                }
            }
        }
    }

}