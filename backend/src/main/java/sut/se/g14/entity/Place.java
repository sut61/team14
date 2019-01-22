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

    private @NonNull int hour;
}