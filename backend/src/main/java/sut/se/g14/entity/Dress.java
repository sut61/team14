package com.cpe.sa.main.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.*;

import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="dress")

public class Dress {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;
    private   String dress;
   
    @ManyToOne
    private Event event;
    @ManyToOne
    private Size size;
    @ManyToOne
    private Artists artist;
    @ManyToOne
    private Type Type;

    protected Dress(){    }

    public Dress(Long id,String dress) {
        this.id = id;
        this.dress = dress;
    }

}

