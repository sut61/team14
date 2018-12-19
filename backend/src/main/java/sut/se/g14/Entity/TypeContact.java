package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TypeContact {
    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq")
    @Column(name="Type_ID")
    private @NonNull Long id;
    private @NonNull String type;
}
