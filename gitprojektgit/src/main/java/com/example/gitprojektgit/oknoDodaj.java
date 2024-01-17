package com.example.gitprojektgit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class oknoDodaj {

    public static String[] dodaj() throws IOException {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.BASELINE_LEFT);
        layout.setPadding(new Insets(50));

        Label tworca = new Label("Twórca: ");
        TextField daneTworcy = new TextField();
        daneTworcy.setMaxWidth(300);

        Label tytul = new Label("Tytuł: ");
        TextField nazwaTytul = new TextField();
        nazwaTytul.setMaxWidth(300);

        Label plyta = new Label("Nazwa płyty: ");
        TextField nazwaPlyty = new TextField();
        nazwaPlyty.setMaxWidth(300);

        VBox przycisk = new VBox(10);
        Button dodaj = new Button("Dodaj utwór");
        dodaj.setOnAction(e -> {
            stage.close();
            String[] dane = {daneTworcy.getText(), nazwaTytul.getText(), nazwaPlyty.getText()};
            registerUserInDatabase(dane[0], dane[1], dane[2]);
        });
        dodaj.setPadding(new Insets(10));
        przycisk.setAlignment(Pos.CENTER);
        przycisk.setPadding(new Insets(10));
        przycisk.getChildren().add(dodaj);

        layout.getChildren().addAll(tworca, daneTworcy, tytul, nazwaTytul, plyta, nazwaPlyty, przycisk);
        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Dodaj nowy utwór!");
        stage.setScene(scene);
        stage.showAndWait();

        return new String[]{daneTworcy.getText(), nazwaTytul.getText(), nazwaPlyty.getText()};
    }

    private static void registerUserInDatabase(String autor, String tytul, String album) {
        System.out.println("Before database operation");

        String query = "INSERT INTO muzyka (Autor, Utwor, Album) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            System.out.println("Setting values to PreparedStatement");
            preparedStatement.setString(1, autor);
            preparedStatement.setString(2, tytul);
            preparedStatement.setString(3, album);

            System.out.println("Executing SQL update");
            preparedStatement.executeUpdate();

            System.out.println("Database operation successful");
        } catch (SQLException e) {
            System.out.println("Database operation failed");
            e.printStackTrace();
        }

        System.out.println("After database operation");
    }
}
