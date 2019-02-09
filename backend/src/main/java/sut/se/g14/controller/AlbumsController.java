package sut.se.g14.controller;

import sut.se.g14.repository.*;
import sut.se.g14.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class AlbumsController {
    @Autowired private AlbumsRepository albumsRepository;
    @Autowired private SongRepository songRepository;
    @Autowired private BandRepository bandRepository;
    @Autowired private ProducerRepository producerRepository;

    @GetMapping("/albums")
    public Collection<Albums> getAlbums(){

        return albumsRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/album/{albumsId}")
    public Albums getAlbumsById(@PathVariable Long albumsId){

        return albumsRepository.findById(albumsId).get();
    }


    @GetMapping("//{songId}")
    public Song getSongById(@PathVariable Long songId){

        return songRepository.findById(songId).get();
    }

    @GetMapping("//{producerId}")
    public Producer getProducerById(@PathVariable Long producerId){

        return producerRepository.findById(producerId).get();
    }

    @PostMapping("/albums/create/{BandID}/{producerID}/{name}/{onsales}")
    public Albums newAlbums(Albums newAlbums ,@PathVariable Long BandID,@PathVariable Long producerID,
                            @PathVariable String name,@PathVariable String onsales) throws ParseException {

        newAlbums.setBand(bandRepository.findById(BandID).get());
        newAlbums.setProducer(producerRepository.findById(producerID).get());
        newAlbums.setName(name);
        Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse(onsales);
        newAlbums.setOnsale(onsale);
        return this.albumsRepository.save(newAlbums);
    }
    @PostMapping("song/create/{name}/{time}")
    public Song newSong(Song newSong,@PathVariable String name,@PathVariable String time){

        newSong.setName(name);
        String[] timesong = time.split(":");
        Time timeSongSet = new Time(Integer.parseInt(timesong[0]), Integer.parseInt(timesong[1]), Integer.parseInt("00"));
        newSong.setTime(timeSongSet);
        return this.songRepository.save(newSong);
    }

    @PostMapping("/albums/addSong/{albumsID}/{name}")
    public Albums addSong(@PathVariable long albumsID,@PathVariable String name) {


            Albums albums1 = albumsRepository.findById (albumsID);
            albums1.setAlbumsID(albumsID);
            Song song = songRepository.findByName(name);
            song.setName(name);
            songRepository.save(song);
            albums1.getSongSet().add(song);

        return  albumsRepository.save(albums1);

    }
}

