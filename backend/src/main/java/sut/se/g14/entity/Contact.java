package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contact {
    @Id
    @SequenceGenerator(name="contact_seq",sequenceName="contact_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contact_seq")
    @Column(name="Contact_ID")
    private @NonNull Long id;
    private @NonNull String contact;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeContact.class)
    @JoinColumn(name = "Type_ID", insertable = true)
    private TypeContact type;
}
