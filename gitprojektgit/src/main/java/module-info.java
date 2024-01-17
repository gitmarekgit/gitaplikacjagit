module com.example.gitprojektgit {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.gitprojektgit to javafx.fxml;
    exports com.example.gitprojektgit;
}