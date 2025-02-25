package BookMyShow;

import BookMyShow.Enum.City;
import BookMyShow.Enum.SeatCategory;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public void initialize() {
        // Add Theatres
        createTheatres();
        // Add Movies
        createMovies();
    }

    void createTheatres() {
        Movie movie = movieController.getMovieById(1);
        Movie movie1 = movieController.getMovieById(2);

        // Screens per Theatre.
        List<Screen> screens = new ArrayList<>();
        screens.add(new Screen());
        screens.add(new Screen());

        // Seats
        Seat seat = new Seat();
        seat.setSeatId(1);
        seat.setSeatCategory(SeatCategory.GOLD);
        seat.setSeatNumber("1A");
        seat.setPrice(200);

        // Shows per Theatre.
        List<Show> shows = new ArrayList<>();
        Show show = new Show();
        show.setShowId(1);
        show.setMovie(movie);
        show.addSeats(seat);
        show.setStartTime(10);

        shows.add(show);

        show.setShowId(2);
        show.setMovie(movie1);
        show.setStartTime(20);
        shows.add(show);

        // Create Theatre.
        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setCity(City.BANGALORE);
        inoxTheatre.setScreenList(screens);
        inoxTheatre.setShowList(shows);

        theatreController.addCityTheatre(City.BANGALORE, inoxTheatre);

    }

    void createMovies() {
        // Create 1st movie
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Bahubali");
        movie.setMovieDuration(170);

        // Create 2nd movie
        Movie movie1 = new Movie();
        movie1.setMovieId(2);
        movie1.setMovieName("Infinity War");
        movie1.setMovieDuration(190);

        movieController.addMovies(City.BANGALORE, movie1);
        movieController.addMovies(City.DELHI, movie);
    }

    void createBooking(City city) {
        // Get all movies in city.
        List<Movie> movies = movieController.cityMovieList.get(city);

        // User want to see movie "Bahubali".
        Movie movie = movies.get(0);

        // Find Theatres where "Bahubali" is present.
        List<Theatre> theatres = theatreController.getTheatreByMovie(city, movie);

        // User chooses a theatre
        Theatre theatre = theatres.get(0);

        // User chooses a screen
        Screen screen = theatre.getScreenList().get(0);

        // Show
        Show show = screen.getShow();

        // User book seats
        Integer selectedSeatId = 1;
        List<Seat> bookSeats = new ArrayList<>();
        for (Seat seat : show.seats) {
            if (seat.seatId == selectedSeatId) {
                bookSeats.add(seat);
            }
        }

        // Begin booking and payment
        // Can also do concurrency checks
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setBookedSeats(bookSeats);

        // Do payment
        Payment payment = new Payment();
        payment.paid = true;

        booking.setPayment(payment);
    }
}
