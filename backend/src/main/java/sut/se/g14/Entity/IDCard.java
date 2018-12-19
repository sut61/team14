package sut.se.g14.entity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter

public class IDCard {
    @Id
    @Column(name = "CARD_NUMBER")
    private @NonNull Long cardID;
    @Temporal(TemporalType.DATE)
    private @NonNull Date brithDay;
}
