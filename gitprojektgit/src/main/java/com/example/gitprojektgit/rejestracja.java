package com.example.gitprojektgit;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class rejestracja {
    @FXML PasswordField haslo;
    @FXML PasswordField potwierdzHaslo;
    @FXML TextField nazwaUzytkownika;

    public void logowanie() throws IOException{
        //zmiana sceny na logowanie jak sie kliknie link
        Main m = new Main();
        m.zmienScene("login.fxml");
    }

    public void zarejestrujUzytkownika() throws IOException{
        //do zrobienia jak bedzie baza danych -> dodanie podanych danych do bazy
        System.out.println("Zarejestrowano");
    }
}
