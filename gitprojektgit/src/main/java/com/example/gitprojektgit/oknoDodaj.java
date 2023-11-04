package com.example.gitprojektgit;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.converter.FontConverter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class oknoDodaj {
    public static String[] dodaj() throws IOException {
        //tworzenie nowego okna
        Stage stage = new Stage();
        stage.setResizable(false);
        //zebt nie mozna bylo kliknac nic innego poza nowym oknem
        stage.initModality(Modality.APPLICATION_MODAL);

        //głowne okno
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.BASELINE_LEFT);
        layout.setPadding(new Insets(50));
        Label plyta = new Label("Nazwa płyty: ");
        TextField nazwaPlyty = new TextField();
        nazwaPlyty.setMaxWidth(300);
        Label tworca = new Label("Twórca: ");
        TextField daneTworcy = new TextField();
        daneTworcy.setMaxWidth(300);

        VBox przycisk = new VBox(10);
        Button dodaj = new Button("Dodaj płytę");
        dodaj.setOnAction(e->stage.close());
        dodaj.setPadding(new Insets(10));
        przycisk.setAlignment(Pos.CENTER);
        przycisk.setPadding(new Insets(10));
        przycisk.getChildren().add(dodaj);

        layout.getChildren().addAll(plyta,nazwaPlyty,tworca,daneTworcy,przycisk);
        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Dodaj nową płytę!");
        stage.setScene(scene);
        stage.showAndWait();

        return new String[]{nazwaPlyty.getText(), daneTworcy.getText()};
    }
}
