package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Fad;
import modul.Hylde;
import modul.Lager;
import modul.Reol;

public class RegisterFadplaceringVindue extends GridPane {
    private final Controller controller;

    private ComboBox<Fad> cbFad;
    private ComboBox<Lager> cbLager;
    private ComboBox<Reol> cbReol;
    private ComboBox<Hylde> cbHylde;

    public RegisterFadplaceringVindue(Controller controller) {
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        overskrift(pane);
        dropdownsAndLabels(pane);
        registerButton(pane);
    }

    public void updateData() {
        if (cbFad != null) {
            cbFad.getItems().clear();
            cbFad.getItems().addAll(controller.getAllFad());
        }
        if (cbLager != null) {
            cbLager.getItems().clear();
            cbLager.getItems().addAll(controller.getAllLager());
        }
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Registrer fadplacering");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }

    private void dropdownsAndLabels(GridPane pane) {
        // Vælg Fad
        cbFad = new ComboBox<>();
        cbFad.setPromptText("Vælg fad");
        cbFad.getItems().addAll(controller.getAllFad());
        cbFad.setPrefWidth(500);
        pane.add(cbFad, 0, 1);

        Label lblFad = new Label("Fad");
        lblFad.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblFad, 1, 1);

        // Vælg Lager
        cbLager = new ComboBox<>();
        cbLager.setPromptText("Vælg lager");
        cbLager.getItems().addAll(controller.getAllLager());
        cbLager.setPrefWidth(500);
        pane.add(cbLager, 0, 2);

        Label lblLager = new Label("Lager");
        lblLager.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblLager, 1, 2);

        // Vælg Reol
        cbReol = new ComboBox<>();
        cbReol.setPromptText("Vælg reol");
        cbReol.setPrefWidth(500);
        cbReol.setDisable(true); // Deaktiveret indtil et lager er valgt
        pane.add(cbReol, 0, 3);

        Label lblReol = new Label("Reol");
        lblReol.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblReol, 1, 3);

        // Vælg Hylde
        cbHylde = new ComboBox<>();
        cbHylde.setPromptText("Vælg hylde");
        cbHylde.setPrefWidth(500);
        cbHylde.setDisable(true); // Deaktiveret indtil en reol er valgt
        pane.add(cbHylde, 0, 4);

        Label lblHylde = new Label("Hylde");
        lblHylde.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblHylde, 1, 4);

        // Lytter til ændringer i "Lager" dropdown
        cbLager.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            cbReol.getItems().clear();
            cbHylde.getItems().clear();
            cbHylde.setDisable(true);

            if (newValue != null) {
                cbReol.getItems().addAll(newValue.getReolList());
                cbReol.setDisable(false);
            } else {
                cbReol.setDisable(true);
            }
        });

        // Lytter til ændringer i "Reol" dropdown
        cbReol.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            cbHylde.getItems().clear();

            if (newValue != null) {
                // Tilføj kun hylder, der ikke har et fad (er ledige)
                for (Hylde hylde : newValue.getHyldeList()) {
                    if (hylde.getFad() == null) {
                        cbHylde.getItems().add(hylde);
                    }
                }

                // Gør hylde-dropdown aktiv, hvis der er ledige hylder tilbage
                cbHylde.setDisable(cbHylde.getItems().isEmpty());
            } else {
                cbHylde.setDisable(true);
            }
        });
    }

    private void registerButton(GridPane pane) {
        Button btnRegister = new Button("Registrer placering");
        btnRegister.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btnRegister.setPrefWidth(150);
        btnRegister.setPrefHeight(50);

        btnRegister.setOnAction(event -> {
            try {
                // Tjek om alt er valgt
                if (cbFad.getValue() == null || cbHylde.getValue() == null) {
                    showAlert("Advarsel", "Udfyld venligst fad og komplet placering (hylde).");
                    return;
                }

                Fad valgtFad = cbFad.getValue();
                Hylde valgtHylde = cbHylde.getValue();

                controller.registerFadPlacering(valgtFad, valgtHylde);

                showInfo("Succes", "Fad er nu registreret på den valgte hylde.");

                // Skudsikker nulstilling
                pane.getChildren().clear();
                initContent(pane);

            } catch (Exception e) {
                showAlert("Fejl", e.getMessage());
            }
        });

        pane.add(btnRegister, 1, 5);
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