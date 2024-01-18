package com.example.gitprojektgit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Muzyka {
    private int id;
    private String autor;
    private String utwor;
    private String album;

    public Muzyka(int id, String autor, String utwor, String album) {
        this.id = id;
        this.autor = autor;
        this.utwor = utwor;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getUtwor() {
        return utwor;
    }

    public String getAlbum() {
        return album;
    }

    public static List<Muzyka> pobierzDaneZBazy() {
        List<Muzyka> listaMuzyki = new ArrayList<>();

        String query = "SELECT ID, Autor, Utwor, Album FROM muzyka";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String autor = resultSet.getString("Autor");
                String tytul = resultSet.getString("Utwor");
                String album = resultSet.getString("Album");

                Muzyka muzyka = new Muzyka(id, autor, tytul, album);
                listaMuzyki.add(muzyka);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Obsługa błędu pobierania danych
        }

        return listaMuzyki;
    }

    public static void main(String[] args) {
        List<Muzyka> listaMuzyki = Muzyka.pobierzDaneZBazy();

        for (Muzyka muzyka : listaMuzyki) {
            System.out.println("ID: " + muzyka.getId());
            System.out.println("Autor: " + muzyka.getAutor());
            System.out.println("Utwor: " + muzyka.getUtwor());
            System.out.println("Album: " + muzyka.getAlbum());
            System.out.println();
        }
    }
}

