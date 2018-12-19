package sut.se.g14.entity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq",sequenceName = "address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_seq")
    @Column(name = "ADDRESS_ID")

    private @NonNull Long addressID;
    public Address (){}
}
