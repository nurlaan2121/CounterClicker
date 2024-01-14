module com.example.counterclicker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;


    opens com.example.counterclicker to javafx.fxml;
    exports com.example.counterclicker;
}