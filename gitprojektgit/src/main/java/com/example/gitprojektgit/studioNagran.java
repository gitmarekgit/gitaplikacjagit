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
    private Label nazwaStudia;

    public void zmienNazweStudia() throws IOException{
        //zmiana nazwy studia
        String nowaNazwaStudia = zmianaNazwyStudia.pokazOkno();
        nazwaStudia.setText(nowaNazwaStudia);
    }



    public void dodaj() throws IOException {
        String nazwaUzytkownika = Session.getLoggedInUserName();
        String[] dane = oknoDodaj.dodaj(nazwaUzytkownika);
    }
}
