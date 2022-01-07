package com.pmc.privatemoviecollectionfinal.gui.model;

import com.pmc.privatemoviecollectionfinal.be.Movie;
import com.pmc.privatemoviecollectionfinal.bll.BLLFacade;
import com.pmc.privatemoviecollectionfinal.bll.IBLLFacade;

import java.util.List;

public class MovieModel {

    private IBLLFacade bllFacade;

    public MovieModel() {
        bllFacade = new BLLFacade();
    }

    public List<Movie> getAllMovies() {
        return bllFacade.getAllMovies();
    }
}
