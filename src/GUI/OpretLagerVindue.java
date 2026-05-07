package GUI;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class OpretLagerVindue extends GridPane {

    public OpretLagerVindue() {
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // TODO: Tilfj GUI-elementer og logik her
    }
}
