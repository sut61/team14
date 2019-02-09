package sut.se.g14.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
public class DateExpYear {
    @Id
    @SequenceGenerator(name = "DateExpYear_seq" ,sequenceName = "DateExpYear_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DateExpYear_seq")
    @Column(name = "DateExpYear_ID")
    private @NonNull Long expYearId;

    private @NonNull String expYear;

    public DateExpYear() { }
    public DateExpYear(@NonNull String expYear) {
        this.expYear = expYear;
    }

    public Long getExpYearId() {
        return expYearId;
    }

    public void setExpYearId(Long expYearId) {
        this.expYearId = expYearId;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}
