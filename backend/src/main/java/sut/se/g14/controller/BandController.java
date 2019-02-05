package sut.se.g14.controller;

import sut.se.g14.repository.*;
import sut.se.g14.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class BandController {
    @Autowired private BandRepository bandRepository;

    @GetMapping("/Band")
    public List<Band> getBand(){

        return bandRepository.findAll().stream().collect(Collectors.toList());
    }
}
