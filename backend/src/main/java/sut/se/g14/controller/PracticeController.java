package sut.se.g14.controller;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PracticeController {
    @Autowired private final PracticeRepository practiceRepository;
    @Autowired private BandRepository bandRepository;
    @Autowired private ManagerRepository managerRepository;
    @Autowired private RoomPracticeRepository roomPracticeRepository;
    @Autowired private TypeRoomPracticeRepository typeRoomPracticeRepository;
    @Autowired private TypePracticeRepository typePracticeRepository;

    @Autowired
    PracticeController(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    @GetMapping("/TypePractice")
    public Collection<TypePractice> allTypePractice() {
        return typePracticeRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Room")
    public Collection<RoomPractice> allRoomPractice() {
        return roomPracticeRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Practice")
    public Collection<Practice> allPractice() {
        return practiceRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/newPractice/{trainer}/{date}/{startTime}/{endTime}/{detail}/{idRoom}/{idType}/{idBand}/{username}")
    public Practice addPractice(@PathVariable String trainer, @PathVariable String date, @PathVariable String startTime,
                                @PathVariable String endTime, @PathVariable String detail, @PathVariable long idRoom,
                                @PathVariable long idType, @PathVariable long idBand, @PathVariable String username) throws ParseException {

        Date dateSet = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        String[] timeStart = startTime.split(":");
        String[] timeEnd = endTime.split(":");
        Time startTimeSet = new Time(Integer.parseInt(timeStart[0]), Integer.parseInt(timeStart[1]), Integer.parseInt("00"));
        Time endTimeSet = new Time(Integer.parseInt(timeEnd[0]), Integer.parseInt(timeEnd[1]), Integer.parseInt("00"));

        RoomPractice roomPractice = roomPracticeRepository.findById(idRoom);
        TypePractice typePractice = typePracticeRepository.findById(idType);
        Band band = bandRepository.findById(idBand);
        Manager manager = managerRepository.findByUsername(username);

        Practice practice = new Practice(trainer,dateSet,startTimeSet,endTimeSet,detail,roomPractice,typePractice,band,manager);
        return practiceRepository.save(practice);
    }
}
