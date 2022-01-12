package PrivateMovieCollectionFinal.dal.dao;

import PrivateMovieCollectionFinal.be.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO {


    public List<Movie> getAllMovies() {
        List <Movie> allMovies= new ArrayList<>();

        return allMovies;

    }

    public Movie updateMovieRating(Movie selectedItem, Integer newRating) {
        return selectedItem;
    }

    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) {
        return movieToEdit;
    }

    public Movie createMovie(String name, int rating, int imdbrating, String url) {
        return null;
    }

    public void removeMovie(Movie selectedItem) {
    }

    public Movie updateMovieDate(Movie selectedItem) {
        return selectedItem;
    }
}
