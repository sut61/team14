package sut.se.g14.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class QuereController {
    @Autowired private final QuereRepository quereRepository;
    @Autowired private MembersRepository membersRepository;
    @Autowired private ArtistRepository artistRepository;
    @Autowired private PlaceRepository placeRepository;
    @Autowired private TypeWorkRepository typeWorkRepository;
    @Autowired private StatusRepository statusRepository;

    @Autowired
    QuereController(QuereRepository quereRepository) {
        this.quereRepository = quereRepository;
    }

    @GetMapping("/Queres")
    public Collection<Quere> Quere() {
        return quereRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Quere/{id}")
    public Optional<Quere> View(@PathVariable Long id) {
        Optional<Quere> Q = quereRepository.findById(id);
        return Q;
    }

    @PostMapping("/Quere/cancel/{quereId}")
    public Quere updateQuere(Quere quere, @PathVariable long quereId) {
        Long statusId = 3L;
        Status status = statusRepository.findByStatusId(statusId);
        quere = quereRepository.findById(quereId);
        quere.setStatusQuere(status);
        return quereRepository.save(quere);
    }
    @PostMapping("/Quere/{place}/{startDate}/{hour}/{hrs}/{mins}/{artistId}/{memuser}/{typeworkId}")
    public Members newMembers(@PathVariable String place, @PathVariable String startDate, @PathVariable int hour,
                              @PathVariable String hrs, @PathVariable String mins,@PathVariable Long artistId,
                              @PathVariable String memuser, @PathVariable Long typeworkId) {
        Place newPlace = new Place();
        LocalDate localD = LocalDate.parse(startDate);
        Date date = Date.valueOf(localD);
        Time time = new Time(Integer.parseInt(hrs),Integer.parseInt(mins),Integer.parseInt("00"));
        newPlace.setPlace(place);
        newPlace.setDate(date);
        newPlace.setTime(time);
        newPlace.setHour(hour);
        placeRepository.save(newPlace);

        Quere newQuere = new Quere();
        Members members = membersRepository.findByMemuser(memuser);
        Artist artist = artistRepository.findByArtistId(artistId);
        TypeWork typeWork = typeWorkRepository.findByTypeworkId(typeworkId);
        Status status = statusRepository.findByStatusId(1L);

        newQuere.setArtistQuere(artist);
        newQuere.setPlaceQuere(newPlace);
        newQuere.setTypeworkQuere(typeWork);
        newQuere.setStatusQuere(status);
        quereRepository.save(newQuere);
        members.getQuereSet().add(newQuere);
        return membersRepository.save(members);


    }
}
