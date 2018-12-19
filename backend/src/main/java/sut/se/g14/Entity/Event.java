package com.example.semaster61;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="event")

public class Event {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;

    protected Event(){}
}