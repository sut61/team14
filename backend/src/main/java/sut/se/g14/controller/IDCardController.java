package sut.se.g14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.IDCard;
import sut.se.g14.repository.IDCardRepository;
import sut.se.g14.repository.ProfileRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IDCardController {
    @Autowired
    private IDCardRepository idCardRepository;
    @Autowired
    private ProfileRepository profileRepository;


    @PostMapping (path = "/idCard/{profileID}")
    public IDCard postIDCard(@RequestBody IDCard idCard,
                            @PathVariable Long profileID){
        idCard.setProfile(profileRepository.findById(profileID).get());

        return idCardRepository.save(idCard);
    }

    @GetMapping(path = "/idCard/{idCardNum}")
    public IDCard getOneIDCard (@PathVariable Long idCardNum){
        return idCardRepository.findById(idCardNum).get();
    }

    @GetMapping(path = "/idCard/profile/{id}")
    public IDCard idCard(@PathVariable Long  id){
        return idCardRepository.findByProfile(profileRepository.findById(id).get()) ;
    }
}
