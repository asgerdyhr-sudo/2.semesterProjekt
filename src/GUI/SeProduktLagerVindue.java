package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SeProduktLagerVindue extends GridPane {

    public SeProduktLagerVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("Se produkt lager");
        pane.add(lblTitle, 0, 0);

        // TODO: Tilfj felter og funktioner her
    }
}
