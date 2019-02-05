package sut.se.g14.controller;

import sut.se.g14.entity.Status;
import sut.se.g14.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StatusController {

    @Autowired private final StatusRepository statusRepository;

    StatusController (StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @GetMapping("/Statuses")
    public Collection<Status> status() {
        return statusRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Status/add/{status}")
    public Status status(@RequestBody String status) {
        Status newStatus = new Status();
        newStatus.setStatusQuere(status);
        return statusRepository.save(newStatus);
    }
}

