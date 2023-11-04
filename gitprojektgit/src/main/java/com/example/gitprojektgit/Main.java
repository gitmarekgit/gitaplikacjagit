package com.example.gitprojektgit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    }

    //funckja ktora zmienia scene
    public void zmienScene(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        mainStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}