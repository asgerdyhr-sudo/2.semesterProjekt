package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class OpretDestilleringVindue extends GridPane {

    public OpretDestilleringVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("Opret destillering");
        pane.add(lblTitle, 0, 0);

        // TODO: Tilfj felter og funktioner her

        //vælg dato - DatePicer
        //Skriv alkohol procent (double)
        //skriv new make nummer (int)
        //Vælg maltBatch - dropdown med valgmulgiheder
        //vælg kornsort - dropdown med enums
        //skriv ingen i rygemateriale - String
        //Knap til at oprette destillering
        //popup med oprettet destillering eller de forskelliger fejl der kan forekomme eller mangler
    }
}
