package com.example.gitprojektgit;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class zmianaNazwyStudia {
    public static String pokazOkno() throws IOException {
        //tworzenie nowego okna
        Stage stage = new Stage();
        //zebt nie mozna bylo kliknac nic innego poza nowym oknem
        stage.initModality(Modality.APPLICATION_MODAL);
        //wyglad okna
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label tekst = new Label();
        tekst.setText("Zmień nazwę swojego studia!");
        TextField nazwaStudia = new TextField();
        nazwaStudia.setMaxWidth(150);
        Button zapisz = new Button();
        zapisz.setText("Zapisz i zamknij");
        zapisz.setOnAction(e->{
            //sprawdza czy pole nie jest puste
            if(nazwaStudia.getText().isEmpty()){
                Label pustyTekst = new Label();
                pustyTekst.setTextFill(Paint.valueOf("RED"));
                pustyTekst.setText("Wypełnij pole.");
                layout.getChildren().add(pustyTekst);
            }
            else{
                stage.close();
            }
        });
        layout.getChildren().addAll(tekst,nazwaStudia,zapisz);

        //ustawienie sceny
        Scene scene = new Scene(layout, 300, 200);
        stage.setTitle("Nazwa studia");
        stage.setScene(scene);
        stage.showAndWait();
        //zwraca nowa nazwe studia
        return nazwaStudia.getText();
    }

}
