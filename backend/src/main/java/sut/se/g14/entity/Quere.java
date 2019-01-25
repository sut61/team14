package sut.se.g14.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Quere {
    @Id
    @SequenceGenerator(name = "quere_seq", sequenceName = "quere_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quere_seq")
    @Column(name = "Quere_ID")
    private @NonNull long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Place.class)
    @JoinColumn(name = "PQ_ID", insertable = true)
    private Place placeQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "SQ_ID", insertable = true)
    private Status statusQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Artists.class)
    @JoinColumn(name = "AQ_ID", insertable = true)
    private Artists  artistQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeWork.class)
    @JoinColumn(name = "TQ_ID", insertable = true)
    private TypeWork typeworkQuere;
}