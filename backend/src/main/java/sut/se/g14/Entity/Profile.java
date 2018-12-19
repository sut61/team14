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

    public Profile(){ }

}
