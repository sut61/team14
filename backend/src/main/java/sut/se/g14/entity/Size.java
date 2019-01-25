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
@Table(name="size")

public class Size {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;
    private   String size;

    protected Size(){}
    public Size(String size) {
        this.size = size;
}}