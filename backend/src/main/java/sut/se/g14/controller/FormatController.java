package sut.se.g14.controller;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.Format;
import sut.se.g14.repository.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FormatController {
    @Autowired
    private final FormatRepository formatRepository;

    FormatController(FormatRepository formatRepository) { this.formatRepository = formatRepository; }

    @GetMapping("/Formats")
    public Collection<Format> Format() {
        return formatRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("Format/{id}")
    public Optional<Format> View(@PathVariable Long formatId) {
        Optional<Format> format = formatRepository.findById(formatId);
        return format;
    }
}

