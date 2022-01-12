package PrivateMovieCollectionFinal.bll;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import javafx.collections.ObservableList;

import java.util.List;

public interface IBLLFacade {
    public List<Category> getAllCategories() throws bllException, daoException;

    public List<Movie> getAllMovies() throws bllException, daoException;

    public Movie createMovie(String name, int rating, int imdbrating, String url) throws bllException, daoException;

    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws bllException, daoException;

    public void deleteMovie(Movie selectedItem) throws bllException, daoException;

    public Category createCategory(String name) throws bllException, daoException;

    public Category updatedCategory(Category editingList, String name) throws bllException, daoException;

    public void deleteCategory(Category selectedItem) throws bllException, daoException;

    public void addToCategory(Category selectedItem, Movie selectedMovie) throws bllException, daoException;

    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws bllException, daoException;

    public ObservableList<Movie> searchMovie(ObservableList<Movie> currentMovies, String movieToFind);

    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws bllException, daoException;

    public Movie updateMovieDate(Movie selectedItem) throws bllException, daoException;

}
