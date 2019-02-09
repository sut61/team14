package sut.se.g14.entity;
import javax.persistence.*;
import lombok.*;


@Entity
@Setter @Getter
@ToString
@EqualsAndHashCode
@Table (name="Producer")

public class Producer {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="producer_seq",sequenceName="producer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="producer_seq")
    @Column(name="producerID")

    private @NonNull Long producerID;
    private @NonNull String name;

    public Long getProducerID() {
        return producerID;
    }

    public void setProducerID(Long producerID) {
        this.producerID = producerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer(){}
    public Producer (Long id,String name){
        this.name = name;
        this.producerID = id;
    }
}
