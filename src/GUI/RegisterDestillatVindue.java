package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.Destillering;
import modul.Medarbejder;

public class RegisterDestillatVindue extends GridPane {
    private final Controller controller;
    private ComboBox<Destillering> cbDestillering;
    private DatePicker dpPåfyldningsDato;
    private TextField txfMængdeLiter;
    private TextField txfAlkoholProcent;
    private ComboBox<Medarbejder> cbMedarbejder;

    public RegisterDestillatVindue(Controller controller){
        this.controller = controller;
        this.initContent(this);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setGridLinesVisible(false);

        overskrift(pane);

        textAndDropdown(pane);

    }

    public void updateData(){
        if (cbDestillering != null){
            cbDestillering.getItems().setAll(controller.getAllDestillering());
            cbDestillering.getSelectionModel().clearSelection();
        }
        if (cbMedarbejder != null) {
            cbMedarbejder.getItems().setAll(controller.getAllMedarbejder());
            cbMedarbejder.getSelectionModel().clearSelection();
        }

        // Nulstil inputfelter (så vinduet føles “friskt” når man kommer ind på fanen igen)
        if (dpPåfyldningsDato != null) {
            dpPåfyldningsDato.setValue(null);
        }
        if (txfAlkoholProcent != null) {
            txfAlkoholProcent.clear();
        }
        if (txfMængdeLiter != null) {
            txfMængdeLiter.clear();
        }
    }

    private void textAndDropdown(GridPane pane) {
        //Vælg destillering
        cbDestillering = new ComboBox<>();
        cbDestillering.setPromptText("Vælg destillering");
        cbDestillering.getItems().addAll(controller.getAllDestillering());
        cbDestillering.setPrefWidth(500);
        pane.add(cbDestillering,0,1);

        Label lblDestillering = new Label("Destillering");
        lblDestillering.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblDestillering,1,1);

        //Vælg dato
        dpPåfyldningsDato = new DatePicker();
        dpPåfyldningsDato.setPromptText("Vælg påfyldnings dato");
        dpPåfyldningsDato.setPrefWidth(500);
        pane.add(dpPåfyldningsDato,0,2);

        Label lblPåfyldningsdato = new Label("Påfyldnings dato");
        lblPåfyldningsdato.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblPåfyldningsdato,1,2);

        //Vælg alkohol procent
        txfAlkoholProcent = new TextField();
        txfAlkoholProcent.setPromptText("F.eks. 63.5");
        txfAlkoholProcent.setPrefWidth(500);
        pane.add(txfAlkoholProcent,0,3);

        Label lblAlkoholProcent = new Label("Alkohol procent");
        lblAlkoholProcent.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblAlkoholProcent,1,3);

        //Vælg mængde
        txfMængdeLiter = new TextField();
        txfMængdeLiter.setPromptText("F.eks. 250 i liter");
        txfMængdeLiter.setPrefWidth(500);
        pane.add(txfMængdeLiter,0,4);

        Label lblMængdeLiter = new Label("Mængde");
        lblMængdeLiter.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblMængdeLiter,1,4);

        //Vælg medarbejder
        cbMedarbejder = new ComboBox<>();
        cbMedarbejder.setPromptText("Vælg medarbeder");
        cbMedarbejder.getItems().addAll(controller.getAllMedarbejder());
        cbMedarbejder.setPrefWidth(500);
        pane.add(cbMedarbejder,0,5);

        Label lblMedarbjder = new Label("Medarbejder");
        lblMedarbjder.setFont(Font.font("Arial",FontWeight.BOLD,14));
        pane.add(lblMedarbjder,1,5);
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Registrer destillat");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
}
