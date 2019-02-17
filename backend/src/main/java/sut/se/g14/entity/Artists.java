package sut.se.g14.entity;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z]*")
    @Size(min=2)
    private @NonNull String firstname;

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z]*")
    private @NonNull String lastname;

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z]*")
    @Size(max=10)
    private @NonNull String nickname;

    @NotNull
    private @NonNull Date birthday ;

    @NotNull(message = "phone must not be null to be valid")
    @Pattern(regexp = "\\d{10}")
    @Column(unique = true)
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

    public Long getArtistsID() {
        return artistsID;
    }

    public void setArtistsID(Long artistsID) {
        this.artistsID = artistsID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public TypeMusic getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(TypeMusic typeMusic) {
        this.typeMusic = typeMusic;
    }

    public Artists() {}
    public Artists(Long artistsID,@NotNull  String firstname ,@NotNull String lastname,@NotNull String nickname,@NotNull Date birthday,@NotNull String phone) { //constructor

        this.artistsID = artistsID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.birthday = birthday;
        this.phone = phone;
    }
}
