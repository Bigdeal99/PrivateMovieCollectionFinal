/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateMovieCollectionFinal.be;

import java.util.Date;


public class Movie {
    private String name;
    private int userRating;
    private int imdbRating;
    private Date lastView;
    private String url;
    private final int ID;

    public Movie(String name, int userRating,  Date lastView, String url, int ID, int imdbRating) {
        this.name = name;
        this.userRating = userRating;
        this.lastView = lastView;
        this.url = url;
        this.ID = ID;
        this.imdbRating =imdbRating;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getUserRating() {
        return userRating;
    }

    public int getImdbRating() {
        return imdbRating;
    }

    public Date getLastView() {
        return lastView;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLastView(Date lastView) {
        this.lastView = lastView;
    }
}
