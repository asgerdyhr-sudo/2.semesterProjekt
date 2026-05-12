package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Fad;
import modul.Hylde;
import modul.Lager;
import modul.Reol;

public class SeFadLagerVindue extends GridPane {
    private final Controller controller;
    private ListView<String> lwFad;
    private ComboBox<Lager> cbLager;

    public SeFadLagerVindue(Controller controller) {
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        overskrift(pane);

        cbLager = new ComboBox<>();
        cbLager.setPromptText("Vælg lager");
        cbLager.getItems().addAll(controller.getAllLager());
        cbLager.setPrefWidth(500);
        pane.add(cbLager,0,1);

        Label lblLager = new Label("Lager");
        lblLager.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblLager,1,1);

        lwFad = new ListView<>();
        lwFad.setPrefSize(500,400);
        lwFad.setDisable(true);
        pane.add(lwFad,0,2);

        cbLager.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lwFad.getItems().clear();
            if (newValue != null) {
                lwFad.setDisable(false);
                // Gennemgår alle reoler og hylder for at finde fadene på det valgte lager
                for (Reol reol : newValue.getReolList()) {
                    for (Hylde hylde : reol.getHyldeList()) {
                        if (hylde.getFad() != null) {
                            String fadInfo = hylde.getFad().toString() + " - " + reol.toString() + ", " + hylde.toString();
                            lwFad.getItems().add(fadInfo);
                        }
                    }
                }
            } else {
                lwFad.setDisable(true);
            }
        });

    }

    public void updateData() {
        if (cbLager != null) {
            Lager valgtLager = cbLager.getValue();
            cbLager.getItems().clear();
            cbLager.getItems().addAll(controller.getAllLager());
            if (valgtLager != null && cbLager.getItems().contains(valgtLager)) {
                cbLager.setValue(valgtLager); // Dette vil automatisk opdatere lwFad via vores listener
            } else {
                lwFad.getItems().clear();
                lwFad.setDisable(true);
            }
        }
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Se fade på lager");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
}
