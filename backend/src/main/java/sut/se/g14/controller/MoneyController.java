package sut.se.g14.controller;

import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.ASdebug.ASDebugStream;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MoneyController {
    @Autowired
    private MoneyRepository moneyRepository;
    @Autowired
    private DressRepository dressRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private QuereRepository quereRepository;
  

    public MoneyController(MoneyRepository moneyRepository, DressRepository dressRepository,
            ArtistRepository artistRepository, QuereRepository quereRepository) {
        this.moneyRepository = moneyRepository;
        this.dressRepository = dressRepository;
        this.artistRepository = artistRepository;
        this.quereRepository = quereRepository;
       
     
    }

    @GetMapping("/Money")
    public Collection<MoneyEntity> Car() {
        return moneyRepository.findAll();
    }

    @GetMapping("/Artist")
    public Collection<Artists> Artist() {
        return artistRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Dress")
    public Collection<Dress> Dress() {
        return dressRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Queue")
    public Collection<Quere> Queue() {
        return quereRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/findQueue/{id}")
    public Quere findQueue(@PathVariable int id) {
        Quere queue = quereRepository.findById(id);
        return queue;
    }

    @GetMapping("/findDress/{id}")
    public Dress findDress(@PathVariable int id) {
        Dress dress = dressRepository.findByIdDress(id);
        return dress;
    }

    // =======================================================================================
    @PostMapping("/artist")
    public Artists artist(@RequestBody Artists artist){
        return artistRepository.save(artist);
    }


    // ===========================================================================================
    @PostMapping("/Money/{artist}/{dress}/{priceExpenses}/{queue}/{priceIncome}")
    public MoneyEntity moneyEntity(MoneyEntity moneyEntity,@PathVariable String artist,@PathVariable int dress
    ,@PathVariable int queue,@PathVariable int priceExpenses,@PathVariable int priceIncome
                               ){
                        
    
    Dress d = dressRepository.findByIdDress(dress);
    Quere q = quereRepository.findById(queue);
    Artists a = artistRepository.findByfirstname(artist);
   
    moneyEntity.setnameDress(d.getDress());
    
    moneyEntity.setnameArtist(a.getFirstname());

    moneyEntity.setIdQueue(q);

    moneyEntity.setpriceExpenses(priceExpenses);
    moneyEntity.setpriceIncome(priceIncome);

    

    return moneyRepository.save(moneyEntity);
    }
   
}