package sut.se.g14.entity;

import javax.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Collection;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Setter @Getter
@ToString
@EqualsAndHashCode
@Table (name="Albums")

public class Albums {

    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="albums_seq",sequenceName="albums_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="albums_seq")
    @Column(name="albumsID")

    private @NonNull Long albumsID;

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z]*")
    @Size(min=5,max=25)
    @Column(unique = true)
    private @NonNull String name;

    @NotNull
    private @NonNull Date onsale ;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "BandID")
    private Band band;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "producerID")
    private Producer producer;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Song> songSet;


    public Long getAlbumsID() {
        return albumsID;
    }

    public void setAlbumsID(Long albumsID) {
        this.albumsID = albumsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOnsale() {
        return onsale;
    }

    public void setOnsale(Date onsale) {
        this.onsale = onsale;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Collection<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Collection<Song> songSet) {
        this.songSet = songSet;
    }

    public Albums() {}
    public Albums(Long albumsID,String name ,Date onsale) {

        this.albumsID = albumsID;
        this.name = name;
        this.onsale = onsale;
    }
}
