package sut.se.g14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DateExpMonthController {
    @Autowired
    private DateExpMonthRepository dateExpMonthRepository;

    @GetMapping(path = "/expMonth", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<DateExpMonth> getExpMonth() {
        return dateExpMonthRepository.findAll().stream().collect(Collectors.toList());
    }
}
