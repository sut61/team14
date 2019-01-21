package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Gender {
    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
    @Column(name="gender_ID")
    private @NonNull Long id;
    private @NonNull String gender;
}
