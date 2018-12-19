package com.okta.developer.demo.entity;

import  javax.persistence.*;
import com.okta.developer.demo.entity.*;
import lombok.*;

import org.hibernate.annotations.SortNatural;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.Collection;

@Entity
@Data
@Getter@Setter
//@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = "Expenses")
public class ExpensesEntity {
    @Id
    @SequenceGenerator(name="expenses_seq",sequenceName="expenses_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="expenses_seq")  
    @Column(name = "EXPENSES_ID", unique = true, nullable = true)
    private @NonNull int idEx;
    private @NonNull String nameExpenses;

    //Dorm
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DormEntity.class)
    @JoinColumn(name = "dorm_id", insertable = true)
    private DormEntity  idDorm;
    private @NonNull String nameDorm;

    //artist
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ArtistEntity.class)
    @JoinColumn(name = "artist_id", insertable = true)
    private ArtistEntity idArtist;
    private @NonNull String dataArtist;
    private @NonNull String nameArtist;



    private @NonNull int expensesPrice;
  
    public ExpensesEntity() {}

    public ExpensesEntity(int idEx,String nameExpenses,int expenses) {
        this.idEx=idEx;
        this.nameExpenses = nameExpenses;
        this.expensesPrice=expenses;
    }

    public int getIdExpenses(){return idEx;}
    public void setnameExpenses(String nameExpenses){ this.nameExpenses=nameExpenses;}
    public String getnameExpenses(){return nameExpenses;}
    public void setExpensesPrice(int expenses){ this.expensesPrice=expenses;}
    public int getExpensesPrice(){return expensesPrice;}

    //insert Dorm
    //public void setIdDorm(DormEntity idDorm){ this.idDorm = idDorm;}
    public DormEntity getIdDorm(){return idDorm;}
    public void setNameDorm(String nameDorm){this.nameDorm = nameDorm;}
    public String getNameDorm(){return nameDorm;}

    //insert artist
    //public void setIdArtist(ArtistEntity idArtist){ this.idArtist = idArtist;}
    public ArtistEntity getIdArtist(){return idArtist;}
    public void setdataArtist(String dataArtist){ this.dataArtist = dataArtist;}
    public String getdataArtist(){ return dataArtist; }
    public void setnameArtist(String nameArtist){ this.nameArtist = nameArtist;}
    public String getnameArtist() {return nameArtist;}

    


}