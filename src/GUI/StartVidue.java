package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartVidue extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sall whiskey destilleri");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);
        pane.setAlignment(Pos.CENTER);

        // Overskrift
        Label lblTitel = new Label("Sall Whiskey Destilleri");
        lblTitel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitel, 0, 0);

        // Knapper
        Button btnOpretDestillering = new Button("Opret destillering");
        btnOpretDestillering.setMaxWidth(Double.MAX_VALUE);
        pane.add(btnOpretDestillering, 0, 1);

        Button btnOpretLager = new Button("Opret lager");
        btnOpretLager.setMaxWidth(Double.MAX_VALUE);
        pane.add(btnOpretLager, 0, 2);

        Button btnOpretFad = new Button("Opret fad");
        btnOpretFad.setMaxWidth(Double.MAX_VALUE);
        pane.add(btnOpretFad, 0, 3);

        Button btnSeFadLager = new Button("Se fad lager");
        btnSeFadLager.setMaxWidth(Double.MAX_VALUE);
        pane.add(btnSeFadLager, 0, 4);

        Button btnSeProduktLager = new Button("Se produkt lager");
        btnSeProduktLager.setMaxWidth(Double.MAX_VALUE);
        pane.add(btnSeProduktLager, 0, 5);

        // Handlinger til knapper
        btnOpretDestillering.setOnAction(event -> {
            OpretDestilleringVindue vindue = new OpretDestilleringVindue();
            vindue.show();
        });

        btnSeFadLager.setOnAction(event -> {
            SeFadLagerVindue vindue = new SeFadLagerVindue();
            vindue.show();
        });

        btnSeProduktLager.setOnAction(event -> {
            SeProduktLagerVindue vindue = new SeProduktLagerVindue();
            vindue.show();
        });

        btnOpretFad.setOnAction(event -> {
            OpretFadVindue vindue = new OpretFadVindue();
            vindue.show();
        });

        btnOpretLager.setOnAction(event -> {
            OpretLagerVindue vindue = new OpretLagerVindue();
            vindue.show();
        });
    }
}
