package PrivateMovieCollectionFinal.bll;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.DALFacade;
import PrivateMovieCollectionFinal.dal.IDALFacade;
import javafx.collections.ObservableList;

import java.util.List;

public class BLLFacade implements IBLLFacade{

    private IDALFacade dalFacade;

    public BLLFacade() {
        dalFacade = new DALFacade();
    }

    @Override
    public List<Movie> getAllMovies() {
        return dalFacade.getAllMovies();
    }

    @Override
    public Movie createMovie(String name, int rating, int imdbrating, String url) {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) {
        return null;
    }

    @Override
    public void deleteMovie(Movie selectedItem) {

    }

    @Override
    public ObservableList<Movie> searchMovie(ObservableList<Movie> currentMovies, String movieToFind) {
        return null;
    }

    @Override
    public Movie updateMovieRating(Movie selectedItem, Integer newRating) {
        return null;
    }

    @Override
    public Movie updateMovieDate(Movie selectedItem) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category createCategory(String name) {
        return null;
    }

    @Override
    public Category updatedCategory(Category editingList, String name) {
        return null;
    }

    @Override
    public void deleteCategory(Category selectedItem) {

    }

    @Override
    public void addToCategory(Category selectedItem, Movie selectedMovie) {

    }

    @Override
    public void removeFromCategory(Category selectedItem, Movie selectedMovie) {

    }
}
