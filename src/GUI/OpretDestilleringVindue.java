package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretDestilleringVindue extends Stage {

    public OpretDestilleringVindue() {
        this.setTitle("Opret destillering");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 600, 400);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("Opret destillering");
        pane.add(lblTitle, 0, 0);

        // TODO: Tilføj felter og funktioner her
    }
}
