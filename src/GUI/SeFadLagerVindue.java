package GUI;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modul.*;

public class SeFadLagerVindue extends GridPane {
    private final Controller controller;
    private ListView<String> lwFad;
    private ComboBox<Lager> cbLager;
    private TextArea txaHistorik;

    public SeFadLagerVindue(Controller controller) {
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

        logik();
    }

    private void textAndLabels(GridPane pane) {
        cbLager = new ComboBox<>();
        cbLager.setPromptText("Vælg lager");
        cbLager.getItems().addAll(controller.getAllLager());
        cbLager.setPrefWidth(500);
        pane.add(cbLager, 0, 1);

        Label lblLager = new Label("Lager");
        lblLager.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pane.add(lblLager, 1, 1);

        lwFad = new ListView<>();
        lwFad.setPrefSize(500, 400);
        lwFad.setDisable(true);
        pane.add(lwFad, 0, 2);

        txaHistorik = new TextArea();
        txaHistorik.setPrefSize(300, 400);
        txaHistorik.setEditable(false);
        txaHistorik.setPromptText("Historik for valgt fad...");
        pane.add(txaHistorik, 1, 2);
    }

    private void logik() {
        cbLager.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lwFad.getItems().clear();
            txaHistorik.clear();
            if (newValue != null) {
                lwFad.setDisable(false);
                // Gennemgår alle reoler og hylder for at finde fadene på det valgte lager
                for (Reol reol : newValue.getReolList()) {
                    for (Hylde hylde : reol.getHyldeList()) {
                        if (hylde.getFad() != null) {
                            String fadInfo = hylde.getFad().toString() + " - " + reol + ", " + hylde;
                            lwFad.getItems().add(fadInfo);
                        }
                    }
                }
            } else {
                lwFad.setDisable(true);
            }
        });

        lwFad.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Find det korrekte fad ud fra den valgte tekst.
                Fad valgtFad = null;
                Lager valgtLager = cbLager.getValue();
                if (valgtLager != null) {
                    for (Reol reol : valgtLager.getReolList()) {
                        for (Hylde hylde : reol.getHyldeList()) {
                            if (hylde.getFad() != null) {
                                String fadInfo = hylde.getFad().toString() + " - " + reol + ", " + hylde;
                                if (fadInfo.equals(newValue)) {
                                    valgtFad = hylde.getFad();
                                    break;
                                }
                            }
                        }
                        if (valgtFad != null) break;
                    }
                }

                if (valgtFad != null) {
                    // Vi bruger bare almindelig streng-sammensætning (string concatenation)
                    String historik = "Historik for: " + valgtFad.getFadType() + " (" + valgtFad.getStørrelseLiter() + "L)\n";
                    historik += "Tidligere indhold: " + valgtFad.getTidligereIndhold() + "\n";
                    historik += "Leverandør: " + valgtFad.getLeverandør() + "\n\n";

                    if (valgtFad.getDestilatList().isEmpty()) {
                         historik += "Ingen destillater påfyldt endnu.";
                    } else {
                        for (Destillat destillat : valgtFad.getDestilatList()) {
                            historik += "Destillat Påfyldt: " + destillat.getPåfyldningsDato() + " (Alkohol: " + destillat.getAlkoholProcent() + "%)\n";
                            MængdeDestillat mængde = destillat.getMængdeDestillat();
                            if(mængde != null) {
                                for (Destillering destillering : mængde.getDestilleringList()) {
                                    historik += "  - Oprindelig Destillering:\n";
                                    historik += "      Dato: " + destillering.getDato() + "\n";
                                    historik += "      Kornsort: " + destillering.getKornsort() + "\n";
                                    historik += "      Maltbatch: " + destillering.getMaltbatch() + "\n";
                                    historik += "      Rygemateriale: " + destillering.getRygemateriale() + "\n";
                                    historik += "      Medarbejder: " + destillering.getMedarbejder().getNavn() + "\n";
                                }
                            }
                            historik += "\n";
                        }
                    }
                    txaHistorik.setText(historik);
                } else {
                    txaHistorik.setText("Historik for opslag:\n" + newValue + "\n\n(Kunne ikke finde faddata)");
                }
            } else {
                txaHistorik.clear();
            }
        });
    }

    // Metoden bruges til at holde data opdateret, hvis lagre oprettes, rettes eller slettes andetsteds
    public void updateData() {
        if (cbLager != null) {
            //Gemmer det lager der er blevet valgt
            Lager valgtLager = cbLager.getValue();
            //Ryder listen og henter dem på ny igennem controlleren
            cbLager.getItems().clear();
            cbLager.getItems().addAll(controller.getAllLager());
            if (valgtLager != null && cbLager.getItems().contains(valgtLager)) {
                cbLager.setValue(valgtLager);
            } else {
                lwFad.getItems().clear();
                lwFad.setDisable(true);
                txaHistorik.clear();
            }
        }
    }

    private void overskrift(GridPane pane) {
        Label lblTitle = new Label("Se fade på lager");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        pane.add(lblTitle, 0, 0);
        GridPane.setColumnSpan(lblTitle, 2);
    }
}
