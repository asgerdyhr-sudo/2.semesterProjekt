package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OpretLagerVindue extends GridPane {
    private final Controller controller;

    private TextField txfNavn;
    private TextField txfLokation;
    private TextField txfAntalReoler;

    public OpretLagerVindue(Controller controller) {
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
        opretLagerButton(pane);
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Opret lager");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }

    private void textAndLabels(GridPane pane) {
        // Navn på lager
        txfNavn = new TextField();
        txfNavn.setPromptText("F.eks. Lagerhal 1");
        txfNavn.setPrefWidth(500);
        pane.add(txfNavn, 0, 1);

        Label lblNavn = new Label("Navn på lager");
        lblNavn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblNavn, 1, 1);

        // Lokation på lager
        txfLokation = new TextField();
        txfLokation.setPromptText("F.eks. Bygning A");
        txfLokation.setPrefWidth(500);
        pane.add(txfLokation, 0, 2);

        Label lblLokation = new Label("Lokation");
        lblLokation.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblLokation, 1, 2);

        // Antal reoler
        txfAntalReoler = new TextField();
        txfAntalReoler.setPromptText("F.eks. 5");
        txfAntalReoler.setPrefWidth(500);
        pane.add(txfAntalReoler, 0, 3);

        Label lblAntalReoler = new Label("Antal reoler");
        lblAntalReoler.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblAntalReoler, 1, 3);
    }

    private void opretLagerButton(GridPane pane) {
        Button btnOpretLager = new Button("Opret lager");
        btnOpretLager.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btnOpretLager.setPrefWidth(150);
        btnOpretLager.setPrefHeight(50);

        btnOpretLager.setOnAction(event -> {
            try {
                // Tjek om felter er tomme
                if (txfNavn.getText().trim().isEmpty() ||
                    txfLokation.getText().trim().isEmpty() ||
                    txfAntalReoler.getText().trim().isEmpty()) {
                    showAlert("Advarsel", "Udfyld venligst alle felter.");
                    return;
                }

                String navn = txfNavn.getText().trim();
                String lokation = txfLokation.getText().trim();

                //Konventer antalReoler
                int antalReoler = Integer.parseInt(txfAntalReoler.getText().trim());

                // Udregner antalHylder
                int antalHylder = antalReoler * 10;

                // Opretter et lager via controller
                controller.createLager(navn, lokation, antalReoler, antalHylder);

                showInfo("Succes", "Lager er oprettet med " + antalReoler + " reoler og " + antalHylder + " hylder.");

                // Ryder felterne
                txfNavn.clear();
                txfLokation.clear();
                txfAntalReoler.clear();

            } catch (NumberFormatException e) {
                showAlert("Fejl i indtastning", "Antal reoler skal være et helt tal.");
            } catch (IllegalArgumentException e) {
                showAlert("Ugyldig data", e.getMessage());
            }
        });

        pane.add(btnOpretLager, 1, 4);
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