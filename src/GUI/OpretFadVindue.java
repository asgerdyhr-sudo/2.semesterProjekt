package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretFadVindue extends Stage {

    public OpretFadVindue() {
        this.setTitle("Opret fad");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 400, 300);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // TODO: Tilføj GUI-elementer og logik her
    }
}

