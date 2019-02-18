package sut.se.g14.controller;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TableWorkController {

    @Autowired private final TableWorkRepository tableWorkRepository;
    @Autowired private QuereRepository quereRepository;

    @Autowired private  ManagerRepository managerRepository;
    @Autowired private  OldRepository oldRepository;
    @Autowired private FormatRepository formatRepository;
    @Autowired private  StatusRepository statusRepository;

    TableWorkController(TableWorkRepository tableWorkRepository) {
        this.tableWorkRepository = tableWorkRepository;
    }

    @GetMapping("/TableWorks")
    public Collection<TableWork> TableWork() {
        return tableWorkRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("TableWork/{id}")
    public Optional <TableWork> View(@PathVariable Long tableWorkId) {
        Optional<TableWork> tableWork = tableWorkRepository.findById(tableWorkId);
        return tableWork;
    }

    @PostMapping("/newTableWork/{id}/{username}/{invite}/{tag}/{price}/{old}/{format}")
    public TableWork addTableWork( @PathVariable long id,@PathVariable String username, @PathVariable String invite, @PathVariable String tag, @PathVariable Long price,
                                   @PathVariable Long old, @PathVariable Long format
    ) {
        TableWork newTableWork = new TableWork();
        Quere quere = quereRepository.findById(id);
        Manager manager = managerRepository.findByUsername(username);
        Format formats = formatRepository.findByFormatId(format);
        Old olds = oldRepository.findByOldId(old);
        Status status = statusRepository.findByStatusId(2L);

        quere.setStatusQuere(status);
        quereRepository.save(quere);

        newTableWork.setInvite(invite);
        newTableWork.setTag(tag);
        newTableWork.setPrice(price);
        newTableWork.setTableWorkQuere(quere);
        newTableWork.setManagerWork(manager);
        newTableWork.setOldWork(olds);
        newTableWork.setFormatWork(formats);
        /*
        for(String s : tagSet){
            Hashtag hashtag = new Hashtag();
            hashtag.setTag(s);
            hashtagRepository.save(hashtag);
            newTableWork.getTableWorkTag().add(hashtag);
            //tableWorkRepository.save(newTableWork);
        }*/
        return tableWorkRepository.save(newTableWork);
    }
}
