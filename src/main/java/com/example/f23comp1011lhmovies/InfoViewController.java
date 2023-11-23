package com.example.f23comp1011lhmovies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoViewController implements LoadMovie{

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label languageLabel;

    @FXML
    private Label plotLabel;

    @FXML
    private Label ratedLabel;

    @FXML
    private ListView<Ratings> ratingsListView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private void backToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }

    public void loadData(String imdbID)
    {
        try {
            MovieDetails movieDetails = APIUtility.getMovieDetails(imdbID);
            genreLabel.setText(movieDetails.getGenre());
            imageView.setImage(new Image(movieDetails.getPosterURL()));
            languageLabel.setText(movieDetails.getLanguage());
            plotLabel.setText(movieDetails.getPlot());
            ratedLabel.setText(movieDetails.getRated());
            titleLabel.setText(movieDetails.getTitle());
            yearLabel.setText(movieDetails.getYear());

            ratingsListView.getItems().addAll(movieDetails.getRatings());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e)
        {
            imageView.setImage(new Image(
                    Main.class.getResourceAsStream("images/default_poster.png")));
        }
    }

}
