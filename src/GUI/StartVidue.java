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
    public void init() throws Exception{
        Istorage storage = new Storage();
        controller = new Controller(storage);
        controller.createSomeObject();;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sall whiskey destilleri");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane, 800, 500);
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
        tabDestillering.setContent(new OpretDestilleringVindue(controller));

        Tab tabFadLager = new Tab("Se fad lager");
        tabFadLager.setContent(new SeFadLagerVindue());

        Tab tabProduktLager = new Tab("Se produkt lager");
        tabProduktLager.setContent(new SeProduktLagerVindue());

        Tab tabOpretFad = new Tab("Opret fad");
        tabOpretFad.setContent(new OpretFadVindue());

        Tab tabOpretLager = new Tab("Opret lager");
        tabOpretLager.setContent(new OpretLagerVindue());

        Tab tabRegisterFadplacering = new Tab("Register fadplacering");
        tabRegisterFadplacering.setContent(new RegisterFadplaceringVindue());

        Tab tabRegisterPaafyldningAfFad = new Tab("Register påfyldning af fad");
        tabRegisterPaafyldningAfFad.setContent(new RegisterPaafyldningAfFadVindue());

        tabPane.getTabs().addAll(tabDestillering, tabOpretFad, tabOpretLager, tabRegisterFadplacering, tabRegisterPaafyldningAfFad, tabFadLager, tabProduktLager);

        pane.setCenter(tabPane);
    }
}
