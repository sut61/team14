package sut.se.g14.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;

@Entity
@Getter @Setter

public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq",sequenceName = "profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profile_seq")
    @Column(name = "PROFILE_ID")

    private @NonNull Long profileID;

    @NotNull(message = "Name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z. ]*")
    @Column(unique = true)
    private @NonNull String name;

    @Size(min = 10, max=10)
    @Pattern(regexp = "[0-9]*")
    private @NonNull String mobilePhone;

    @NotNull(message = "addressDetail must not be null to be valid")
    @Pattern(regexp="[a-zA-Z0-9-_. ]*")
    private @NonNull String addressDetail;

    @NotNull(message = "pastalCode must not be null to be valid")
    private @NonNull Long pastalCade;

    @OneToOne
    @JoinColumn(name = "Members_ID")
    private Members members;


    @NotNull(message = "country must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @NotNull(message = "gender must not be null to be valid")
    @JoinColumn(name = "Gender_ID", insertable = true)
    private Gender gender;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value=FetchMode.SUBSELECT)
    @OrderBy("id Desc")
    private Collection<Quere> quereSet;


    public Profile(){ }


    public Profile(String name, String addressDetail,Long pastalCade, String mobilePhone,
                   Members members, Country country, Gender gender, Collection<Quere> quereSet) {
        this.name = name;
        this.addressDetail = addressDetail;
        this.pastalCade = pastalCade;
        this.mobilePhone = mobilePhone;
        this.members = members;
        this.country = country;
        this.gender = gender;
        this.quereSet = quereSet;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
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

    public Collection<Quere> getQuereSet() {
        return quereSet;
    }

    public void setQuereSet(Collection<Quere> quereSet) {
        this.quereSet = quereSet;
    }


}

