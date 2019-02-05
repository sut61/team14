package sut.se.g14.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="TypeMusic")

public class TypeMusic {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name = "TypeMusic_seq", sequenceName = "TypeMusic_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeMusic_seq")
    @Column(name = "TypeMusicID")

    private @NonNull Long TypeMusicID;
    private @NonNull String typemusics;

    public Long getTypeMusicID() {
        return TypeMusicID;
    }

    public void setTypeMusicID(Long typeMusicID) {
        TypeMusicID = typeMusicID;
    }

    public String getTypemusics() {
        return typemusics;
    }

    public void setTypemusics(String typemusics) {
        this.typemusics = typemusics;
    }



    public TypeMusic() {
    }

    public TypeMusic(Long TypeMusicID,String typename) { //constructor

        this.TypeMusicID = TypeMusicID;
        this.typemusics = typename;
    }
}