package com.example.semaster61;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="artist")

public class Artist {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;

    protected Artist(){}
}