package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
public class RoomPractice {
    @Id
    @SequenceGenerator(name="roomPractice_seq",sequenceName="roomPractice_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomPractice_seq")
    @Column(name="roomPractice_ID")
    private @NonNull Long id;

    @NotNull(message = "Room must not be null to be valid")
    private @NonNull String room;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeRoomPractice.class)
    @JoinColumn(name = "typeRoomPractice_ID", insertable = true)
    private TypeRoomPractice typeRoomPractice;

    public RoomPractice(){};

    public RoomPractice(@NonNull String room, TypeRoomPractice typeRoomPractice) {
        this.room = room;
        this.typeRoomPractice = typeRoomPractice;
    }

    public Long getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public TypeRoomPractice getTypeRoomPractice() {
        return typeRoomPractice;
    }

    public void setTypeRoomPractice(TypeRoomPractice typeRoomPractice) {
        this.typeRoomPractice = typeRoomPractice;
    }
}
