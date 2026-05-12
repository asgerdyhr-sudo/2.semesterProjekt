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

public class OpretDestilleringVindue extends GridPane {
    private final Controller controller;


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

        //Knap til at oprette destillering
        Button bntOpretDestillering = new Button("Opret destillering");
        bntOpretDestillering.setFont(Font.font("Arial",FontWeight.BOLD,12));
        bntOpretDestillering.setPrefWidth(150);
        bntOpretDestillering.setPrefHeight(50);
        pane.add(bntOpretDestillering,1,9);

        //popup med oprettet destillering eller de forskelliger fejl der kan forekomme eller mangler

    }

    private void overksrift(GridPane pane) {
        Label lblTitle = new Label("Opret destillering");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }

    private void textAndLabels(GridPane pane) {
        //vælg dato - DatePicer
        DatePicker dpDato = new DatePicker();
        dpDato.setPrefWidth(500);
        pane.add(dpDato,0,1);

        Label lblDato = new Label("Dato");
        lblDato.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblDato,1,1);

        //Skriv alkohol procent (double)
        TextField txfAlkoholProcent = new TextField();
        txfAlkoholProcent.setPrefWidth(500);
        pane.add(txfAlkoholProcent,0,2);

        Label lblAlkoholProcent = new Label("Alkohol procent");
        lblAlkoholProcent.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblAlkoholProcent,1,2);

        //skriv new make nummer (int)
        TextField txfNewMakeNummer = new TextField();
        txfNewMakeNummer.setPrefWidth(500);
        pane.add(txfNewMakeNummer,0,3);

        Label lblNewMakeNummer = new Label("New Make Nummer");
        lblNewMakeNummer.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblNewMakeNummer,1,3);

        //Vælg maltBatch - dropdown med valgmulgiheder
        ComboBox<String> cbMaltbatch = new ComboBox<>();
        cbMaltbatch.getItems().addAll("Batch 1", "Batch 2", "Batch 3", "Batch 4", "Batch 5", "batch 6");
        cbMaltbatch.setPrefWidth(500);
        pane.add(cbMaltbatch, 0, 4);

        Label lblMaltbatch = new Label("Maltbatch");
        lblMaltbatch.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblMaltbatch, 1, 4);

        //vælg kornsort - dropdown med enums
        ComboBox<Kornsort> cbKornsort = new ComboBox<>();
        cbKornsort.getItems().addAll(Kornsort.EVERGREEN,Kornsort.IRINA,Kornsort.STAIRWAY);
        cbKornsort.setPrefWidth(500);
        pane.add(cbKornsort,0,5);

        Label lblKornsort = new Label("Kornsort");
        lblKornsort.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblKornsort,1,5);

        //skriv ingen i rygemateriale - String
        TextField txfRygemateriale = new TextField();
        txfRygemateriale.setPrefWidth(500);
        pane.add(txfRygemateriale,0,6);

        Label lblRygemarteriale = new Label("Rygemarteriale");
        lblRygemarteriale.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblRygemarteriale,1,6);

        //Dropdwon af medarbejder valg
        ComboBox<Medarbejder> cbMedarbejder = new ComboBox<>();
        cbMedarbejder.getItems().addAll(controller.getAllMedarbejder());
        cbMedarbejder.setPrefWidth(500);
        pane.add(cbMedarbejder,0,7);

        Label lblMedarbejder = new Label("Medarbejder");
        lblMedarbejder.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblMedarbejder,1,7);
    }
}
