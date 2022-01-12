package PrivateMovieCollectionFinal.dal.dao;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CategoryDao1 {
    SQLServerDataSource ds;

    private CatDAO1 catDAO1;

    public CategoryDao1() {
        catDAO1 = new CatDAO1();
        this.ds = new SQLServerDataSource();
        ds.setDatabaseName(DBConection.getInstance().getProperty("dbname"));
        ds.setUser(DBConection.getInstance().getProperty("username"));
        ds.setPassword(DBConection.getInstance().getProperty("password"));
        ds.setServerName(DBConection.getInstance().getProperty("ip"));
    }


    public Category createCategory(String name) throws daoException {
        List<Movie> allMoviesInCategory = new ArrayList<>();
        String sql = "INSERT INTO Category(name) VALUES (?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.addBatch();
            ps.executeBatch();
            Category cat = new Category(getNewestID(), name, 0, allMoviesInCategory); //Creates a Category object and specifies that there are no movies present.
            return cat;
        } catch (SQLServerException ex) {
            throw new daoException("Cannot connect to server");
        } catch (SQLException ex) {
            throw new daoException("Query cannot be executed");
        }
    }

        public Category updateCategory (Category editingList, String name) throws daoException {
            try (Connection con = ds.getConnection()) {
                String query = "UPDATE Category set name = ? WHERE id = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setInt(2, editingList.getID());
                preparedStmt.executeUpdate();
                List<Movie> allMovies = catDAO1.getCategoryMovie(editingList.getID()); //Puts all movies into the category
                Category cat = new Category(editingList.getID(), name, allMovies.size(), allMovies); //Creates a Category object and specifies that there are no movies present.
                return cat;
            } catch (SQLServerException ex) {
                throw new daoException("Cannot connect to server");
            } catch (SQLException ex) {
                throw new daoException("Query cannot be executed");
            }
        }

        public void deleteCategory (Category selectedItem) throws daoException {
            try (Connection con = ds.getConnection()) {
                String query = "DELETE from Category WHERE id = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, selectedItem.getID());
                preparedStmt.execute();
            } catch (SQLServerException ex) {
                throw new daoException("Cannot connect to server");
            } catch (SQLException ex) {
                throw new daoException("Query cannot be executed");
            }
        }
        private int getNewestID () throws daoException {
            int newestID = -1;
            try (Connection con = ds.getConnection()) {
                String query = "SELECT TOP(1) * FROM Category ORDER by id desc";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    newestID = rs.getInt("id");
                }
                return newestID;
            } catch (SQLServerException ex) {
                throw new daoException("Cannot connect to server");
            } catch (SQLException ex) {
                throw new daoException("Query cannot be executed");
            }
        }
        public List<Category> getAllCategories() throws daoException {
            List<Category> allCategories = new ArrayList<>(); // Creates a category array to store all category

            try (Connection con = ds.getConnection()) {
                String sqlStatement = "SELECT * FROM Category";
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sqlStatement);
                while (rs.next()) {
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    List<Movie> allMovies = catDAO1.getCategoryMovie(id); //Puts all movies into the category
                    Category categoryNew = new Category(id, name, allMovies.size(), allMovies); //Creates a new category object
                    allCategories.add(categoryNew); // Adds the category to the category array
                }
                return allCategories; // Returns the category array
            } catch (SQLServerException ex) {
                throw new daoException("Cannot connect to server");
            } catch (SQLException ex) {
                throw new daoException("Query cannot be executed");
            }
        }
    }
