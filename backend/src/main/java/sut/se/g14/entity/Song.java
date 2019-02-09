package sut.se.g14.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.*;
import java.sql.Time;

@Entity
@Setter @Getter
@ToString
@EqualsAndHashCode
@Table (name="Song")

public class Song {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="song_seq",sequenceName="song_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="song_seq")
    @Column(name="songID")

    private @NonNull Long songID;


    @Size(min=2)
    private String name;

    public Long getSongID() {
        return songID;
    }

    public void setSongID(Long songID) {
        this.songID = songID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    private @NonNull Time time;

    public Song() {}
    public Song (Long id,String name,Time time){
        this.songID = id;
        this.name = name;
        this.time = time;
    }
}
