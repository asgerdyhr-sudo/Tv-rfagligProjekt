package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import storage.Storage;

import java.time.LocalDate;

public class TilmeldingsVindue {
    private final Label tomtLabel = new Label();
    private final ListView<Konference> konferencerListView = new ListView<>();
    private final CheckBox ledsagerCheckBox = new CheckBox("Ledsager");
    private final TextField ledsagerTextfield = new TextField();
    private final ListView<Udflugt> konferenceUdflugterListView = new ListView<>();
    private final CheckBox hotelCheckBox = new CheckBox("Hotel");
    private final ListView<Hotel> hotellerListView = new ListView<>();
    private final ListView<Tilvalg> hotelTilvalgListView = new ListView<>();
    private final TextField deltagerNavnTextFiled = new TextField();
    private final TextField deltagerAdresseTextField = new TextField();
    private final TextField deltagerByTextField = new TextField();
    private final TextField deltagerTelefonTextField = new TextField();
    private final DatePicker deltagerAnkomstDatePicker = new DatePicker();
    private final DatePicker deltagerAfrejseDatePicker = new DatePicker();
    private final CheckBox fordragsholderCheckbox = new CheckBox("Fordragsholder");
    private final CheckBox firmaCheckbox = new CheckBox("Firma");
    private final TextField firmaNavnTextField = new TextField();
    private final TextField firmaTelefonTextField = new TextField();
    private final Button createDeltagerButton = new Button("OPRET TILMELDING");
    Button lukVindueButton = new Button("Luk Vindue");
    private final Alert createDeltagerAlert = new Alert(Alert.AlertType.INFORMATION);
    private final Alert fejlDeltagerAlert = new Alert(Alert.AlertType.INFORMATION);

    public void showWindow() {
        Stage stage = new Stage();
        stage.setTitle("Tilmeld Deltager");
        GridPane firstPane = new GridPane();
        GridPane secondPane = new GridPane();
        GridPane thirdPane = new GridPane();
        initContent(firstPane, secondPane, thirdPane);

        HBox root = new HBox(10);
        root.getChildren().addAll(firstPane, secondPane, thirdPane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void initContent(GridPane firstPane, GridPane secondPane, GridPane thirdPane) {
        paneSettings(firstPane, secondPane, thirdPane);

        firstLine(firstPane);

        secondLine(secondPane);

        thirdLine(thirdPane);
    }

    private static void paneSettings(GridPane firstPane, GridPane secondPane, GridPane thirdPane) {
        firstPane.setPadding(new Insets(20));
        // set horizontal gap between components
        firstPane.setHgap(10);
        // set vertical gap between components
        firstPane.setVgap(10);

        secondPane.setPadding(new Insets(20));
        // set horizontal gap between components
        secondPane.setHgap(10);
        // set vertical gap between components
        secondPane.setVgap(10);

        thirdPane.setPadding(new Insets(20));
        // set horizontal gap between components
        thirdPane.setHgap(10);
        // set vertical gap between components
        thirdPane.setVgap(30);
        thirdPane.setPrefWidth(400);
    }

    private void firstLine(GridPane firstPane) {
        Label konferenceLabel = new Label("Konference(r)");
        firstPane.add(konferenceLabel, 0, 0);

        konferencerListView.setPrefSize(400, 400);
        konferencerListView.setEditable(false);
        konferencerListView.getItems().addAll(Storage.getKonferencer());
        konferencerListView.setOnMouseClicked(event -> {
            Konference selectedkonference = konferencerListView.getSelectionModel().getSelectedItem();
            if (selectedkonference != null) {
                clickKonference(selectedkonference);
            }
        });
        firstPane.add(konferencerListView, 0, 1);

        firstPane.add(tomtLabel, 0, 2);

        firstPane.add(ledsagerCheckBox, 0, 3);
        ledsagerCheckBox.setOnAction(e -> {
            ledsagerCheckBoxLogik();
            Konference selectedkonference = konferencerListView.getSelectionModel().getSelectedItem();
            if (selectedkonference != null) {
                clickKonference(selectedkonference);
            }
        });

        Label ledsagerNavnLabel = new Label("Navn");
        firstPane.add(ledsagerNavnLabel, 0, 4);
        firstPane.add(ledsagerTextfield, 0, 5);
        ledsagerTextfield.setDisable(true);

        Label konferenceUdflugterLabel = new Label("Konference udflugter");
        firstPane.add(konferenceUdflugterLabel, 0, 6);

        konferenceUdflugterListView.setPrefSize(400, 400);
        konferenceUdflugterListView.setEditable(false);
        konferenceUdflugterListView.setDisable(true);
        firstPane.add(konferenceUdflugterListView, 0, 7);
    }

    private void secondLine(GridPane secondPane) {
        secondPane.add(hotelCheckBox, 0, 0);
        hotelCheckBox.setOnAction(event -> {
            hotelCheckBoxLogik();
        });

        Label hotelLabel = new Label("Hotel");
        secondPane.add(hotelLabel, 0, 1);

        hotellerListView.setPrefSize(400, 400);
        hotellerListView.setEditable(false);
        hotellerListView.setDisable(true);
        hotellerListView.setOnMouseClicked(event -> {
            Hotel selectedHotel = hotellerListView.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                clickHotel(selectedHotel);
            }
        });
        secondPane.add(hotellerListView, 0, 2);

        secondPane.add(tomtLabel, 0, 3);

        Label hotelTilvalgLabel = new Label("Hotel tilvalg");
        secondPane.add(hotelTilvalgLabel, 0, 4);

        hotelTilvalgListView.setPrefSize(400, 400);
        hotelTilvalgListView.setEditable(false);
        hotelTilvalgListView.setDisable(true);
        secondPane.add(hotelTilvalgListView, 0, 5);
    }

    private void thirdLine(GridPane thirdPane) {
        Label deltagerInformation = new Label("Deltager information");
        thirdPane.add(deltagerInformation, 0, 2, 2, 1);

        Label deltagerNavnLabel = new Label("Navn:");
        thirdPane.add(deltagerNavnLabel, 0, 3);
        thirdPane.add(deltagerNavnTextFiled, 1, 3);

        Label deltagerAdresseLabel = new Label("Deltager Adresse:");
        thirdPane.add(deltagerAdresseLabel, 0, 4);
        thirdPane.add(deltagerAdresseTextField, 1, 4);

        Label deltagerByLabel = new Label("By:");
        thirdPane.add(deltagerByLabel, 0, 5);
        thirdPane.add(deltagerByTextField, 1, 5);

        Label deltagerTelefonLabel = new Label("Telefon:");
        thirdPane.add(deltagerTelefonLabel, 0, 6);
        thirdPane.add(deltagerTelefonTextField, 1, 6);

        Label ankomstLabel = new Label("Ankomst dato:");
        thirdPane.add(ankomstLabel, 0, 7);
        thirdPane.add(deltagerAnkomstDatePicker, 1, 7);

        Label afrejseLabel = new Label("Afrejse dato:");
        thirdPane.add(afrejseLabel, 0, 8);
        thirdPane.add(deltagerAfrejseDatePicker, 1, 8);

        thirdPane.add(fordragsholderCheckbox, 1, 9);

        thirdPane.add(tomtLabel, 0, 10);

        thirdPane.add(firmaCheckbox, 1, 11);
        firmaCheckbox.setOnAction(event -> {
            firmaCheckboxLogik();
        });

        Label firmaNavnLabel = new Label("Firma navn:");
        thirdPane.add(firmaNavnLabel, 0, 12);
        firmaNavnTextField.setDisable(true);
        thirdPane.add(firmaNavnTextField, 1, 12);

        Label firmaTelefonLabel = new Label("Firma telefon:");
        thirdPane.add(firmaTelefonLabel, 0, 13);
        firmaTelefonTextField.setDisable(true);
        thirdPane.add(firmaTelefonTextField, 1, 13);

        thirdPane.add(createDeltagerButton, 1, 14);
        createDeltagerButton.setOnAction(event -> {
            if (createBestilling()) {
                Stage stage = (Stage) createDeltagerButton.getScene().getWindow();
                stage.close();

            } else {
                fejlDeltagerAlert.setTitle("FEJL");
                fejlDeltagerAlert.setHeaderText("Udfyld venligt hele skemaet");
                fejlDeltagerAlert.show();
            }
        });
        createDeltagerButton.setPrefSize(200, 100);

        thirdPane.add(lukVindueButton, 1, 15);
        lukVindueButton.setOnAction(event -> {
            Stage stage = (Stage) createDeltagerButton.getScene().getWindow();
            stage.close();
        });
        lukVindueButton.setPrefWidth(200);
    }

    private void clickHotel(Hotel hotel) {
        hotelTilvalgListView.getItems().clear();
        if (hotelCheckBox.isSelected()) {
            hotelTilvalgListView.setDisable(false);
            if (hotel.getTilvalg() != null) {
                hotelTilvalgListView.getItems().addAll(hotel.getTilvalg());
            }
        }
    }

    private void clickKonference(Konference konference) {
        konferenceUdflugterListView.getItems().clear();
        if (ledsagerCheckBox.isSelected()) {
            if (konference.getUdflugter() != null) {
                konferenceUdflugterListView.getItems().addAll(konference.getUdflugter());
            }
        }
    }

    private void ledsagerCheckBoxLogik() {
        boolean selected = ledsagerCheckBox.isSelected();
        ledsagerTextfield.setDisable(!selected);
        konferenceUdflugterListView.setDisable(!selected);
        if (!selected) {
            ledsagerTextfield.clear();
            konferenceUdflugterListView.getItems().clear();
        }
    }

    private void hotelCheckBoxLogik() {
        boolean selected = hotelCheckBox.isSelected();
        hotellerListView.setDisable(!selected);
        hotelTilvalgListView.setDisable(!selected);
        if (selected) {
            hotellerListView.getItems().setAll((Storage.getHoteller()));
            hotelTilvalgListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } else {
            hotelTilvalgListView.getItems().clear();
            hotellerListView.getItems().clear();

        }
    }

    private void firmaCheckboxLogik() {
        boolean selected = firmaCheckbox.isSelected();
        firmaNavnTextField.setDisable(!selected);
        firmaTelefonTextField.setDisable(!selected);
        if (!selected) {
            firmaNavnTextField.clear();
            firmaTelefonTextField.clear();
        }
    }

    private boolean createBestilling() {
        //Deltager info
        String navn = deltagerNavnTextFiled.getText();
        String adresse = deltagerAdresseTextField.getText();
        String by = deltagerByTextField.getText();
        String telefon = deltagerTelefonTextField.getText();
        LocalDate ankomstDato = deltagerAnkomstDatePicker.getValue();
        LocalDate afrejseDato = deltagerAfrejseDatePicker.getValue();
        Konference konference = konferencerListView.getSelectionModel().getSelectedItem();
        Status status;
        String firmaTelefon = firmaTelefonTextField.getText();
        String firmaNavn = firmaNavnTextField.getText();
        Værelse værelse = Værelse.ENKELT;

        if (fordragsholderCheckbox.isSelected()) {
            status = Status.FOREDRAGSHOLDER;
        } else {
            status = Status.DELTAGER;
        }

        //Hotel info
        Hotel hotel = hotellerListView.getSelectionModel().getSelectedItem();

        //Ledsager
        String ledsagerNavn = ledsagerTextfield.getText();

        if (navn != null && !navn.isEmpty() && adresse != null && !adresse.isEmpty() && by != null && !by.isEmpty() && telefon != null && !telefon.isEmpty() && ankomstDato != null && afrejseDato != null && konference != null) {
            Deltager deltager = Controller.createDeltager(navn, adresse, by, status, telefon);
            Bestilling bestilling = Controller.createBestilling(ankomstDato, afrejseDato, deltager, konference);

            if (hotel != null) {
                bestilling.setHotel(hotel);
                var valgteTilvalg = hotelTilvalgListView.getSelectionModel().getSelectedItems();
                if (hotelTilvalgListView.getSelectionModel().getSelectedItems() != null) {
                    for (Tilvalg tilvalg : valgteTilvalg) {
                        bestilling.addTilvalg(tilvalg);
                    }
                }
            }
            if (ledsagerNavn != null && !ledsagerNavn.isEmpty()) {
                Ledsager ledsager = deltager.createLedsager(ledsagerNavn);
                værelse = Værelse.DOBBELT;
                Udflugt udflugt = konferenceUdflugterListView.getSelectionModel().getSelectedItem();
                if (udflugt != null){
                    ledsager.addUdflugt(udflugt);
                    bestilling.addUdflugt(udflugt);
                }
            }
            if (firmaNavn != null && !firmaNavnTextField.getText().isEmpty() && firmaTelefon != null && !firmaTelefonTextField.getText().isEmpty()) {
                deltager.setFirmanavn(firmaNavn);
                deltager.setFirmatelefon(firmaTelefon);
            }
            createDeltagerAlert.setTitle("Deltager tilmeldt");
            createDeltagerAlert.setHeaderText("Du har tilmeldt dig med bestillings nr: " + bestilling.getBestillingsNr());
            createDeltagerAlert.setContentText("Din samlet pris er: " + bestilling.samletPris(værelse) + " kr.");
            createDeltagerAlert.show();
            return true;
        }

        return false;
    }
}
