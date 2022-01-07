package com.pmc.privatemoviecollectionfinal.dal;

import com.pmc.privatemoviecollectionfinal.be.Movie;
import com.pmc.privatemoviecollectionfinal.dal.dao.MovieDAO;

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
