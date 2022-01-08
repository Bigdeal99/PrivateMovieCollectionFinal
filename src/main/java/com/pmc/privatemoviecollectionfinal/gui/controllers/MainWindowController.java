package com.pmc.privatemoviecollectionfinal.gui.controllers;

import com.pmc.privatemoviecollectionfinal.gui.model.MovieModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainWindowController {
    @FXML
    private Label welcomeText;

    private MovieModel movieModel;

    public MainWindowController( ) {
        this.movieModel = new MovieModel();
    }

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(movieModel.getAllMovies());
        movieModel.getAllMovies();
        welcomeText.setText("Welcome to JavaFX Application!");
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
}