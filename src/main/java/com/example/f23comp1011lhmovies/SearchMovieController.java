package com.example.f23comp1011lhmovies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Button fetchAllButton;

    private int page, totalNumOfMovies;

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
        page = 1;
        listView.getItems().clear();
        try {
            String movieName = searchTextField.getText().trim();
            APIResponse apiResponse = APIUtility.callAPI(movieName, page);
            if (apiResponse.getMovies().size()>0)
            {
                resultsVBox.setVisible(true);
                listView.getItems().addAll(apiResponse.getMovies());
                infoLabel.setText("Showing "+listView.getItems().size() + " of " +
                        apiResponse.getTotalResults());

                totalNumOfMovies = Integer.parseInt(apiResponse.getTotalResults());
                if (listView.getItems().size()<totalNumOfMovies)
                    fetchAllButton.setVisible(true);
                else
                    fetchAllButton.setVisible(false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getDetails(ActionEvent event) throws IOException {
        MovieInfo movieSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event,"info-view.fxml", movieSelected.getImdbID());
    }

    @FXML
    void fetchAll(ActionEvent event) {

    }

}
