package sut.se.g14.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.time.LocalDate;
import java.util.*;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="sponser")

public class Sponser {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  @NonNull Long id;
    

    @Pattern(regexp="[a-z]*")
    @NotNull(message="prefix must not be null to be valid")
    @Size(min=2,max=10)
    private  String sponser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private    Date datereturn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private    Date date;

    @NotNull(message="prefix must not be null to be valid")
    @ManyToOne
    private Dress dress;


    @NotNull(message="prefix must not be null to be valid")
    @ManyToOne
    private Statusdress statusdress;

    
    @NotNull(message="prefix must not be null to be valid")
    @ManyToOne
    private Artists artists;


    public Sponser(){}

}
   