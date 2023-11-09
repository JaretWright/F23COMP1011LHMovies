module com.example.f23comp1011lhmovies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f23comp1011lhmovies to javafx.fxml;
    exports com.example.f23comp1011lhmovies;
}