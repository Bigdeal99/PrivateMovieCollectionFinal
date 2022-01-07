package com.pmc.privatemoviecollectionfinal.gui.controllers;

import com.pmc.privatemoviecollectionfinal.gui.model.MovieModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    private MovieModel movieModel;

    public MainController( ) {
        this.movieModel = new MovieModel();
    }

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(movieModel.getAllMovies());
        movieModel.getAllMovies();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}