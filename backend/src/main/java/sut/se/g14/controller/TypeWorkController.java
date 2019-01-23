package sut.se.g14.controller;

import sut.se.g14.entity.TypeWork;
import sut.se.g14.repository.TypeWorkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TypeWorkController {
    @Autowired private final TypeWorkRepository typeWorkRepository;

    TypeWorkController(TypeWorkRepository typeWorkRepository) {
        this.typeWorkRepository = typeWorkRepository;
    }

    @GetMapping("/TypeWorks")
    public Collection<TypeWork> typeWork() {
        return typeWorkRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/TypeWork/add/{typeWork}")
    public TypeWork typeWork(@RequestBody String typeWork) {
        TypeWork newType = new TypeWork();
        newType.setTypeWork(typeWork);
        return typeWorkRepository.save(newType);
    }
}

