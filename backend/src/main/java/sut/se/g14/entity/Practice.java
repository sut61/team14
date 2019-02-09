package sut.se.g14.entity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;

import java.util.Date;
import java.sql.Time;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Practice {
    @Id
    @SequenceGenerator(name="practice_seq",sequenceName="practice_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="practice_seq")
    @Column(name="practice_ID")
    private @NonNull Long id;

    @Pattern(regexp="[a-zA-Z0-9_. ]*")
    private @NonNull String trainer;

    @Future
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "date must not be null to be valid")
    private @NonNull Date date;

    @NotNull(message = "startTime must not be null to be valid")
    private @NonNull Time startTime;

    @NotNull(message = "endTime must not be null to be valid")
    private @NonNull Time endTime;

    @NotNull(message = "detail must not be null to be valid")
    @Size(min=10)
    @Pattern(regexp="[a-zA-Z0-9_. ]*")
    private @NonNull String detail;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomPractice.class)
    @JoinColumn(name = "roomPractice_ID", insertable = true)
    private RoomPractice roomPractice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypePractice.class)
    @JoinColumn(name = "typePractice_ID", insertable = true)
    private TypePractice typePractice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Band.class)
    @JoinColumn(name = "band_ID", insertable = true)
    private Band band;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Manager.class)
    @JoinColumn(name = "manager_ID", insertable = true)
    private Manager manager;

    public Practice (){

    }

    public Practice(@NonNull String trainer, @NonNull Date date, @NonNull Time startTime, @NonNull Time endTime,
                    @NonNull String detail, RoomPractice roomPractice, TypePractice typePractice, Band band, Manager manager){
        this.trainer = trainer;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.detail = detail;
        this.roomPractice = roomPractice;
        this.typePractice = typePractice;
        this.band = band;
        this.manager = manager;
    }


    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public RoomPractice getRoomPractice() {
        return roomPractice;
    }

    public void setRoomPractice(RoomPractice roomPractice) {
        this.roomPractice = roomPractice;
    }

    public TypePractice getTypePractice() {
        return typePractice;
    }

    public void setTypePractice(TypePractice typePractice) {
        this.typePractice = typePractice;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
