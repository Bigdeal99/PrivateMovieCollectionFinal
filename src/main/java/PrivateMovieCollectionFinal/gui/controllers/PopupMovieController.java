/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateMovieCollectionFinal.gui.controllers;

import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import PrivateMovieCollectionFinal.gui.exceptions.modelException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import PrivateMovieCollectionFinal.gui.model.MovieModel;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.toIntExact;

/**
 * FXML Controller class
 *
 * @author nedas
 */
public class PopupMovieController implements Initializable {

    @FXML
    private Label specificFunctionLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ratingField;
    @FXML
    private Label timeField;
    @FXML
    private Label urlField;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField IMDBratingField;

    private boolean isEditing = false;
    private MovieModel movieModel;
    private MediaPlayer mediaPlayer;
    private Movie movieToEdit;
    private int movieIndex;
    MainWindowController controller1;
    private ObservableList<Movie> observableListMovie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movieModel = MovieModel.getInstance();
        try {
            observableListMovie = movieModel.getCurrentMovies(); //Loads all movies
        } catch (modelException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void chooseURL(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop")); //Sets the directory to the desktop
        fileChooser.setTitle("Select song");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Movie Files", "*.mp4", "*.mpeg4"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            urlField.setText(selectedFile.getAbsolutePath());
            mediaPlayer = new MediaPlayer(new Media(new File(selectedFile.getAbsolutePath()).toURI().toString())); // Sets up the media object in order to get time of the song
            setMediaPlayerTime(); // Gets time of the movie
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveMovie(ActionEvent event) throws modelException, bllException {
        boolean isFound = false;
        int i = toIntExact(Math.round(mediaPlayer.getMedia().getDuration().toSeconds())); // Rounds up the seconds to an int so it can be inserted into the database
        String name = nameField.getText().trim(); //Eliminates all spaces (front and back. However not in the middle of the string )
        if (name != null && name.length() > 0 && name.length() < 50 && urlField.getText() != null && urlField.getText().length() != 0 && i > 0) { // Checks if the fields are not empty .
            for (Movie movie : observableListMovie) {
                if (movie.getName() == null ? name == null : movie.getName().equals(name)) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                int userScore;
                if (ratingField.getText() == null || ratingField.getText().length() <= 0 || ratingField.getText().equals("")) {
                    userScore = 0;
                } else if (Integer.parseInt(ratingField.getText()) < 0 || Integer.parseInt(ratingField.getText()) > 10) {
                    userScore = 0;
                } else {
                    userScore = Integer.parseInt(ratingField.getText());
                }
                int imdbScore;
                if (IMDBratingField.getText() == null || IMDBratingField.getText().length() <= 0 || IMDBratingField.getText().equals("")) {
                    imdbScore = 0;
                } else if (Integer.parseInt(IMDBratingField.getText()) < 0 || Integer.parseInt(IMDBratingField.getText()) > 10) {
                    imdbScore = 0;
                } else {
                    imdbScore = Integer.parseInt(IMDBratingField.getText());
                }
                if (!isEditing) { // If not editing . Creates movie
                    movieModel.createMovie(name, userScore, imdbScore, urlField.getText());
                    errorLabel.setText("Success: Successfully created the movie");
                } else { // If editing. Modifies the movie in database and all categories
                    movieModel.updateMovie(movieToEdit, movieIndex, name, userScore, imdbScore, urlField.getText());
                    errorLabel.setText("Success: Successfully updated the movie");
                }
            } else {
                errorLabel.setText("Error: Names should not be the same");
            }
        } else {
            errorLabel.setText("Error: Check if you have inserted a name and selected the correct file");
        }
        controller1.refreshMovieList(isEditing); // Refreshes the list in main window to reflect changes
    }

    /*
    Sets up time.
     */
    private void setMediaPlayerTime() {
        mediaPlayer.setOnReady(() -> { //Once the media file is loaded do the following things
            String averageSeconds = String.format("%1.0f", mediaPlayer.getMedia().getDuration().toSeconds());
            int minutes = Integer.parseInt(averageSeconds) / 60; //Gets minutes
            int seconds = Integer.parseInt(averageSeconds) % 60; // Gets seconds
            if (10 > seconds) { // If the value is under 10 seconds . Prevent from showing 0:x and turn into 0:0X 
                timeField.setText(minutes + ":0" + seconds);
            } else {
                timeField.setText(minutes + ":" + seconds);
            }
        });
    }

    /*
    Sets up the controller for the main window
     */
    void setController(MainWindowController controller1) {
        this.controller1 = controller1;
        if (isEditing) {
            specificFunctionLabel.setText("Editing Movie data");
        } else {
            specificFunctionLabel.setText("Create Movie");
        }
    }

    void setInfo(Movie selectedItem, int movieIndex) {
        isEditing = true;
        movieToEdit = selectedItem;
        this.movieIndex = movieIndex;
        nameField.setText(selectedItem.getName());
        ratingField.setText("" + selectedItem.getUserRating());
        timeField.setText("" + selectedItem.getLastView());
        IMDBratingField.setText("" + selectedItem.getImdbRating());
        urlField.setText(selectedItem.getUrl());

        mediaPlayer = new MediaPlayer(new Media(new File(selectedItem.getUrl()).toURI().toString()));
        setMediaPlayerTime(); // Sets up time field
    }
}
