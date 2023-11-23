package com.example.f23comp1011lhmovies;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SearchMovieController {

    @FXML
    private Label infoLabel;

    @FXML
    private ListView<MovieInfo> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox resultsVBox;

    @FXML
    private void initialize()
    {
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        msgLabel.setVisible(false);
        resultsVBox.setVisible(false);

        //configure the listview to know when a movie is selected and show the
        //poster art
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, movieSelected)->{
                    if (movieSelected!= null)
                    {
                        selectedVBox.setVisible(true);
                        try {
                            posterImageView.setImage(new Image(movieSelected.getPoster()));
                        }catch (IllegalArgumentException e)
                        {
                            posterImageView.setImage(new Image(
                                    Main.class.getResourceAsStream("images/default_poster.png")));
                        }
                    }
                    else
                    {
                        selectedVBox.setVisible(false);
                    }

                });
    }

    @FXML
    private void search()
    {
        listView.getItems().clear();
        try {
            APIResponse apiResponse = APIUtility.callAPI(searchTextField.getText().trim());
            if (apiResponse.getMovies().size()>0)
            {
                resultsVBox.setVisible(true);
                listView.getItems().addAll(apiResponse.getMovies());
                infoLabel.setText("Showing "+listView.getItems().size() + " of " +
                        apiResponse.getTotalResults());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
