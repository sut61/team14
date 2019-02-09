package sut.se.g14.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
public class DateExpMonth {
    @Id
    @SequenceGenerator(name = "DateExpMonth_seq" ,sequenceName = "DateExpMonth_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DateExpMonth_seq")
    @Column(name = "DateExpMonth_ID")
    private @NonNull Long expMonthId;

    private @NonNull String expMonth;

    public DateExpMonth(){ }
    public DateExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public Long getExpMonthId() {
        return expMonthId;
    }

    public void setExpMonthId(Long expMonthId) {
        this.expMonthId = expMonthId;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }
}
