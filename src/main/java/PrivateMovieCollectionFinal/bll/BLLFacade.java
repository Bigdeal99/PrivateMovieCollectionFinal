package PrivateMovieCollectionFinal.bll;
import java.io.IOException;
import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import PrivateMovieCollectionFinal.bll.util.SearchMovie;
import PrivateMovieCollectionFinal.dal.DALFacade;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import PrivateMovieCollectionFinal.dal.IDALFacade;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class BLLFacade implements IBLLFacade{
    private final IDALFacade logiclayer;
    private final SearchMovie searchforMovie;

    /*
    Initialises all classes in DAL
     */
    public BLLFacade() throws IOException {
        logiclayer = new DALFacade();
        searchforMovie = new SearchMovie();
    }

    @Override
    public List<Category> getAllCategories() throws bllException {
        try {
            return logiclayer.getAllCategories();
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public List<Movie> getAllMovies() throws bllException {
        try {
            return logiclayer.getAllMovies();
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public Movie createMovie(String name, int rating, int imdbrating, String url) throws bllException {
        try {
            return logiclayer.createMovie(name, rating, imdbrating, url);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws bllException {
        try {
            return logiclayer.updateMovie(movieToEdit, name, rating, imdbrating, url);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public void deleteMovie(Movie selectedItem) throws bllException {
        try {
            logiclayer.deleteMovie(selectedItem);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public Category createCategory(String name) throws bllException {
        try {
            return logiclayer.createCategory(name);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public Category updatedCategory(Category editingList, String name) throws bllException {
        try {
            return logiclayer.updatedCategory(editingList, name);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public void deleteCategory(Category selectedItem) throws bllException {
        try {
            logiclayer.deleteCategory(selectedItem);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
        try {
            logiclayer.deleteCategory(selectedItem);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public void addToCategory(Category selectedItem, Movie selectedMovie) throws bllException {
        try {
            logiclayer.addToCategory(selectedItem, selectedMovie);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws bllException {
        try {
            logiclayer.removeFromCategory(selectedItem, selectedMovie);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Movie> searchMovie(ObservableList<Movie> currentMovies, String movieToFind) {
        return searchforMovie.search(currentMovies, movieToFind);
    }

    @Override
    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws bllException {
        try {
            return logiclayer.updateMovieRating(selectedItem, newRating);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }

    @Override
    public Movie updateMovieDate(Movie selectedItem) throws bllException {
        try {
            return logiclayer.updateMovieDate(selectedItem);
        } catch (daoException ex) {
            throw new bllException(ex.getMessage());
        }
    }
}
