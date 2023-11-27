package com.example.gitprojektgit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class zmianaScen {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nazwaUzytkownika;
    @FXML
    private TextField haslo;
    @FXML
    private TextField potwierdzHaslo;
    @FXML
    private Label zleDane;

    public void zaloguj(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studioNagran.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        //sprawdza czy dane sa poprawne
        if(nazwaUzytkownika.getText().equals("admin") && haslo.getText().equals("admin123")){
            //jesli poprawne to zmienia scene na studio nagran
            stage.setScene(scene);
            stage.show();
        } else if (nazwaUzytkownika.getText().isEmpty() || haslo.getText().isEmpty()) {
            //jak pola sa puste
            zleDane.setText("Uzupełnij dane.");
        }
        else{
            //jak zle dane
            zleDane.setText("Podano złe dane.");
        }
    }

    public void zarejestrujUzytkownika(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studioNagran.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //do zrobienia jak bedzie baza danych -> dodanie podanych danych do bazy
        if (nazwaUzytkownika.getText().isEmpty() || haslo.getText().isEmpty() || potwierdzHaslo.getText().isEmpty()) {
            //jak pola sa puste
            zleDane.setText("Uzupełnij dane.");
        }
        else{
            stage.setScene(scene);
            stage.show();
        }
    }

    public void rejestracja(ActionEvent event) throws IOException{
        //zmiana sceny na scene z rejestracja
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rejestracja.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logowanie(ActionEvent event) throws IOException{
        //zmiana sceny na scene z logowaniem
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
