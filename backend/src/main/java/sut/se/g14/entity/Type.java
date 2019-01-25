package sut.se.g14.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.*;
@Entity
@Data
@Table(name="type")

public class Type {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long id;
    private   String type;


  protected Type(){}
  public Type(String type) {
    this.type = type;
}}