package com.example.gitprojektgit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class studioNagran {
    @FXML
    private Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label nazwaStudia;

    public void zmienNazweStudia() throws IOException{
        //zmiana nazwy studia
        String nowaNazwaStudia = zmianaNazwyStudia.pokazOkno();
        nazwaStudia.setText(nowaNazwaStudia);
    }

    public void zamknijAplikacje(ActionEvent event){
        //wyskakuje okienko ktore pyta czy napewno chcesz wyjsc
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Aplikacja zostanie wyłączona");
        alert.setContentText("Czy napewno chcesz wyjść?");

        if(alert.showAndWait().get()== ButtonType.OK){
            //jak kliknie sie ok to sie wylacza a jak cancel to wraca do poprzedniej sceny
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }

    public void dodaj() throws IOException {
        String[] dane = new String[]{};
        dane = oknoDodaj.dodaj();
    }
}
