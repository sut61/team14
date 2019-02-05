package sut.se.g14.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Place {
    @Id
    @SequenceGenerator(name="place_seq",sequenceName="place_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="place_seq")
    @Column(name="Place_ID")
    private @NonNull Long placeId;

    private @NonNull String place;

    private @NonNull Date date;

    private @NonNull Time time;

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    private @NonNull int hour;
}