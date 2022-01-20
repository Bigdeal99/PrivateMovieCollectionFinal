package PrivateMovieCollectionFinal.dal;


import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.bll.IBLLFacade;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;

import java.util.List;

public interface IDALFacade {

    public List<Category> getAllCategories() throws daoException;

    public List<Movie> getAllMovies() throws daoException;

    public Movie createMovie(String name, int rating, int imdbrating, String url) throws daoException;

    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws daoException;

    public void deleteMovie(Movie selectedItem) throws daoException;

    public Category createCategory(String name) throws daoException;

    public Category updatedCategory(Category editingList, String name) throws daoException;

    public void deleteCategory(Category selectedItem) throws daoException;

    public void addToCategory(Category selectedItem, Movie selectedMovie) throws daoException;

    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws daoException;

    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws daoException;

    public Movie updateMovieDate(Movie selectedItem) throws daoException;
}
