package com.example.demo.Entity;

import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="TypeMusic")

public class TypeMusic {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name = "TypeMusic_seq", sequenceName = "TypeMusic_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeMusic_seq")
    @Column(name = "TypeMusicID")

    private @NonNull Long TypeMusicID;

    public TypeMusic() {
    }

    public TypeMusic(Long TypeMusicID) { //constructor
        this.TypeMusicID = TypeMusicID;
    }
}