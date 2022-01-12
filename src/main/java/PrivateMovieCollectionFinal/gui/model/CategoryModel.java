package PrivateMovieCollectionFinal.gui.model;

import PrivateMovieCollectionFinal.be.Category;
import PrivateMovieCollectionFinal.be.Movie;
import PrivateMovieCollectionFinal.bll.BLLFacade;
import PrivateMovieCollectionFinal.bll.Exception.bllException;
import PrivateMovieCollectionFinal.dal.DAOex.daoException;
import PrivateMovieCollectionFinal.gui.exceptions.modelException;
import PrivateMovieCollectionFinal.bll.IBLLFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class CategoryModel {

    private static final CategoryModel categorySingleton = new CategoryModel();
    private final IBLLFacade IBLLFacade1;
    private ObservableList<Category> allCategory;

    /*
    Initialises the logic layer manager
     */
    private CategoryModel() {
        try {
            IBLLFacade1 = new BLLFacade();
        } catch (IOException e) {
            throw new IllegalStateException("Missing a required resource", e);
        }
    }

    /* Static 'instance' method */
    public static CategoryModel getInstance() {
        return categorySingleton;
    }

    /*
    Gets all categories from database and then returns a string list of all categories
     */
    public ObservableList<Category> getAllCategories() throws modelException {
        allCategory = FXCollections.observableArrayList();
        try {
            allCategory.addAll(IBLLFacade1.getAllCategories());
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
        return allCategory;
    }

    public ObservableList<Category> getCurrentCategories() throws modelException {
        return allCategory;
    }

    public void createPlaylist(String name) throws modelException {
        Category createdCategory;
        try {
            createdCategory = IBLLFacade1.createCategory(name);
            allCategory.add(createdCategory);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void editPlaylist(Category editingList, int categoryIndex, String name) throws modelException {
        Category updatedCategory;
        try {
            updatedCategory = IBLLFacade1.updatedCategory(editingList, name);
            allCategory.set(categoryIndex, updatedCategory);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void deletePlaylist(Category selectedItem, int selectedIndex) throws modelException {
        try {
            IBLLFacade1.deleteCategory(selectedItem);
            allCategory.remove(selectedIndex);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void addToCategory(Category selectedItem, int selectedIndex, Movie selectedMovie) throws modelException {
        try {
            IBLLFacade1.addToCategory(selectedItem, selectedMovie);
            List<Movie> newList = selectedItem.getAllMoviesInCategory();
            newList.add(selectedMovie);
            selectedItem.setAllMoviesInCategory(newList);
            selectedItem.setMovieCount(selectedItem.getMovieCount() + 1);
            allCategory.set(selectedIndex, selectedItem);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }

    public void removeMovieFromCategory(Category selectedItem, int selectedIndex, Movie selectedMovie, int movieIndex) throws modelException {
        try {
            IBLLFacade1.removeFromCategory(selectedItem, selectedMovie);
            List<Movie> newList = selectedItem.getAllMoviesInCategory();
            newList.remove(movieIndex);
            selectedItem.setAllMoviesInCategory(newList);
            selectedItem.setMovieCount(selectedItem.getMovieCount() - 1);
            allCategory.set(selectedIndex, selectedItem);
        } catch (bllException | daoException ex) {
            throw new modelException(ex.getMessage());
        }
    }
}
