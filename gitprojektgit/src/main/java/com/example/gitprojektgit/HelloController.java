package com.example.gitprojektgit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nazwaUzytkownika;
    @FXML
    private TextField haslo;
    @FXML
    private Label text;

    @FXML
    protected void zaloguj()
    {
        String nazwa = "Marek";
        String haslo1 = "marek123";

        if(nazwaUzytkownika.getText().equals(nazwa) && haslo.getText().equals(haslo1)){
            text.setText("Zalogowales sie!");
        }
        else{
            text.setText("Zle dane :(");
        }

    }
}