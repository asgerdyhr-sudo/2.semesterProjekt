package GUI;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class OpretFadVindue extends GridPane {

    public OpretFadVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // TODO: Tilfj GUI-elementer og logik her

        //skriv fad nummer (int)
        //skriv fad type (string)
        //dropdown med størrelse af fad
        //dropdown med tidligere indhold af fad
        //dropdown med leverandører
    }
}
