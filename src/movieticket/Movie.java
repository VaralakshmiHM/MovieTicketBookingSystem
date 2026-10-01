package movieticket;

public class Movie {

    String movieName;
    double rating;

    Movie(String movieName, double rating) {

        this.movieName = movieName;
        this.rating = rating;

    }

    void displayMovie() {

        System.out.println("Movie: " + movieName);
        System.out.println("Rating: " + rating + "/10");

    }

}