package sut.se.g14.controller;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sut.se.g14.repository.*;
import sut.se.g14.entity.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SponserController {
    @Autowired
    private ArtistsRepository  artistsRepository;
    @Autowired
    private DressRepository dressRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private SponserRepository sponserRepository;
    @Autowired
    private StatusdressRepository statusdressRepository;
        

    @GetMapping("/sponser")
    public Collection<Sponser> sponser() {
        return sponserRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/sponser")
    public Sponser newSponser(Sponser newSponser, @RequestBody() Map<String,Object> body){
        
        Optional<Dress> dress = dressRepository.findById((Long.valueOf( body.get("dress").toString() )));
        Optional<Statusdress> statusdress = statusdressRepository.findById((Long.valueOf( body.get("statusdress").toString() )));
        Optional<Artists> artist = artistsRepository.findById((Long.valueOf( body.get("artist").toString() )));

        newSponser.setSponser(body.get("sponser").toString());
        newSponser.setDress(dress.get());
        newSponser.setStatusdress(statusdress.get());
        newSponser.setDate(new Date(Long.valueOf(body.get("date").toString())));
        newSponser.setDatereturn(new Date(Long.valueOf(body.get("datere").toString())));
        newSponser.setArtists(artist.get());
        return sponserRepository.save(newSponser);
    }

    @GetMapping("/statusdress")
    public Collection<Statusdress> statusdress() {
        return statusdressRepository.findAll().stream().collect(Collectors.toList());
    }

}