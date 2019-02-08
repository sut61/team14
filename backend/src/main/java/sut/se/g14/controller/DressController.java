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
public class DressController {
    @Autowired
    private ArtistsRepository  artistsRepository;
    @Autowired
    private DressRepository dressRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private SizeRepository sizeRepository;


    @GetMapping("/dress")
    public Collection<Dress> dress() {
        return dressRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/dress")
    public Dress newDress(Dress newDress, @RequestBody() Map<String,Object> body){
        Optional<Artists> artist = artistsRepository.findById((Long.valueOf( body.get("artist").toString() )));
        Optional<Type> type = typeRepository.findById((Long.valueOf( body.get("type").toString() )));
        Optional<Sizes> size = sizeRepository.findById((Long.valueOf( body.get("size").toString() )));
        Optional<Event> event = eventRepository.findById((Long.valueOf( body.get("event").toString() )));
        
        newDress.setDress(body.get("dressname").toString());
        newDress.setArtist(artist.get());
        newDress.setType(type.get());
        newDress.setSize(size.get());   
        newDress.setEvent(event.get());

        return dressRepository.save(newDress);
    }

    @GetMapping("/type")
    public Collection<Type> type() {
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/event")
    public Collection<Event> event() {
        return eventRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/size")
    public Collection<Sizes> size() {
        return sizeRepository.findAll().stream().collect(Collectors.toList());
    }

  
}
