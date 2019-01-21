package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Manager {
    @Id
    @SequenceGenerator(name="manager_seq",sequenceName="manager_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="manager_seq")
    @Column(name="Manager_ID")
    private @NonNull Long id;
    private @NonNull String name;
    private @NonNull String username;
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "Gender_ID", insertable = true)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OrderBy("type ASC")
    private Collection<Contact> contactSet;
}
