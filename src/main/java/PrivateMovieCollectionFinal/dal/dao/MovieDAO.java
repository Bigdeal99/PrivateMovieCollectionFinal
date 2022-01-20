package PrivateMovieCollectionFinal.dal.dao;

import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    SQLServerDataSource ds;

    public MovieDAO() {
        this.ds = new SQLServerDataSource();
        ds.setDatabaseName(DBConection.getInstance().getProperty("dbname"));
        ds.setUser(DBConection.getInstance().getProperty("username"));
        ds.setPassword(DBConection.getInstance().getProperty("password"));
        ds.setServerName(DBConection.getInstance().getProperty("ip"));
        ds.setPortNumber(Integer.parseInt(DBConection.getInstance().getProperty("port")));
    }
    public List<Movie> getAllMovies() throws daoException {
        List<Movie> allMovies = new ArrayList<>();
        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM Movie";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) { // Creates and adds movie objects into an array list
                Movie mov = new Movie(rs.getString("name"),
                        rs.getInt("rating"),
                        rs.getDate("lastview"),
                        rs.getString("filelink"),
                        rs.getInt("id"),
                        (int) rs.getFloat("imdbRating"));
                allMovies.add(mov);
            }
            return allMovies; //Returns the full list
        } catch (SQLServerException ex) {
            System.out.println(ex);
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }


    public Movie updateMovieRating(Movie selectedItem, Integer newRating) throws daoException {
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE Movie set userRating = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newRating);
            preparedStmt.setInt(2, selectedItem.getID());
            preparedStmt.executeUpdate();
            Movie mov = new Movie(selectedItem.getName(), newRating,  selectedItem.getLastView(), selectedItem.getUrl(), selectedItem.getID(), selectedItem.getImdbRating()); //creates a new song object.
            return mov;
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }
    public Movie updateMovie(Movie movieToEdit, String name, int rating, int imdbrating, String url) throws daoException {
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE Movie set name = ?,userRating = ?,imdbRating = ?,filelink = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, rating);
            preparedStmt.setInt(3, imdbrating);
            preparedStmt.setString(4, url);
            preparedStmt.setInt(5, movieToEdit.getID());
            preparedStmt.executeUpdate();
            Movie mov = new Movie(name, rating,  movieToEdit.getLastView(), url, movieToEdit.getID(), movieToEdit.getImdbRating()); //creates a new song object.
            return mov;
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }

    public Movie createMovie(String name, int rating, int imdbrating, String url) throws daoException {
        String sql = "INSERT INTO Movie(name,userRating,imdbRating,filelink) VALUES (?,?,?,?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, rating);
            ps.setInt(3, imdbrating);
            ps.setString(4, url);
            ps.addBatch();
            ps.executeBatch();
            Movie mov = new Movie(name, rating, null, url, getNewestSongID(), imdbrating); // Creates a movie object
            return mov; //Returns the movie object
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }

    private int getNewestSongID() throws daoException {
        int newestID = -1; // Default ID not found
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM Movie ORDER by id desc"; //Selects the biggest song ID in the database
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("id");
            }
            return newestID;
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }

    public void removeMovie(Movie selectedItem) throws daoException {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from Movie WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }

    public Movie updateMovieDate(Movie selectedItem) throws daoException {
        java.util.Date utilStartDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilStartDate.getTime());
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE Movie set lastview = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setDate(1, date);
            preparedStmt.setInt(2, selectedItem.getID());
            preparedStmt.executeUpdate();
            Movie mov = new Movie(selectedItem.getName(), selectedItem.getUserRating(),  date, selectedItem.getUrl(), selectedItem.getID(), selectedItem.getImdbRating()); //creates a new song object.
            return mov;
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Cannot execute query");
        }
    }}
