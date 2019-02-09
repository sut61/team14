package sut.se.g14.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
public class TypePrivilege {
    @Id
    @SequenceGenerator(name = "privilege_seq" ,sequenceName = "privilege_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_seq")
    @Column(name = "privilege_ID")
    private @NonNull Long idPrivilege;

    private @NonNull String typePrivilege;

    public TypePrivilege(){  }

    public TypePrivilege(@NonNull String typePrivilege) {
        this.typePrivilege = typePrivilege;
    }

    public Long getIdPrivilege() {
        return idPrivilege;
    }

    public void setIdPrivilege(Long idPrivilege) {
        this.idPrivilege = idPrivilege;
    }

    public String getTypePrivilege() {
        return typePrivilege;
    }

    public void setTypePrivilege(String typePrivilege) {
        this.typePrivilege = typePrivilege;
    }
}
