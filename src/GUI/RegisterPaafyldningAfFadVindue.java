package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Destillat;
import modul.Fad;

public class RegisterPaafyldningAfFadVindue extends GridPane {
    private final Controller controller;

    private ComboBox<Fad> cbFad;
    private ListView<Destillat> lvDestilat;

    public RegisterPaafyldningAfFadVindue(Controller controller) {
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        overskrift(pane);
        dropdwonsAndLabels(pane);
        registerButton(pane);

    }

    public void updateData(){
        if (cbFad != null){
            cbFad.getItems().clear();
            cbFad.getItems().addAll(controller.getAllFad());
        }
    }

    private static void overskrift(GridPane pane) {
        Label lblTitle = new Label("Registrer påfyldning af fad");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }

    private void dropdwonsAndLabels(GridPane pane) {
        // Vælg Fad
        cbFad = new ComboBox<>();
        cbFad.setPromptText("Vælg fad");
        cbFad.getItems().addAll(controller.getAllFad());
        cbFad.setPrefWidth(500);
        pane.add(cbFad, 0, 1);

        Label lblFad = new Label("Fad");
        lblFad.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblFad, 1, 1);

        lvDestilat = new ListView<>();
        lvDestilat.getItems().addAll(controller.getAllDestillat());
        lvDestilat.setPrefWidth(500);
        pane.add(lvDestilat,0,2);

        Label lblDestilat = new Label("Vælg destilat");
        lblDestilat.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        GridPane.setValignment(lblDestilat, VPos.TOP); // Sætter labelen til toppen af cellen
        pane.add(lblDestilat, 1, 2);
    }

    private void registerButton(GridPane pane) {
        Button btnRegisterPåfyldning = new Button("Register påfyldning");
        btnRegisterPåfyldning.setFont(Font.font("Arial",FontWeight.BOLD,12));
        btnRegisterPåfyldning.setPrefSize(150,50);
        GridPane.setValignment(btnRegisterPåfyldning, VPos.BOTTOM); // Aligns the button to the bottom of the cell
        pane.add(btnRegisterPåfyldning, 1, 2);

        btnRegisterPåfyldning.setOnAction(event -> {
            Fad selectedFad = cbFad.getValue();
            Destillat selectedDestillat = lvDestilat.getSelectionModel().getSelectedItem();

            if (selectedFad == null) {
                showAlert("Fejl", "Vælg venligst et fad.");
                return;
            }
            if (selectedDestillat == null) {
                showAlert("Fejl", "Vælg venligst et destillat.");
                return;
            }

            try {
                // Kalder controller metoden, der forbinder destillat og fad
                controller.registrerPåfyldning(selectedDestillat, selectedFad);

                showInfo("Succes", "Påfyldningen blev registreret succesfuldt.");

                // Nulstil valgene for god brugeroplevelse
                cbFad.getSelectionModel().clearSelection();
                lvDestilat.getSelectionModel().clearSelection();
            } catch (Exception e) {
                showAlert("Netværks- eller logikfejl", e.getMessage());
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
