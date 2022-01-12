package PrivateMovieCollectionFinal.dal;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import PrivateMovieCollectionFinal.dal.dao.MovieDAO;

import java.util.List;

public class DALFacade implements IDALFacade{
    private MovieDAO movieDAO;

    public DALFacade( ) {
        this.movieDAO = new MovieDAO();
    }

    @Override
    public List<Category> getAllCategories() throws daoException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    public Movie createMovie(String name, int rating, int imdbrating, String url) throws daoException {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws daoException {
        return null;
    }

    @Override
    public void deleteMovie(Movie selectedItem) throws daoException {

    }

    @Override
    public Category createCategory(String name) throws daoException {
        return null;
    }

    @Override
    public Category updatedCategory(Category editingList, String name) throws daoException {
        return null;
    }

    @Override
    public void deleteCategory(Category selectedItem) throws daoException {

    }

    @Override
    public void addToCategory(Category selectedItem, Movie selectedMovie) throws daoException {

    }

    @Override
    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws daoException {

    }

    @Override
    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws daoException {
        return null;
    }

    @Override
    public Movie updateMovieDate(Movie selectedItem) {
        return null;
    }
}
