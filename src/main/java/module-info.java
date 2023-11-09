module com.example.f23comp1011lhmovies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.f23comp1011lhmovies to javafx.fxml, com.google.gson;
    exports com.example.f23comp1011lhmovies;
}