package sut.se.g14.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.*;
@Entity
@Data
@Table(name="sizes")

public class Sizes {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;

    @Column(unique = true)
    private   String size;

    public Sizes(){}
    public Sizes(String size) {
        this.size = size;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}