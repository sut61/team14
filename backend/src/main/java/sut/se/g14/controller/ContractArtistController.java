package sut.se.g14.controller;

import sut.se.g14.repository.*;
import sut.se.g14.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Date;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class ContractArtistController {
    @Autowired     private ArtistRepository artistRepository;
    @Autowired     private ManagerRepository managerRepository;
    @Autowired     private TypeContractRepository typeContractRepository;
    @Autowired     private HireMoneyRepository hireMoneyRepository;
    @Autowired     private ContractArtistRepository contractArtistRepository;

    ContractArtistController(ArtistRepository artistRepository,ManagerRepository managerRepository,
    TypeContractRepository typeContractRepository,HireMoneyRepository hireMoneyRepository,
    ContractArtistRepository contractArtistRepository){

        this.artistRepository = artistRepository;
        this.managerRepository = managerRepository;
        this.typeContractRepository = typeContractRepository;
        this.hireMoneyRepository = hireMoneyRepository;
        this.contractArtistRepository = contractArtistRepository;
    }

    // contract
    @GetMapping("/ContractArtist")
    public List<ContractArtistEntity> getContractEntities(){
        return contractArtistRepository.findAll().stream().collect(Collectors.toList());
    }

    // type
    @GetMapping("/Typecontract")
    public List<TypeContractEntity> getTypeContractEntities(){
        return typeContractRepository.findAll().stream().collect(Collectors.toList());
    }

    // hire
    @GetMapping("/Hire")
    public List<HireMoneyEntity> getHireMoney(){
        return hireMoneyRepository.findAll().stream().collect(Collectors.toList());
    }

    // ===========================================================================================
    @PostMapping("/Contract/{artist}/{type}/{hire}/{manager}")
    public ContractArtistEntity ContractArtistEntity(@PathVariable String artist,@PathVariable long type,
    @PathVariable int hire,@PathVariable String manager
                               ){


    ContractArtistEntity c = new ContractArtistEntity();
    TypeContractEntity t = typeContractRepository.findById(type);
    Artists a = artistRepository.findByfirstname(artist);
    Manager m = managerRepository.findByUsername(manager);

    c.setnameArtist(a.getFirstname());
    c.setnameManager(m.getName());
    c.setIdArtist(a);
    c.setManager(m);
    c.setIdType(t);
    
    c.setHiremoney(hire);
    c.setTypecontract(t.getTypeContract());
   

    return contractArtistRepository.save(c);
    }

}
