package com.example.semaster61;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="dress")

public class Dress {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;

    protected Dress(){}
}