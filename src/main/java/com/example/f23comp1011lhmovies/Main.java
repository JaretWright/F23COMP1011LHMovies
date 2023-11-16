package com.example.f23comp1011lhmovies;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Movies Emporium");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/Logo.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

//        try {
//            APIResponse response = APIUtility.callAPI("Back to the future");
//            System.out.println(response.getResponse());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        launch();
    }
}