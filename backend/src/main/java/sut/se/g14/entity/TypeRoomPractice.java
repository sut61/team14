package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
public class TypeRoomPractice {
    @Id
    @SequenceGenerator(name="typeRoomPractice_seq",sequenceName="typeRoomPractice_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typeRoomPractice_seq")
    @Column(name="typeRoomPractice_ID")
    private @NonNull Long id;

    @NotNull(message = "type must not be null to be valid")
    private @NonNull String type;

    public TypeRoomPractice(){};
    public TypeRoomPractice(@NonNull String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
