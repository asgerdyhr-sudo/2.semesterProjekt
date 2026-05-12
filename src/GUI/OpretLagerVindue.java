package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OpretLagerVindue extends GridPane {

    public OpretLagerVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        overskrift(pane);

        // TODO: Tilfj GUI-elementer og logik her
        //skriv navn på lager
        //skriv lokation på lager
        //angiv antal reoler
        //udregn antal hylder (10 hylder pr reol)
    }

    private static void overskrift(GridPane pane) {
        Label lblTitle = new Label("Opret lager");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
}
