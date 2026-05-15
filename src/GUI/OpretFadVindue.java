package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Leverandør;

public class OpretFadVindue extends GridPane {
    private final Controller controller;

    private TextField txfFadType;
    private ComboBox<Integer> cbStørrelse;
    private ComboBox<String> cbTidligereIndhold;
    private ComboBox<Leverandør> cbLeverandør;

    public OpretFadVindue(Controller controller) {
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        overskrift(pane);
        textAndLabels(pane);
        opretFadButton(pane);
    }

    public void updateData() {
        if (cbLeverandør != null) {
            cbLeverandør.getItems().setAll(controller.getAllLeverandør());
            cbLeverandør.getSelectionModel().clearSelection();
        }
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Opret fad");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
    private void textAndLabels(GridPane pane) {
        // Skriv fad type (string)
        txfFadType = new TextField();
        txfFadType.setPromptText("F.eks. Egetræ");
        txfFadType.setPrefWidth(500);
        pane.add(txfFadType, 0, 1);

        Label lblFadType = new Label("Fad type");
        lblFadType.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblFadType, 1, 1);

        // Dropdown med størrelse af fad (int)
        cbStørrelse = new ComboBox<>();
        cbStørrelse.setPromptText("Vælg størrelse i liter");
        cbStørrelse.getItems().addAll(50, 100, 150, 200, 250, 500); // Eksempelstørrelser
        cbStørrelse.setPrefWidth(500);
        pane.add(cbStørrelse, 0, 2);

        Label lblStørrelse = new Label("Størrelse (Liter)");
        lblStørrelse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblStørrelse, 1, 2);

        // Dropdown med tidligere indhold af fad (string)
        cbTidligereIndhold = new ComboBox<>();
        cbTidligereIndhold.setPromptText("Vælg tidligere indhold");
        cbTidligereIndhold.getItems().addAll("Bourbon", "Sherry", "Rom", "Vin", "Jomfru (Ingen)");
        cbTidligereIndhold.setPrefWidth(500);
        pane.add(cbTidligereIndhold, 0, 3);

        Label lblTidligereIndhold = new Label("Tidligere indhold");
        lblTidligereIndhold.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblTidligereIndhold, 1, 3);

        // Dropdown med leverandører
        cbLeverandør = new ComboBox<>();
        cbLeverandør.setPromptText("Vælg leverandør");
        cbLeverandør.getItems().addAll(controller.getAllLeverandør());
        cbLeverandør.setPrefWidth(500);
        pane.add(cbLeverandør, 0, 4);

        Label lblLeverandør = new Label("Leverandør");
        lblLeverandør.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblLeverandør, 1, 4);
    }
    //tjek linje 116

    private void opretFadButton(GridPane pane) {
        Button btnOpretFad = new Button("Opret fad");
        btnOpretFad.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btnOpretFad.setPrefWidth(150);
        btnOpretFad.setPrefHeight(50);

        btnOpretFad.setOnAction(event -> {
            try {
                // Tjekker om felterne er tomme
                if (txfFadType.getText().trim().isEmpty() ||
                        cbStørrelse.getValue() == null ||
                        cbTidligereIndhold.getValue() == null ||
                        cbLeverandør.getValue() == null) {
                    showAlert("Advarsel", "Udfyld venligst alle felter og dropdowns.");
                    return;
                }

                // Læser data
                String fadType = txfFadType.getText().trim();
                int størrelse = cbStørrelse.getValue();
                String tidligereIndhold = cbTidligereIndhold.getValue();
                Leverandør leverandør = cbLeverandør.getValue();

                // Opretter fad via controller
                controller.createFad(fadType, størrelse, tidligereIndhold, leverandør);

                //Succes besked og ryd felter
                showInfo("Succes", "Fad er oprettet succesfuldt.");

                // SKUDSIKKER NULSTILLING:
                pane.getChildren().clear();
                initContent(pane);

            } catch (IllegalArgumentException e) {
                showAlert("Ugyldig data", e.getMessage());
            } catch (Exception e) {
                showAlert("Ukendt fejl", "Der opstod en systemfejl.");
            }
        });

        pane.add(btnOpretFad, 1, 5);

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

