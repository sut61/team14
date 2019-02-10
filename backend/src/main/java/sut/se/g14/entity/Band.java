package sut.se.g14.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "bandname must not be null to be valid")
    private @NonNull String bandname;

    public Band() {}
    public Band(Long BandID,String name) { //constructor

        this.BandID = BandID;
        this.bandname = name;
    }
    public Long getBandID() {
        return BandID;
    }

    public void setBandID(Long bandID) {
        BandID = bandID;
    }

    public String getBandname() {
        return bandname;
    }

    public void setBandname(String bandname) {
        this.bandname = bandname;
    }
}
