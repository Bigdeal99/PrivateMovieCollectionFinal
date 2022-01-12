package PrivateMovieCollectionFinal.dal.dao;

import PrivateMovieCollectionFinal.dal.DAOex.daoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

public class DBConection {
    private final Properties configProp = new Properties();

    private DBConection(){
        //Private constructor to restrict new instances
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("loginInfo.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            try {
                System.out.println(e);
                throw new daoException(e.getMessage());
            } catch (daoException ex) {
                System.out.println(ex);
                Logger.getLogger(ex.getMessage());
            }
        }
    }

    private static class LazyHolder  {
        private static final DBConection INSTANCE = new DBConection() ;
    }

    public static DBConection getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }
}
