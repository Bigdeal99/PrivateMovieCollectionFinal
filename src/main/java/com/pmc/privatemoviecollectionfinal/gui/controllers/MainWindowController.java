package com.pmc.privatemoviecollectionfinal.gui.controllers;

import com.pmc.privatemoviecollectionfinal.be.Category;
import com.pmc.privatemoviecollectionfinal.be.Movie;
import com.pmc.privatemoviecollectionfinal.gui.model.MovieModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private Button playButton;
    @FXML
    private Button rateMovie;
    @FXML
    private TextField searchTextBox;
    @FXML
    private TableColumn<Movie, String> nameColumn;
    @FXML
    private TableColumn<Movie, Integer> timeColumn;
    @FXML
    private TableColumn<Category, String> CategoryNames;
    @FXML
    private TableColumn<Category, Integer> totalMovieCount;
    @FXML
    private TableColumn<Movie, String> CatMovieName;
    @FXML
    private TableColumn<Movie, Integer> imdbRating;
    @FXML
    private TableColumn<Movie, Integer> userRating;
    @FXML
    private TableView<Category> categoryTableView;
    @FXML
    private TableView<Movie> moviesInCategory;
    @FXML
    private TableView<Movie> movieTableView;

    private ObservableList<Movie> observableListMovie;
    private ObservableList<Category> observableListCategory;
    private MovieModel movieModel;
    @FXML
    private ChoiceBox<Integer> ratingChoice;


    public MainWindowController( ) {
        this.movieModel = new MovieModel();
    }



    public void playMovie(ActionEvent actionEvent) {
    }

    public void rateMovie(ActionEvent actionEvent) {
    }

    public void search(KeyEvent keyEvent) {
    }

    public void displayMoviesInCategory(MouseEvent mouseEvent) {
    }

    public void createCategory(ActionEvent actionEvent) {
    }

    public void editCategory(ActionEvent actionEvent) {
    }

    public void deleteCategory(ActionEvent actionEvent) {
    }

    public void removeMovie(ActionEvent actionEvent) {
    }

    public void addMovie(ActionEvent actionEvent) {
    }

    public void createMovie(ActionEvent actionEvent) {
    }

    public void editMovie(ActionEvent actionEvent) {
    }

    public void deleteMovie(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void refreshMovieList(boolean isEditing) {
    }

    public void setUpAlert(String message) {
    }

    public void refreshCategoryList() {
    }
}