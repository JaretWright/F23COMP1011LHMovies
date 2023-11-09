module com.example.f23comp1011lhmovies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;

    opens com.example.f23comp1011lhmovies to javafx.fxml;
    exports com.example.f23comp1011lhmovies;
}