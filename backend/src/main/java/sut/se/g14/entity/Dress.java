package sut.se.g14.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    
    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z]*")
    @Size(min=4,max=20)
    private   String dress;


    @ManyToOne
    @NotNull(message = "name must not be null to be valid")
    private Event event;

    
    @ManyToOne
    @NotNull(message = "name must not be null to be valid")
    private Sizes size;

    @ManyToOne
    @NotNull(message = "name must not be null to be valid")
    private Artists artist;

    
    @ManyToOne
    @NotNull(message = "name must not be null to be valid")
    private Type Type;

    public Dress(){    }

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

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
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

