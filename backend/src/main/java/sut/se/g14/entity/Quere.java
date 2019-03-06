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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Band.class)
    @JoinColumn(name = "AQ_ID", insertable = true)
    private Band  bandQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeWork.class)
    @JoinColumn(name = "TQ_ID", insertable = true)
    private TypeWork typeworkQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Format.class)
    @JoinColumn(name = "FM_ID", insertable = true)
    private Format  formatWork;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Place getPlaceQuere() {
        return placeQuere;
    }

    public void setPlaceQuere(Place placeQuere) {
        this.placeQuere = placeQuere;
    }

    public Status getStatusQuere() {
        return statusQuere;
    }

    public void setStatusQuere(Status statusQuere) {
        this.statusQuere = statusQuere;
    }

    public Band getBandQuere() {
        return bandQuere;
    }

    public void setBandQuere(Band bandQuere) {
        this.bandQuere = bandQuere;
    }

    public TypeWork getTypeworkQuere() {
        return typeworkQuere;
    }

    public void setTypeworkQuere(TypeWork typeworkQuere) {
        this.typeworkQuere = typeworkQuere;
    }

    public Format getFormatWork() {
        return formatWork;
    }

    public void setFormatWork(Format formatWork) {
        this.formatWork = formatWork;
    }
}