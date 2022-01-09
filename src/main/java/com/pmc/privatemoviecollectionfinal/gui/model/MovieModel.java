package com.pmc.privatemoviecollectionfinal.gui.model;

import com.pmc.privatemoviecollectionfinal.be.Movie;
import com.pmc.privatemoviecollectionfinal.bll.BLLFacade;
import com.pmc.privatemoviecollectionfinal.bll.Exception.bllException;
import com.pmc.privatemoviecollectionfinal.bll.IBLLFacade;
import com.pmc.privatemoviecollectionfinal.gui.exceptions.modelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class MovieModel {
    private static final MovieModel MovieSingleton = new MovieModel();
    private final IBLLFacade logiclayer;
    private ObservableList<Movie> allMovies;

    /*
    Initialises the logic layer manager
     */
    public MovieModel() {
        logiclayer = new BLLFacade();
    }

    /* Static 'instance' method */
    public static MovieModel getInstance() {return MovieSingleton;}

    /*
    Gets all categories from database and then returns a string list of all categories
     */
    public ObservableList<Movie> getAllMovies() throws modelException {
        allMovies = FXCollections.observableArrayList();
        allMovies.addAll(logiclayer.getAllMovies());
        return allMovies;
    }

    public ObservableList<Movie> getCurrentMovies() throws modelException{
        return allMovies;
    }

    public void createMovie(String name, int rating, int imdbrating, String url) throws modelException {
        Movie createdMovie;
        createdMovie = logiclayer.createMovie(name, rating, imdbrating, url);
        allMovies.add(createdMovie);
    }

    public void updateMovie(Movie movieToEdit, int movieIndex, String name, int rating, int imdbrating, String url) throws modelException {
        Movie updatedMovie;
        updatedMovie = logiclayer.updateMovie(movieToEdit, name, rating, imdbrating, url);
        allMovies.set(movieIndex, updatedMovie);
    }

    public void deleteMovie(Movie selectedItem, int selectedIndex) throws modelException {
        logiclayer.deleteMovie(selectedItem);
        allMovies.remove(selectedIndex);
    }

    public ObservableList<Movie> search(ObservableList<Movie> currentMovies, String movieToFind) {
        return logiclayer.searchMovie(currentMovies, movieToFind);
    }

    public void updateMovieRating(Movie selectedItem, int movieIndex, Integer newRating) throws modelException {
        Movie updatedMovie;
        updatedMovie = logiclayer.updateMovieRating(selectedItem, newRating);
        allMovies.set(movieIndex, updatedMovie);
    }

    public void updateMovieDate(Movie selectedItem, int selectedIndex) throws modelException {
        Movie updatedMovie;
        updatedMovie = logiclayer.updateMovieDate(selectedItem);
        allMovies.set(selectedIndex, updatedMovie);
    }
}
