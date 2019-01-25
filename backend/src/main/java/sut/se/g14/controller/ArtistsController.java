package com.example.demo.Controller;

import com.example.demo.Repository.*;
import com.example.demo.Entity.*;
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
public class ArtistsController {
    @Autowired     private ArtistsRepository artistsRepository;
    @Autowired     private BandRepository bandRepository;
    @Autowired     private TypeMusicRepository typeMusicRepository;
    @Autowired     private GenderRepository genderRepository;
    @Autowired     private ManagerRepository managerRepository;

    ArtistsController(ArtistsRepository repository){

        this.artistsRepository = repository;
    }

    // Artists
    @GetMapping("/artists")
    public List<Artists> getArtists(){

        return artistsRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/artists/{artistsId}")
    public Artists getArtistsById(@PathVariable Long artistsId){

        return artistsRepository.findById(artistsId).get();
    }

    @GetMapping("/band/{bandId}")
    public Band getBandById (@PathVariable Long bandId){

        return bandRepository.findById(bandId).get();
    }

    @GetMapping("//{TypeMusicId}")
    public TypeMusic getTypeMusicById (@PathVariable Long typeMusicId){

        return typeMusicRepository.findById(typeMusicId).get();
    }

    @GetMapping("//{genderId}")
    public Gender getGenderId (@PathVariable Long genderId){

        return genderRepository.findById(genderId).get();
    }

    @GetMapping("//{managerId}")
    public Manager getManagerId (@PathVariable Long managerId){

        return managerRepository.findById(managerId).get();
    }
  @PostMapping("/artists/create/{firstname}/{lastname}/{nickname}/{birthdays}/{phone}/{id}/{ManagerID}/{BandID}/{TypeMusicID}")
    public Artists newArtists(Artists newArtists ,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String nickname,
                                  @PathVariable String birthdays,@PathVariable String phone,@PathVariable Long id,@PathVariable Long ManagerID,
                              @PathVariable Long BandID,@PathVariable Long TypeMusicID){

            newArtists.setFirstname(firstname);
            newArtists.setLastname(lastname);
            newArtists.setNickname(nickname);
            LocalDate localD = LocalDate.parse(birthdays);
            Date birthday = Date.valueOf(localD);
            newArtists.setBirthday(birthday);
            newArtists.setPhone(phone);
            newArtists.setGender(genderRepository.findById(id).get());
            newArtists.setManager(managerRepository.findById(id).get());
            newArtists.setBand(bandRepository.findById(BandID).get());
            newArtists.setTypeMusic(typeMusicRepository.findById(TypeMusicID).get());
            return this.artistsRepository.save(newArtists);
    }
}

