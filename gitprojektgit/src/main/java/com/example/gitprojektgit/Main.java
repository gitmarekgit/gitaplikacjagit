package com.example.gitprojektgit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        //glowne okno i startowa scena (logowanie)
        mainStage = stage;
        mainStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600 , 400);

        stage.setTitle("gitprojektgit");
        stage.setScene(scene);
        stage.show();

        //jak sie kliknie X to odpala sie metoda zamknijAplikacje
        stage.setOnCloseRequest(event ->{
            //.consume zeby aplikacja sie nie wylaczyla nawet jak klikniemy cancel
            event.consume();
            zamknijAplikacje(stage);
        } );
    }

    public void zamknijAplikacje(Stage stage){
        //wyskakuje okienko ktore pyta czy napewno chcesz wyjsc
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Aplikacja zostanie wyłączona");
        alert.setContentText("Czy napewno chcesz wyjść?");

        if(alert.showAndWait().get()== ButtonType.OK){
            //jak kliknie sie ok to sie wylacza a jak cancel to wraca do poprzedniej sceny
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}