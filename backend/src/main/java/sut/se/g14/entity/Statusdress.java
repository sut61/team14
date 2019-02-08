package sut.se.g14.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
@Entity
@Data
@NoArgsConstructor

@Table(name="statusdress")

public class Statusdress {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;
     private   String statusdress ;

     public Statusdress( String statusdress){
         this.statusdress = statusdress;
     }
}