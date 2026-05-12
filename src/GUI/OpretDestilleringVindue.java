package GUI;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Kornsort;
import modul.Medarbejder;
import modul.MængdeDestillat;

public class OpretDestilleringVindue extends GridPane {
    private final Controller controller;

    //Definere UI componenter så de kan tilgåes
    private DatePicker dpDato;
    private TextField txfAlkoholProcent;
    private TextField txfNewMakeNummer;
    private ComboBox<String> cbMaltbatch;
    private ComboBox<Kornsort> cbKornsort;
    private TextField txfRygemateriale;
    private TextField txfMængdeDestilat;
    private ComboBox<Medarbejder> cbMedarbejder;


    public OpretDestilleringVindue(Controller controller) {
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        overksrift(pane);
        textAndLabels(pane);
        opretDestilleringButton(pane);
    }

    private void overksrift(GridPane pane) {
        Label lblTitle = new Label("Opret destillering");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }

    private void textAndLabels(GridPane pane) {
        //vælg dato - DatePicer
        dpDato = new DatePicker();
        dpDato.setPrefWidth(500);
        pane.add(dpDato, 0, 1);

        Label lblDato = new Label("Dato");
        lblDato.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblDato, 1, 1);

        //Skriv alkohol procent (double)
        txfAlkoholProcent = new TextField();
        txfAlkoholProcent.setPromptText("F.eks. 63.5");
        txfAlkoholProcent.setPrefWidth(500);
        pane.add(txfAlkoholProcent, 0, 2);

        Label lblAlkoholProcent = new Label("Alkohol procent");
        lblAlkoholProcent.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblAlkoholProcent, 1, 2);

        //skriv new make nummer (int)
        txfNewMakeNummer = new TextField();
        txfNewMakeNummer.setPromptText("F.eks. 2");
        txfNewMakeNummer.setPrefWidth(500);
        pane.add(txfNewMakeNummer, 0, 3);

        Label lblNewMakeNummer = new Label("New Make Nummer");
        lblNewMakeNummer.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblNewMakeNummer, 1, 3);

        //Vælg maltBatch - dropdown med valgmulgiheder
        cbMaltbatch = new ComboBox<>();
        cbMaltbatch.setPromptText("Vælg maltbatch");
        cbMaltbatch.getItems().addAll("Batch 1", "Batch 2", "Batch 3", "Batch 4", "Batch 5", "batch 6");
        cbMaltbatch.setPrefWidth(500);
        pane.add(cbMaltbatch, 0, 4);

        Label lblMaltbatch = new Label("Maltbatch");
        lblMaltbatch.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblMaltbatch, 1, 4);

        //vælg kornsort - dropdown med enums
        cbKornsort = new ComboBox<>();
        cbKornsort.setPromptText("Vælg kornsort");
        cbKornsort.getItems().addAll(Kornsort.EVERGREEN, Kornsort.IRINA, Kornsort.STAIRWAY);
        cbKornsort.setPrefWidth(500);
        pane.add(cbKornsort, 0, 5);

        Label lblKornsort = new Label("Kornsort");
        lblKornsort.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblKornsort, 1, 5);

        //skriv ingen i rygemateriale - String
        txfRygemateriale = new TextField();
        txfRygemateriale.setPromptText("F.eks. 'ingen'");
        txfRygemateriale.setPrefWidth(500);
        pane.add(txfRygemateriale, 0, 6);

        Label lblRygemarteriale = new Label("Rygemarteriale");
        lblRygemarteriale.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblRygemarteriale, 1, 6);

        txfMængdeDestilat = new TextField();
        txfMængdeDestilat.setPromptText("F.eks. 500 i Liter");
        txfMængdeDestilat.setPrefWidth(500);
        pane.add(txfMængdeDestilat, 0, 7);

        Label lblMængdeDestilat = new Label("Mængde destilat");
        lblMængdeDestilat.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblMængdeDestilat, 1, 7);

        //Dropdwon af medarbejder valg
        cbMedarbejder = new ComboBox<>();
        cbMedarbejder.setPromptText("Vælg medarbejder");
        cbMedarbejder.getItems().addAll(controller.getAllMedarbejder());
        cbMedarbejder.setPrefWidth(500);
        pane.add(cbMedarbejder, 0, 8);

        Label lblMedarbejder = new Label("Medarbejder");
        lblMedarbejder.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblMedarbejder, 1, 8);
    }

    private void opretDestilleringButton(GridPane pane) {
        Button bntOpretDestillering = new Button("Opret destillering");
        bntOpretDestillering.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        bntOpretDestillering.setPrefWidth(150);
        bntOpretDestillering.setPrefHeight(50);

        bntOpretDestillering.setOnAction(event -> {
            try {
                // Tjekker om felter og dropdwons er tomme
                if (dpDato.getValue() == null || cbMaltbatch.getValue() == null ||
                        cbKornsort.getValue() == null || cbMedarbejder.getValue() == null ||
                        txfMængdeDestilat.getText().trim().isEmpty() ||
                        txfAlkoholProcent.getText().trim().isEmpty() ||
                        txfNewMakeNummer.getText().trim().isEmpty()) {
                    showAlert("Advarsel", "Udfyld venligst alle valgfelter.");
                    return;
                }

                //Konventere text to numbers
                double alkoholProcent = Double.parseDouble(txfAlkoholProcent.getText().trim());
                int newMakeNummer = Integer.parseInt(txfNewMakeNummer.getText().trim());
                double mængdeLiter = Double.parseDouble(txfMængdeDestilat.getText().trim());
                String rygemateriale = txfRygemateriale.getText().trim();

                //Validere at alkohol procent er over 40% og under 100%
                if (alkoholProcent < 40 || alkoholProcent > 100) {
                    showAlert("Advarsel", "Alkoholprocent skal være mellem 40 og 100");
                    return;
                }

                //Laver MængdeDestillat objet
                MængdeDestillat mængdeDestillat = controller.createMængdeDestillat(mængdeLiter);

                //Creat Destillering
                controller.createDestillering(dpDato.getValue(), alkoholProcent, newMakeNummer, cbMaltbatch.getValue(),
                        rygemateriale, cbKornsort.getValue(), mængdeDestillat, cbMedarbejder.getValue());

                showInfo("Succes", "Destillering oprettet");

                // Skudsikker nulstilling
                pane.getChildren().clear();
                initContent(pane);

            } catch (NumberFormatException exception) {
                showAlert("Fejl i indtastning", "Alkohol procent, New Make Nummer og Mængde destillat skal være korrekte tal.");
            } catch (IllegalArgumentException exception) {
                showAlert("Ugyldig data", exception.getMessage());
            }

        });

        pane.add(bntOpretDestillering, 1, 10);
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
