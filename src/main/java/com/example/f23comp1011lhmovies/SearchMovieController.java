package com.example.f23comp1011lhmovies;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class SearchMovieController {

    @FXML
    private TextField movieTextField;

    @FXML
    private void initialize()
    {
        movieTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            System.out.printf("Old Value: %s  new Value: %s%n",oldValue,newValue);
        });
    }

    private int getAge(LocalDate birthday)
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public class MovieChangeListener implements ChangeListener<String>{

        @Override
        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
            System.out.printf("Old Value: %s  new Value: %s%n",oldValue,newValue);
        }
    }
}
