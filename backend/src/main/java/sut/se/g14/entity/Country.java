package sut.se.g14.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Country {

    @Id
    @SequenceGenerator(name = "country_seq",sequenceName = "country_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_seq")
    @Column(name = "COUNTRY_ID")

    private @NonNull Long countryID;
    private @NonNull String countryName;

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
