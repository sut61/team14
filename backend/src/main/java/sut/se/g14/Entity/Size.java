package com.example.semaster61;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="size")

public class Size {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;

    protected Size(){}
}