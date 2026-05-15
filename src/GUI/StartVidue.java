package GUI;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import storage.Istorage;
import storage.Storage;

public class StartVidue extends Application {
    private Controller controller;

    @Override
    public void init() throws Exception {
        Istorage storage = new Storage();
        controller = new Controller(storage);
        controller.createSomeObjects();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sall whiskey destilleri");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(BorderPane pane) {
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");
        Label lblTitel = new Label("Sall Whiskey Destilleri");
        lblTitel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        topBar.getChildren().add(lblTitel);
        pane.setTop(topBar);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabDestillering = new Tab("Opret destillering");
        OpretDestilleringVindue opretDestilleringVindue = new OpretDestilleringVindue(controller);
        tabDestillering.setContent(opretDestilleringVindue);
        tabDestillering.setOnSelectionChanged(event -> {
            if (tabDestillering.isSelected()) {
                opretDestilleringVindue.updateData();
            }
        });

        Tab tabOpretFad = new Tab("Opret fad");
        OpretFadVindue opretFadVindue = new OpretFadVindue(controller);
        tabOpretFad.setContent(opretFadVindue);
        tabOpretFad.setOnSelectionChanged(event -> {
            if (tabOpretFad.isSelected()) {
                opretFadVindue.updateData();
            }
        });

        Tab tabOpretLager = new Tab("Opret lager");
        tabOpretLager.setContent(new OpretLagerVindue(controller));

        Tab tabRegisterFadplacering = new Tab("Register fadplacering");
        RegisterFadplaceringVindue registerFadplaceringVindue = new RegisterFadplaceringVindue(controller);
        tabRegisterFadplacering.setContent(registerFadplaceringVindue);

        tabRegisterFadplacering.setOnSelectionChanged(event -> {
            if (tabRegisterFadplacering.isSelected()) {
                registerFadplaceringVindue.updateData();
            }
        });

        Tab tanRegisterDestillat = new Tab("Register destillat");
        RegisterDestillatVindue registerDestillatVindue = new RegisterDestillatVindue(controller);
        tanRegisterDestillat.setContent(registerDestillatVindue);

        tanRegisterDestillat.setOnSelectionChanged(event -> {
            if (tanRegisterDestillat.isSelected()) {
                registerDestillatVindue.updateData();
            }
        });

        Tab tabRegisterPaafyldningAfFad = new Tab("Register påfyldning af fad");
        RegisterPaafyldningAfFadVindue registerPaafyldningAfFadVindue = new RegisterPaafyldningAfFadVindue(controller);
        tabRegisterPaafyldningAfFad.setContent(registerPaafyldningAfFadVindue);

        tabRegisterPaafyldningAfFad.setOnSelectionChanged(event -> {
            if (tabRegisterPaafyldningAfFad.isSelected()) {
                registerPaafyldningAfFadVindue.updateData();
            }
        });

        Tab tabFadLager = new Tab("Se fad lager");
        SeFadLagerVindue seFadLagerVindue = new SeFadLagerVindue(controller);
        tabFadLager.setContent(seFadLagerVindue);

        tabFadLager.setOnSelectionChanged(event -> {
            if (tabFadLager.isSelected()) {
                seFadLagerVindue.updateData();
            }
        });

        Tab tabProduktLager = new Tab("Se produkt lager");
        tabProduktLager.setContent(new SeProduktLagerVindue());


        tabPane.getTabs().addAll(tabDestillering, tabOpretFad, tabOpretLager, tabRegisterFadplacering, tanRegisterDestillat, tabRegisterPaafyldningAfFad, tabFadLager, tabProduktLager);

        pane.setCenter(tabPane);
    }
}
