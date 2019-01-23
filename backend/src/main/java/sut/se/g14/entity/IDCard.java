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
    @Column(name = "CARD_ID")
    private @NonNull Long cardIdNum;
    @Temporal(TemporalType.DATE)
    private @NonNull Date birthDay;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    public IDCard(){}

    public IDCard(@NonNull Long cardIdNum, @NonNull Date brithDay, Profile profile) {
        this.cardIdNum = cardIdNum;
        this.birthDay = brithDay;
        this.profile = profile;
    }

    public Long cardIdNum() {
        return cardIdNum;
    }

    public void setCardIdNum(Long cardIdNum) {
        this.cardIdNum = cardIdNum;
    }

    public Date getBrithDay() {
        return birthDay;
    }

    public void setBrithDay(Date brithDay) {
        this.birthDay = brithDay;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

