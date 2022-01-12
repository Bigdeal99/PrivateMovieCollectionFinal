package PrivateMovieCollectionFinal.gui.model;

import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.BLLFacade;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import PrivateMovieCollectionFinal.bll.IBLLFacade;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import PrivateMovieCollectionFinal.gui.exceptions.modelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class MovieModel {
    private static final MovieModel MovieSingleton = new MovieModel();
    private final IBLLFacade IBLLFacade1;
    private ObservableList<Movie> allMovies;

    /*
    Initialises the logic layer manager
     */
    public MovieModel() {
        try {
            IBLLFacade1 = new BLLFacade();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Missing a required resource", e);
        }
    }

    /* Static 'instance' method */
    public static MovieModel getInstance() {return MovieSingleton;}

    /*
    Gets all categories from database and then returns a string list of all categories
     */
    public ObservableList<Movie> getAllMovies() throws modelException, bllException {
        allMovies = FXCollections.observableArrayList();
        try {
            allMovies.addAll(IBLLFacade1.getAllMovies());
        } catch (daoException e) {
            e.printStackTrace();
        }
        return allMovies;
    }

    public ObservableList<Movie> getCurrentMovies() throws modelException{
        return allMovies;
    }

    public void createMovie(String name, int rating, int imdbrating, String url) throws modelException, bllException {
        Movie createdMovie;
        try {
            createdMovie = IBLLFacade1.createMovie(name, rating, imdbrating, url);
            allMovies.add(createdMovie);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void updateMovie(Movie movieToEdit, int movieIndex, String name, int rating, int imdbrating, String url) throws modelException {
        Movie updatedMovie;
        try {
            updatedMovie = IBLLFacade1.updateMovie(movieToEdit, name, rating, imdbrating, url);
            allMovies.set(movieIndex, updatedMovie);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void deleteMovie(Movie selectedItem, int selectedIndex) throws modelException {
        try {
            IBLLFacade1.deleteMovie(selectedItem);
            allMovies.remove(selectedIndex);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public ObservableList<Movie> search(ObservableList<Movie> currentMovies, String movieToFind) {
        return IBLLFacade1.searchMovie(currentMovies, movieToFind);
    }

    public void updateMovieRating(Movie selectedItem, int movieIndex, Integer newRating) throws modelException {
        Movie updatedMovie;
        try {
            updatedMovie = IBLLFacade1.updateMovieRating(selectedItem, newRating);
            allMovies.set(movieIndex, updatedMovie);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }


    public void updateMovieDate(Movie selectedItem, int selectedIndex) throws modelException {
        Movie updatedMovie;
        try {
            updatedMovie = IBLLFacade1.updateMovieDate(selectedItem);
            allMovies.set(selectedIndex, updatedMovie);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }
}
