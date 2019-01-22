package sut.se.g14.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TypeWork {
    @Id
    @SequenceGenerator(name="typeWork_seq",sequenceName="typeWork_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typeWork_seq")
    @Column(name="TypeWork_ID")
    private @NonNull Long typeworkId;

    private @NonNull String typeWork;

}