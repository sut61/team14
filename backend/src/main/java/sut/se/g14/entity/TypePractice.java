package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
public class TypePractice {
    @Id
    @SequenceGenerator(name="typePractice_seq",sequenceName="typePractice_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typePractice_seq")
    @Column(name="typePractice_ID")
    private @NonNull Long id;

    @NotNull(message = "type must not be null to be valid")
    private @NonNull String type;

    public TypePractice(){};

    public TypePractice(@NonNull String type) {
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
