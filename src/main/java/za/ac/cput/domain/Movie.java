package za.ac.cput.domain;

/* Movie.java
     Movie POJO class
     Author: RI Onwutali (222369345)
     Date: 11 May 2025 */

public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private int durationMinutes;
    private String description;
    private int ageRestriction;
    private String distributor;
    private String viewType;

    public Movie() {

    }//end of Movie()

    public Movie(MovieBuilder builder){
        this.movieId = builder.movieId;
        this.title = builder.title;
        this.genre = builder.genre;
        this.durationMinutes = builder.durationMinutes;
        this.description = builder.description;
        this.ageRestriction = builder.ageRestriction;
        this.distributor = builder.distributor;
        this.viewType = builder.viewType;
    }//end of Movie(MovieBuilder)

    public String getMovieId() {
        return movieId;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public String getDescription() {
        return description;
    }
    public int getAgeRestriction() {
        return ageRestriction;
    }
    public String getDistributor() {
        return distributor;
    }
    public String getViewType() {
        return viewType;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", description='" + description + '\'' +
                ", ageRestriction=" + ageRestriction +
                ", distributor='" + distributor + '\'' +
                ", viewType='" + viewType + '\'' +
                '}';
    }//end of toString

    public static class MovieBuilder {
        private String movieId;
        private String title;
        private String genre;
        private int durationMinutes;
        private String description;
        private int ageRestriction;
        private String distributor;
        private String viewType;

        public MovieBuilder(){

        }

        public MovieBuilder(String movieId, String title, String genre, int durationMinutes, String description,
                            int ageRestriction, String distributor, String viewType){
            this.movieId = movieId;
            this.title = title;
            this.genre = genre;
            this.durationMinutes = durationMinutes;
            this.description = description;
            this.ageRestriction = ageRestriction;
            this.distributor = distributor;
            this.viewType = viewType;
        }

        public MovieBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }
        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public MovieBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }
        public MovieBuilder setDurationMinutes(int durationMinutes) {
            this.durationMinutes = durationMinutes;
            return this;
        }
        public MovieBuilder setDescription(String description) {
            this.description = description;
            return this;
        }
        public MovieBuilder setAgeRestriction(int ageRestriction) {
            this.ageRestriction = ageRestriction;
            return this;
        }
        public MovieBuilder setDistributor(String distributor) {
            this.distributor = distributor;
            return this;
        }
        public MovieBuilder setViewType(String viewType) {
            this.viewType = viewType;
            return this;
        }

        public MovieBuilder copy(Movie movie){
            this.movieId = movie.movieId;
            this.title = movie.title;
            this.genre = movie.genre;
            this.durationMinutes = movie.durationMinutes;
            this.description = movie.description;
            this.ageRestriction = movie.ageRestriction;
            this.distributor = movie.distributor;
            this.viewType = movie.viewType;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }

    }//end of static class
}//end of class