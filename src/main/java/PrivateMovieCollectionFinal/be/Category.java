package PrivateMovieCollectionFinal.be;

import java.util.List;


    public class Category {
        private String name;
        private int movieCount = 0;
        private List<Movie> allMoviesInCategory;
        private final int ID;

        public Category(int ID, String name, int movieCount, List<Movie> allMoviesInCategory) {
            this.name = name;
            this.movieCount = movieCount;
            this.allMoviesInCategory = allMoviesInCategory;
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public int getMovieCount() {
            return movieCount;
        }

        public List<Movie> getAllMoviesInCategory() {
            return allMoviesInCategory;
        }

        public int getID() {
            return ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMovieCount(int movieCount) {
            this.movieCount = movieCount;
        }

        public void setAllMoviesInCategory(List<Movie> allMoviesInCategory) {
            this.allMoviesInCategory = allMoviesInCategory;
        }


    }
