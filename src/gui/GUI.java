package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("KAS");
        GridPane pane = new GridPane();
        this.initKASFrontPage(pane);
        Scene sceneTeaterBestilling = new Scene(pane);
        primaryStage.setScene(sceneTeaterBestilling);
        primaryStage.show();
    }

    private void initKASFrontPage(GridPane pane) {
        pane.setPadding(new Insets(200));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(40);


        Label forisideNavnLabel = new Label("Velkommen til KAS");
        forisideNavnLabel.setStyle("-fx-font-size: 30px;");
        pane.add(forisideNavnLabel,2,0);
        
    }
}
