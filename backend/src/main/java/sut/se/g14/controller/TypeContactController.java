package sut.se.g14.controller;
import sut.se.g14.entity.TypeContact;
import sut.se.g14.repository.TypeContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TypeContactController {
    @Autowired private final TypeContactRepository typeContactRepository;

    @Autowired
    TypeContactController(TypeContactRepository typeContactRepository) {
        this.typeContactRepository = typeContactRepository;
    }

    @GetMapping("/TypeContact")
    public Collection<TypeContact> typeContacts() {
        return typeContactRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}
