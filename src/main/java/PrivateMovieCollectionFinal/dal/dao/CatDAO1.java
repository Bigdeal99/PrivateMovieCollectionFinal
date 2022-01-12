package PrivateMovieCollectionFinal.dal.dao;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO1 {
    SQLServerDataSource ds;
    public CatDAO1() {
        this.ds = new SQLServerDataSource();
        ds.setDatabaseName(DBConection.getInstance().getProperty("databaseName"));
        ds.setUser(DBConection.getInstance().getProperty("userName"));
        ds.setPassword(DBConection.getInstance().getProperty("password"));
        ds.setServerName(DBConection.getInstance().getProperty("ip"));
        ds.setPortNumber(Integer.parseInt(DBConection.getInstance().getProperty("port")));
    }
    public List<Movie> getCategoryMovie(int id) throws daoException {
        List<Movie> newMovieList = new ArrayList();
        try (Connection con = ds.getConnection()) {
            String query = ""
                    + "SELECT Movie.name , Movie.userRating , Movie.imdbRating , Movie.lastview , Movie.filelink , Movie.id FROM CatMovie "
                    + "INNER JOIN Movie "
                    + "ON CatMovie.MovieId = Movie.id "
                    + "WHERE CatMovie.CategoryId = ? "; // Gets all movies from a coresponding category.
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Movie mov = new Movie(rs.getString("name"), rs.getInt("userRating"), rs.getInt("imdbRating"), rs.getDate("lastview"), rs.getString("filelink"), rs.getInt("id"));
                newMovieList.add(mov); //adds movies to a movie array
            }
            return newMovieList;
        } catch (SQLServerException ex) {
            throw new daoException("Connection to the server failed");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }

    public void removeMoviesFromCat(Movie selectedItem) throws daoException {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from CatMovie WHERE MovieId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            throw new daoException("Connection to the server failed");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }

    public void removeFromCat(Category selectedItem) throws daoException {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from CatMovie WHERE CategoryId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            throw new daoException("Connection to the server failed");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }

    public void addToCategory(Category selectedItem, Movie selectedMovie) throws daoException {
        String sql = "INSERT INTO CatMovie(CategoryId,MovieId) VALUES (?,?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, selectedItem.getID());
            ps.setInt(2, selectedMovie.getID());
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            throw new daoException("Connection to the server failed");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }

    public void removeFromCategory(Category selectedItem, Movie selectedMovie) throws daoException {
        try (Connection con = ds.getConnection()) {
            System.out.println(selectedItem.getID() + " " + selectedMovie.getID());
            String query = "DELETE from CatMovie WHERE CategoryId = ? AND MovieId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getID());
            preparedStmt.setInt(2, selectedMovie.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            throw new daoException("Connection to the server failed");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }
}
