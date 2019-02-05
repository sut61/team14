package sut.se.g14.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.*;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="dress")

public class Dress {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;
    private   String dress;
   
    @ManyToOne
    private Event event;
    @ManyToOne
    private Size size;
    @ManyToOne
    private Artists artist;
    @ManyToOne
    private Type Type;

    protected Dress(){    }

    public Dress(Long id,String dress) {
        this.id = id;
        this.dress = dress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public sut.se.g14.entity.Type getType() {
        return Type;
    }

    public void setType(sut.se.g14.entity.Type type) {
        Type = type;
    }


}

