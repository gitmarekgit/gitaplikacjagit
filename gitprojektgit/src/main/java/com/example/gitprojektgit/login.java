package com.example.gitprojektgit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class login {
    @FXML
    private TextField nazwaUzytkownika;
    @FXML
    private TextField haslo;
    @FXML
    private Label zleDane;
    @FXML
    private Button zaloguj;
    @FXML
    private Hyperlink zarejestruj;


    public void zalogujUzytkownika() throws IOException {
        //new Main aby miec mozliwosc zmiany sceny
        Main m = new Main();
        //sprawdza czy dane sa poprawne
        if(nazwaUzytkownika.getText().equals("admin") && haslo.getText().equals("admin123")){
            //jesli poprawne to zmienia scene na studio nagran
            m.zmienScene("studioNagran.fxml");
        } else if (nazwaUzytkownika.getText().isEmpty() || haslo.getText().isEmpty()) {
            //jak pola sa puste
            zleDane.setText("Uzupełnij dane.");
        }
        else{
            //jak zle dane
            zleDane.setText("Podano złe dane.");
        }
    }

    public void rejestracja() throws IOException{
        Main m = new Main();
        m.zmienScene("rejestracja.fxml");
    }
}