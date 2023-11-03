package com.example.gitprojektgit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.io.IOException;

public class studioNagran {
    @FXML
    Label nazwaStudia;

    public void zmienNazweStudia() throws IOException{
        //zmiana nazwy studia
        String nowaNazwaStudia = zmianaNazwyStudia.pokazOkno();
        nazwaStudia.setText(nowaNazwaStudia);
    }
}
