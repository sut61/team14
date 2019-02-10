package sut.se.g14.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Old {
    @Id
    @SequenceGenerator(name="old_seq",sequenceName="old_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="old_seq")
    @Column(name="Old_ID")
    private @NonNull Long oldId;

    @Max(120)
    private @NonNull int old;

    public Long getOldId() {
        return oldId;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

   // public Old(){};
}
