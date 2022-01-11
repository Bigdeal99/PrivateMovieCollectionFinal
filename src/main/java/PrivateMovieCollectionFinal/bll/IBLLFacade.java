package PrivateMovieCollectionFinal.bll;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import javafx.collections.ObservableList;

import java.util.List;

public interface IBLLFacade {
    public List<Category> getAllCategories() throws bllException;

    public List<Movie> getAllMovies() throws bllException;

    public Movie createMovie(String name, int rating, int imdbrating, String url) throws bllException;

    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws bllException;

    public void deleteMovie(Movie selectedItem) throws bllException;

    public Category createCategory(String name) throws bllException;

    public Category updatedCategory(Category editingList, String name) throws bllException;

    public void deleteCategory(Category selectedItem) throws bllException;

    public void addToCategory(Category selectedItem, Movie selectedMovie) throws bllException;

    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws bllException;

    public ObservableList<Movie> searchMovie(ObservableList<Movie> currentMovies, String movieToFind);

    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws bllException;

    public Movie updateMovieDate(Movie selectedItem) throws bllException;

}
