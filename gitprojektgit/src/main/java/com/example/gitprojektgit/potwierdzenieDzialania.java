package com.example.gitprojektgit;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class potwierdzenieDzialania {
    public static void pokazOkno(String wiadomosc, String tytul) throws IOException {
        //tworzenie nowego okna
        Stage stage = new Stage();
        //zebt nie mozna bylo kliknac nic innego poza nowym oknem
        stage.initModality(Modality.APPLICATION_MODAL);
        //wyglad okna
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label wiad = new Label();
        wiad.setText(wiadomosc);
        Button tak = new Button("Tak");
        tak.setOnAction(e->{
            //wszystko sie wylacza
            stage.close();
            Main.mainStage.close();
        });
        Button nie = new Button("Nie");
        nie.setOnAction(e->{
            //wylacza sie tylko to okno
            stage.close();
        });

        layout.getChildren().addAll(wiad,tak,nie);
        Scene scene = new Scene(layout, 300, 200);
        stage.setTitle(tytul);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
