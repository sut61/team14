package sut.se.g14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrivilegeVIPController {
    @Autowired
    private PrivilegeVIPRepository privilegeVIPRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private  BandRepository bandRepository;
    @Autowired
    private TypePrivilegeRepository typePrivilegeRepository;
    @Autowired
    private DateExpYearRepository dateExpYearRepository;
    @Autowired
    private DateExpMonthRepository dateExpMonthRepository;


    @GetMapping("/Privilege")
    public Collection<PrivilegeVIP> PrivilegeVIP() {
        return privilegeVIPRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Privilege/{idVIP}")
    public PrivilegeVIP getOnePrivilegeVIP(@PathVariable Long idVIP){
        return privilegeVIPRepository.findById(idVIP).get();
    }

    @GetMapping(path = "/Privilege/profile/{profileId}")
    public PrivilegeVIP privilegeVIP(@PathVariable Long  profileId){
        return privilegeVIPRepository.findByProfile(profileRepository.findById(profileId).get()) ;
    }

    @PostMapping(path = "/Privilege/{dateExpM}/{dateExpY}/{profileID}/{BandID}/{idPrivilege}")
    public PrivilegeVIP newPrivilege(@RequestBody PrivilegeVIP privilegeVIP,
                                     @PathVariable long dateExpM, @PathVariable long dateExpY,
                                     @PathVariable Long profileID, @PathVariable long BandID,
                                     @PathVariable long idPrivilege){

        Profile profile = profileRepository.findByProfileID(profileID);
        Band band = bandRepository.findById(BandID);
        TypePrivilege typePrivilege = typePrivilegeRepository.findById(idPrivilege);
        DateExpMonth dateExpMonth = dateExpMonthRepository.findById(dateExpM);
        DateExpYear dateExpYear = dateExpYearRepository.findById(dateExpY);

        privilegeVIP.setDateExpMonth(dateExpMonth);
        privilegeVIP.setDateExpYear(dateExpYear);
        privilegeVIP.setProfile(profile);
        privilegeVIP.setBand(band);
        privilegeVIP.setTypePrivilege(typePrivilege);

        return privilegeVIPRepository.save(privilegeVIP);
    }
}
