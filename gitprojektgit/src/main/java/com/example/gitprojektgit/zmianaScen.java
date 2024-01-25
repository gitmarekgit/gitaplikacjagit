package com.example.gitprojektgit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @FXML
    private AnchorPane scenePane;

    public void zmienScene(ActionEvent event, String scena) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scena)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Metoda do sprawdzenia czy użytkownik istnieje w bazie danych
    private boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM logowanie WHERE Login = ? AND Haslo = ?";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metoda do dodawania nowego użytkownika do bazy danych
    private void registerUserInDatabase(String username, String password) {
        String query = "INSERT INTO logowanie (Login, Haslo) VALUES (?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tutaj można obsłużyć błąd związany z dodawaniem użytkownika do bazy danych
        }
    }

    public void zaloguj(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studioNagran.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        if (validateLogin(nazwaUzytkownika.getText(), haslo.getText())) {
            // Poprawne dane logowania, zmiana sceny na studioNagran.fxml
            String userName = nazwaUzytkownika.getText();
            Session.setLoggedInUserName(userName);  // Ustawienie informacji o zalogowanym użytkowniku
            stage.setScene(scene);
            stage.show();
        } else {
            // Złe dane logowania
            zleDane.setText("Podano złe dane.");
        }
    }

    public void zarejestrujUzytkownika(ActionEvent event) throws IOException {
        String hasloPierwsze = haslo.getText();
        String potwierdzoneHaslo = potwierdzHaslo.getText();

        if (nazwaUzytkownika.getText().isEmpty() || hasloPierwsze.isEmpty() || potwierdzoneHaslo.isEmpty()) {
            zleDane.setText("Uzupełnij dane.");
        } else if (!hasloPierwsze.equals(potwierdzoneHaslo)) {
            zleDane.setText("Hasła nie są identyczne.");
        } else {
            // Poprawne dane rejestracji, dodanie użytkownika do bazy
            registerUserInDatabase(nazwaUzytkownika.getText(), hasloPierwsze);
            // Wyświetlenie komunikatu i zmiana sceny na login.fxml
            zleDane.setText("Rejestracja udana. Zaloguj się ponownie.");
            zmienScene(event, "login.fxml");
        }
    }


    public void rejestracja(ActionEvent event) throws IOException {
        zmienScene(event, "rejestracja.fxml");
    }

    public void logowanie(ActionEvent event) throws IOException {
        zmienScene(event, "login.fxml");
    }

    public void listaUtworow(ActionEvent event) throws IOException {
        zmienScene(event, "studioNagranLista.fxml");
    }

    public void ustawienia(ActionEvent event) throws IOException {
        zmienScene(event, "ustawienia.fxml");
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

    @FXML
    private Label nazwaStudia;

    public void zmienNazweStudia() throws IOException{
        //zmiana nazwy studia
        String nowaNazwaStudia = zmianaNazwyStudia.pokazOkno();
        nazwaStudia.setText(nowaNazwaStudia);
    }

    public void ustawTrybJasny() throws IOException{
        scenePane.getStylesheets().add("file:/C:/Users/marek/Desktop/gitprojektgit/gitaplikacjagit/gitprojektgit/src/styles/light_mode.css");
        scenePane.getStylesheets().remove("file:/C:/Users/marek/Desktop/gitprojektgit/gitaplikacjagit/gitprojektgit/src/styles/dark_mode.css");
        System.out.println("lightmode");
    }

    public void ustawTrybCiemny() throws IOException{
        scenePane.getStylesheets().add("file:/C:/Users/marek/Desktop/gitprojektgit/gitaplikacjagit/gitprojektgit/src/styles/dark_mode.css");
        scenePane.getStylesheets().remove("file:/C:/Users/marek/Desktop/gitprojektgit/gitaplikacjagit/gitprojektgit/src/styles/light_mode.css");
        System.out.println("darkmode");
    }
}
