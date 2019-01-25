package sut.se.g14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.g14.entity.Members;
import sut.se.g14.repository.MembersRepository;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MembersController {
    @Autowired
    private MembersRepository membersRepository;

    @GetMapping(path = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Members> getMembers(){
        return membersRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/member/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Members getOneMembers (@PathVariable String username){
        return membersRepository.findById(username).get();
    }
    @PostMapping(path = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Members postMember(@RequestBody Members members){
        return membersRepository.save(members);
    }
}
