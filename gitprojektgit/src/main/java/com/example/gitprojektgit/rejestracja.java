package com.example.gitprojektgit;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class rejestracja {
    @FXML PasswordField haslo;
    @FXML PasswordField potwierdzHaslo;
    @FXML TextField nazwaUzytkownika;
    @FXML TextField zleDane;

    public void logowanie() throws IOException{
        Main m = new Main();
        m.zmienScene("login.fxml");
    }

    public void zarejestrujUzytkownika() throws IOException{
        System.out.println("Zarejestrowano");
    }
}
