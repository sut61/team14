package sut.se.g14.controller;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.Place;
import sut.se.g14.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlaceController {
    @Autowired private final PlaceRepository placeRepository;

    PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/Places")
    public Collection<Place> places() {
        return placeRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Place/{placeId}")
    public Optional<Place> place (@PathVariable Long placeId) {
        Optional<Place> P = placeRepository.findById(placeId);
        return P;
    }

    @PostMapping("/Place/new/{place}/{startDate}/{hour}/{hrs}/{mins}")
    public Place newPlace(@PathVariable String place, @PathVariable String startDate, @PathVariable int hour, @PathVariable String hrs,
                          @PathVariable String mins) {
        Place newPlace = new Place();
        LocalDate localD = LocalDate.parse(startDate);
        Date date = Date.valueOf(localD);
        Time time = new Time(Integer.parseInt(hrs),Integer.parseInt(mins),Integer.parseInt("00"));
        newPlace.setPlace(place);
        newPlace.setDate(date);
        newPlace.setTime(time);
        newPlace.setHour(hour);
        return placeRepository.save(newPlace);
    }

}
