package sut.se.g14.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

@Entity
@Data
@Getter@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = " Money ")
public class MoneyEntity{
    @Id
    @SequenceGenerator(name="money_seq",sequenceName="money_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="money_seq")  

    private @NonNull long idMoney;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Dress.class)
    @JoinColumn(name = "dress_id",insertable = true)
    private Dress  idDress;
    private  @NonNull String nameDress;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Quere.class)
    @JoinColumn(name = "queue_id",insertable = true)
    private Quere  idQueue;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Artists.class)
    @JoinColumn(name = "artist_id",insertable = true)
    private Artists idArtist;
   
    private @NonNull String firstname;
    


    private  int priceIncome;
    private  int priceExpenses;

    
    public void setnameArtist(String nameAString){this.firstname = nameAString;}
    public String getnameArtist() {return firstname;}
    
    public void setIdQueue(Quere  idQueue){this.idQueue = idQueue;}
    public void setIdArtist(Artists id){this.idArtist = id;}
    public Artists getIdArtist(){return  this.idArtist;}
    public void setnameDress(String nameDress){this.nameDress=nameDress;}
    public String getnameDress(){ return nameDress; }
    public void  setIdDress(Dress id){this.idDress = id;}
    public Dress getIdDress(){return  this.idDress;}


    public void setpriceIncome(int priceIncome){this.priceIncome = priceIncome;}
    public int getpeiceIncome(){return this.priceIncome;}

    public void setpriceExpenses(int priceExpenses){this.priceExpenses = priceExpenses;}
    public int getpriceExpenses(){return this.priceExpenses;}
}