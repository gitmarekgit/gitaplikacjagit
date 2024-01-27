package com.example.gitprojektgit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class studioNagran {

    @FXML
    private Label nazwaStudia;

    @FXML
    private TableView<Muzyka> tabelaMuzyki;

    private Lista lista;

    public void initialize() {
        lista = new Lista();
        lista.inicjalizujTabele(tabelaMuzyki);
    }

    @FXML
    public void zmienNazweStudia() {
        try {
            // zmiana nazwy studia
            String nowaNazwaStudia = zmianaNazwyStudia.pokazOkno();
            nazwaStudia.setText(nowaNazwaStudia);
        } catch (IOException e) {
            wyswietlKomunikatBledu("Błąd podczas zmiany nazwy studia.", e.getMessage());
        }
    }

    @FXML
    public void dodaj() {
        try {
            String nazwaUzytkownika = Session.getLoggedInUserName();
            String[] dane = oknoDodaj.dodaj(nazwaUzytkownika);
            // Dodaj utwór do listy
            lista.dodajUtworDoListy(dane[0], dane[1], dane[2], nazwaUzytkownika);
        } catch (IOException e) {
            wyswietlKomunikatBledu("Błąd podczas dodawania utworu.", e.getMessage());
        }
    }

    @FXML
    public void zamknijAplikacje(ActionEvent event) {
        // wyskakuje okienko, które pyta, czy napewno chcesz wyjść
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Aplikacja zostanie wyłączona");
        alert.setContentText("Czy napewno chcesz wyjść?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            // jak kliknie się OK to się wyłącza, a jak Cancel to wraca do poprzedniej sceny
            Stage stage = (Stage) nazwaStudia.getScene().getWindow();
            stage.close();
        }
    }

    private void wyswietlKomunikatBledu(String tytul, String tresc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tytul);
        alert.setHeaderText(null);
        alert.setContentText(tresc);
        alert.showAndWait();
    }
    @FXML
    public void cofnijDoPoprzedniejSceny(ActionEvent event) {
        try {
            // Załaduj scenę "studioNagran.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("studioNagran.fxml"));
            Parent root = loader.load();

            // Pobierz stadium (Stage) z obecnej sceny
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Ustaw nową scenę na stadium
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Obsłuż błąd ładowania sceny
        }
    }

}