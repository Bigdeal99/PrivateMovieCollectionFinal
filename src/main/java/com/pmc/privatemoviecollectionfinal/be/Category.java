package com.pmc.privatemoviecollectionfinal.be;

import java.util.Date;

public class Category {
    private String name;
    private int userRating;
    private int imdbRating;
    private Date lastView;
    private String url;
    private int ID;

    public void Movie(String name, int userRating, int imdbRating, Date lastView, String url, int ID) {
        this.name = name;
        this.userRating = userRating;
        this.imdbRating = imdbRating;
        this.lastView = lastView;
        this.url = url;
        this.ID = ID;
    }

    public Category(int id) {
        ID = id;
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
