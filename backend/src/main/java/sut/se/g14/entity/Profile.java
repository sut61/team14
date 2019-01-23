package sut.se.g14.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter

public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq",sequenceName = "profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profile_seq")
    @Column(name = "PROFILE_ID")

    private @NonNull Long profileID;
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String addressDetail;
    private @NonNull Long pastalCade;
    private @NonNull Long mobilePhone;

    @OneToOne
    private Members members;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;

    public Profile(){}

    public Profile(String name, String email,String addressDetail, Long pastalCade, Long mobilePhone,
                   Members members, Country country, Gender gender ) {
        this.name = name;
        this.email = email;
        this.addressDetail = addressDetail;
        this.pastalCade = pastalCade;
        this.mobilePhone = mobilePhone;
        this.members = members;
        this.country = country;
        this.gender = gender;
    }


    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Long getPastalCade() {
        return pastalCade;
    }

    public void setPastalCade(Long pastalCade) {
        this.pastalCade = pastalCade;
    }

    public Long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

