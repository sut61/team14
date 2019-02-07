package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class HireMoneyEntity {

    @Id
    @SequenceGenerator(name="hire_seq",sequenceName="hire_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hire_seq")
    @Column(name="hire_id")
    private @NonNull Long id;
    private @NonNull String money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

}
