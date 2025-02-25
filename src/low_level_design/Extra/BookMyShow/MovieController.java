package BookMyShow;

import BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<City, List<Movie>> cityMovieList;
    List<Movie> movies;

    public MovieController() {
        cityMovieList = new HashMap<>();
        movies = new ArrayList<>();
    }

    void addMovies(City city, Movie movie) {
        List<Movie> movieList = new ArrayList<>();
        if (cityMovieList.containsKey(city)) {
            movieList = cityMovieList.get(city);
        }
        movieList.add(movie);
        cityMovieList.put(city, movieList);

        movies.add(movie);
    }

    public Movie getMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.movieId == movieId)
                return movie;
        }
        return null;
    }
}
