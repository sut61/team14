package sut.se.g14.entity;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;

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
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String nickname;
    private @NonNull Date birthday ;
    private @NonNull String phone;

    @ManyToOne
    @JoinColumn(name = "gender_ID")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "Manager_ID")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "BandID")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "TypeMusicID")
    private TypeMusic typeMusic;

    public Artists() {}
    public Artists(Long artistsID,String firstname , String lastname,String nickname,Date birthday,String phone) { //constructor

        this.artistsID = artistsID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.birthday = birthday;
        this.phone = phone;
    }
}
