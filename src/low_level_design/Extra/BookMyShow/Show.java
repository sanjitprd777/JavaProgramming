package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {

    int showId;
    Movie movie;
    int startTime;
    List<Seat> seats;

    public Show() {
        seats = new ArrayList<>();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeats(Seat seat) {
        seats.add(seat);
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
