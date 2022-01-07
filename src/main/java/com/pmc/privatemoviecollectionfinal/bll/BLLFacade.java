package com.pmc.privatemoviecollectionfinal.bll;

import com.pmc.privatemoviecollectionfinal.be.Movie;
import com.pmc.privatemoviecollectionfinal.dal.DALFacade;
import com.pmc.privatemoviecollectionfinal.dal.IDALFacade;

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
}
