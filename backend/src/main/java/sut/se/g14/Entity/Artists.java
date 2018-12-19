package com.example.demo.Entity;

import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="Artists")

public class Artists {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="artists_seq",sequenceName="artists_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="artists_seq")
    @Column(name="artistsID")

    private @NonNull Long artistsID;

    public Artists() {}
    public Artists(Long artistsID) { //constructor
        this.artistsID = artistsID;
    }
}
