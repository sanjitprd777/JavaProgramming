package BookMyShow;

import BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> theatres;

    public TheatreController() {
        cityTheatreMap = new HashMap<>();
        theatres = new ArrayList<>();
    }

    public void addCityTheatre(City city, Theatre theatre) {
        theatres.add(theatre);
        List<Theatre> theatreList = new ArrayList<>();
        if (cityTheatreMap.containsKey(city)) {
            theatreList = cityTheatreMap.get(city);
        }
        theatreList.add(theatre);
        cityTheatreMap.put(city, theatreList);
    }

    List<Theatre> getTheatreByMovie(City city, Movie movie) {
        List<Theatre> theatreList = new ArrayList<>();
        for (Theatre theatre : cityTheatreMap.get(city)) {
            for (Show show : theatre.showList) {
                if (show.movie == movie) {
                    theatreList.add(theatre);
                    break;
                }
            }
        }
        return theatreList;
    }
}
