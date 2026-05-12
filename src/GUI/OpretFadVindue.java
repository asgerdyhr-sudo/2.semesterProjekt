package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OpretFadVindue extends GridPane {

    public OpretFadVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        overskrift(pane);

        // TODO: Tilfj GUI-elementer og logik her

        //skriv fad nummer (int)
        //skriv fad type (string)
        //dropdown med størrelse af fad
        //dropdown med tidligere indhold af fad
        //dropdown med leverandører
    }

    private static void overskrift(GridPane pane) {
        Label lblTitle = new Label("Opret fad");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
}
