package com.example.demo.Entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="Band")

public class Band {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="Band_seq",sequenceName="Band_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Bands_seq")
    @Column(name="BandID")

    private @NonNull Long BandID;

    public Band() {}
    public Band(Long BandID) { //constructor
        this.BandID = BandID;
    }
}
