package com.pmc.privatemoviecollectionfinal.dal;

import com.pmc.privatemoviecollectionfinal.be.Movie;

import java.util.List;

public interface IDALFacade{

    public List<Movie> getAllMovies();
}
