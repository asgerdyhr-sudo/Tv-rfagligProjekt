package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartVindue extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KAS - Hovedmenu");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Knap til at åbne tilmeldingsvinduet
        Button tilmeldButton = new Button("Tilmeld Deltager");
        tilmeldButton.setPrefSize(150, 50);
        pane.add(tilmeldButton, 0, 0);
        tilmeldButton.setOnAction(event -> this.tilmeldAction());

        // Knap til at åbne "Find deltager" vinduet
        Button informationButton = new Button("Find Information(er)");
        informationButton.setPrefSize(150, 50);
        pane.add(informationButton, 1, 0);
        informationButton.setOnAction(event -> this.informationAction());
    }

    private void tilmeldAction() {
        TilmeldingsVindue tilmeldingsVindue = new TilmeldingsVindue();
        tilmeldingsVindue.showWindow();
    }

    private void informationAction() {
        informationsVindue findDeltagerVindue = new informationsVindue();
        findDeltagerVindue.showWindow();
    }
}