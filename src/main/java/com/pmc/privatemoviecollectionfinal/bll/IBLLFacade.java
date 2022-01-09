package com.pmc.privatemoviecollectionfinal.bll;

import com.pmc.privatemoviecollectionfinal.be.Category;
import com.pmc.privatemoviecollectionfinal.be.Movie;
import javafx.collections.ObservableList;

import java.util.List;

public interface IBLLFacade {
    public List<Movie> getAllMovies();

    Movie createMovie(String name, int rating, int imdbrating, String url);

    Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url);

    void deleteMovie(Movie selectedItem);

    ObservableList<Movie> searchMovie(ObservableList<Movie> currentMovies, String movieToFind);

    Movie updateMovieRating(Movie selectedItem, Integer newRating);

    Movie updateMovieDate(Movie selectedItem);

    Category getAllCategories();

    Category createCategory(String name);

    Category updatedCategory(Category editingList, String name);

    void deleteCategory(Category selectedItem);

    void addToCategory(Category selectedItem, Movie selectedMovie);

    void removeFromCategory(Category selectedItem, Movie selectedMovie);
}
