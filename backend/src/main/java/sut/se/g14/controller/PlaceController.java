package sut.se.g14.controller;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.Place;
import sut.se.g14.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import java.sql.Date;
import java.util.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

//import java.time.LocalDate;

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


}
