package sut.se.g14.controller;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.Old;
import sut.se.g14.repository.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import sut.se.g14.repository.OldRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OldController {
    @Autowired
    private final OldRepository oldRepository;

    OldController(OldRepository oldRepository) {
        this.oldRepository = oldRepository;
    }

    @GetMapping("/Olds")
    public Collection<Old> Old() {
        return oldRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("Old/{id}")
    public Optional<Old> View(@PathVariable Long oldId) {
        Optional<Old> old = oldRepository.findById(oldId);
        return old;
    }
}