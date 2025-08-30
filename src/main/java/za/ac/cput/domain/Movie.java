package za.ac.cput.domain;

import jakarta.persistence.*;

/* Movie.java
     Movie POJO class
     Author: RI Onwutali (222369345)
     Date: 11 May 2025 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;

    private String title;
    private String genre;
    private int durationMinutes;
    private String description;
    private int ageRestriction;
    private String distributor;
    private String viewType;
    private int price;

    @Lob
    private byte[] image;

    protected Movie() {

    }//end of Movie()

    public Movie(MovieBuilder builder){
        this.title = builder.title;
        this.genre = builder.genre;
        this.durationMinutes = builder.durationMinutes;
        this.description = builder.description;
        this.ageRestriction = builder.ageRestriction;
        this.distributor = builder.distributor;
        this.viewType = builder.viewType;
        this.price = builder.price;
        this.image = builder.image;
    }//end of Movie(MovieBuilder)

    public Long getMovieId() {
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
    public int getPrice() {return price;}
    public byte[] getImage() {
        return image;
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
                ", price=" + price +
                '}';
    }//end of toString

    public static class MovieBuilder {
        private Long movieId;
        private String title;
        private String genre;
        private int durationMinutes;
        private String description;
        private int ageRestriction;
        private String distributor;
        private String viewType;
        private int price;
        private byte[] image;

        public MovieBuilder(){

        }

        public MovieBuilder(Long movieId, String title, String genre, int durationMinutes, String description,
                            int ageRestriction, String distributor, String viewType, int price,  byte[] image) {
            this.movieId = movieId;
            this.title = title;
            this.genre = genre;
            this.durationMinutes = durationMinutes;
            this.description = description;
            this.ageRestriction = ageRestriction;
            this.distributor = distributor;
            this.viewType = viewType;
            this.price = price;
            this.image = image;
        }

        public MovieBuilder MovieId(Long movieId) {
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

        public MovieBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public MovieBuilder setImage(byte[] image) {
            this.image = image;
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
            this.price = movie.price;
            this.image = movie.image;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }

    }//end of static class
}//end of class