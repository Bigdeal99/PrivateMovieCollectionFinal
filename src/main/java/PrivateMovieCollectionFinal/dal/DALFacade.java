package PrivateMovieCollectionFinal.dal;

import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.dao.MovieDAO;

import java.util.List;

public class DALFacade implements IDALFacade{
    private MovieDAO movieDAO;

    public DALFacade( ) {
        this.movieDAO = new MovieDAO();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
}
