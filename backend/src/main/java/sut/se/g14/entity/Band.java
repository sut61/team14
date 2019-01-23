package com.example.demo.Entity;
import javax.persistence.*;
import lombok.*;


@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="Band")

public class Band {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="Band_seq",sequenceName="Band_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Band_seq")
    @Column(name="BandID")

    private @NonNull Long BandID;
    private @NonNull String bandname;

    public Band() {}
    public Band(Long BandID,String name) { //constructor

        this.BandID = BandID;
        this.bandname = name;
    }
}
