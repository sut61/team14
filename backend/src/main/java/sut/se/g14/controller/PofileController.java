package sut.se.g14.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.util.Date;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PofileController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private MembersRepository membersRepository;


    @PostMapping(path = "/profile/{genderType}/{countryName}/{member}")
    public Profile postProfile(
            @RequestBody Profile profile,
            @PathVariable String genderType,
            @PathVariable String countryName,
            @PathVariable String member) {
        Gender gender = genderRepository.findByGender(genderType);
        Country country = countryRepository.findByCountryName(countryName);
        Members members = membersRepository.findById(member).get();
        profile.setCountry(country);
        profile.setGender(gender);
        profile.setMembers(members);

        return profileRepository.save(profile);
    }

    @GetMapping(path = "/profile/{id}")
    public Profile getProfile(@PathVariable Long id){
        return profileRepository.findById(id).get();
    }

    @GetMapping(path = "/profile/member/{memid}")
    public Profile getProfileByMember(@PathVariable String memid){
        return profileRepository.findByMembers(membersRepository.findById(memid).get());
    }

}
