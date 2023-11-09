package com.example.f23comp1011lhmovies;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-movies-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movies Emporium");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        try {
            APIUtility.callAPI("Back to the future");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        launch();
    }
}