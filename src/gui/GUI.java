package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

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
