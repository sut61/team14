package sut.se.g14.controller;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ManagerController {
    @Autowired private final ManagerRepository managerRepository;
    @Autowired private ContactRepository contactRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private TypeContactRepository typeContactRepository;

    @Autowired
    ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/Managers")
    public Collection<Manager> allManager() {
        return managerRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Manager/{username}")
    public Manager findManager(@PathVariable String username) {
        Manager manager = managerRepository.findByUsername(username);
        return manager;
    }

    @PostMapping("/newManager/{name}/{idGender}/{username}/{password}")
    public Manager addManager(Manager newManager,@PathVariable String name, @PathVariable long idGender,
                              @PathVariable String username, @PathVariable String password ) {
        Gender gender = genderRepository.findById(idGender);

        newManager.setName(name);
        newManager.setGender(gender);
        newManager.setUsername(username);
        newManager.setPassword(password);
        return managerRepository.save(newManager);
    }

    @PostMapping("/newContact/{username}/{idTypeContact}/{contact}")
    public Manager addContact(@PathVariable String username, @PathVariable long idTypeContact, @PathVariable String contact ) {
        Contact newContact = new Contact();
        Manager manager = managerRepository.findByUsername(username);
        TypeContact type = typeContactRepository.findById(idTypeContact);

        newContact.setContact(contact);
        newContact.setType(type);
        contactRepository.save(newContact);
        manager.getContactSet().add(newContact);
        return managerRepository.save(manager);
    }

}

