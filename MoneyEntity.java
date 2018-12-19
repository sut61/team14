package com.okta.developer.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

@Entity
@Data
@Getter@Setter
//@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = " Money ")
public class MoneyEntity{
    @Id
    @SequenceGenerator(name="money_seq",sequenceName="money_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="money_seq")  
    @Column(name = "MONEY_ID", unique = true, nullable = true)
    private @NonNull int idMoney;
/*
    @OneToOne(fetch = FetchType.LAZY, targetEntity = DormEntity.class)
    private DormEntity  idDorm;
    private @NonNull String nameDorm;
   */ 
/*
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ArtistEntity.class)
    @JoinColumn(name = "artist_id", insertable = true)
    private ArtistEntity idArtist;

    private @NonNull String nameArtist;
    private @NonNull String dataArtist;

    
    
    private @NonNull long income;
*/

@OneToOne(fetch = FetchType.LAZY, targetEntity = ExpensesEntity.class)
private ExpensesEntity  idExpenses;
private @NonNull String nameExpenses;

//private int  idDorm;
private @NonNull String nameDorm;
private @NonNull int priceExpenses;


@OneToOne(fetch = FetchType.LAZY, targetEntity = IncomeEntity.class)
private IncomeEntity  idIncome;
private @NonNull String nameIncome;

//private @NonNull int idStock;
private @NonNull String nameStock;
private @NonNull String dataArtist;
private @NonNull String Artistname;

private @NonNull int priceIncome;
   


    public MoneyEntity() {}

    public MoneyEntity(int idMoney) {
        this.idMoney=idMoney;
    }
    
    public int getidMoney(){return idMoney;}

    //public void setIdExpenses(ExpensesEntity ex){this.idExpenses=ex;}
    public ExpensesEntity getIdExpenses(){return idExpenses;}
    //public void setIdIncome(IncomeEntity in){this.idIncome=in;}
    public IncomeEntity getIdIncome(){return idIncome;}

//expenses
    public void setnameExpenses(String expen){this.nameExpenses=expen;}
    public void setExpensesPrice(int expenses){ this.priceExpenses=expenses;}
    public int getExpensesPrice(){return priceExpenses;}
//dorm
   // public void setIdDorm(int idDorm){ this.idDorm = idDorm;}
    //public int getIdDorm(){return idDorm;}
    public void setNameDorm(String nameDorm){this.nameDorm = nameDorm;}
    public String getNameDorm(){return nameDorm;}

//income
    public void setnameIncome(String income){this.nameIncome=income;}
    public String getnameIncome(){ return nameIncome; }
    public void setIncomePrice(int incomePrice){ this.priceIncome = incomePrice;}
    public int getIncomePrice() {     return priceIncome; }

//artist
    public void setdataArtist(String dataArtist){ this.dataArtist = dataArtist;}
    public String getdataArtist(){ return dataArtist; }
    public void setnameArtist(String nameArtist){ this.Artistname = nameArtist;}
    public String getnameArtist() {return Artistname;}

//stock
  //  public void setIdStock(int number){this.idStock = number;}
  //  public int getIdStock(){ return idStock;} 
    public void setnameStock(String name){ this.nameStock = name; }
    public String getnameStock(){ return nameStock; }



/*
    public void setIdDorm(DormEntity idDorm){ this.idDorm = idDorm;}
    public DormEntity getIdDorm(){return idDorm;}
    public void setNameDorm(String nameDorm){this.nameDorm = nameDorm;}
    public String getNameDorm(){return nameDorm;}
*/


/*
    public void setIdArtist(ArtistEntity idArtist){ this.idArtist = idArtist;}
    public ArtistEntity getIdArtist(){return idArtist;}
    public void setdataArtist(String dataArtist){ this.dataArtist = dataArtist;}
    public String getdataArtist(){ return dataArtist; }
    public void setnameArtist(String nameArtist){ this.nameArtist = nameArtist;}
    public String getnameArtist() {return nameArtist;}

*/

/*
    public void setCarName(String carname){ this.carname = carname; }
    public String getCarName(){return carname;}
    
    public void setIdManager(ManagerEntity idManager){ this.idManager = idManager;}
    public ManagerEntity getIdManager(){ return idManager;}

    public void setFNameManager(String Fmanagername){ this.Fmanagername = Fmanagername;}
    public String getFNameManager(){ return Fmanagername;}

    public void setLNameManager(String Lmanagername){ this.Lmanagername = Lmanagername;}
    public String getLNameManager(){ return Lmanagername;}


    public void setIdArtist(ArtistEntity idArtist){ this.idArtist = idArtist;}
    public ArtistEntity getIdArtist(){ return idArtist;}

    public void setNameArtist(String NameArtist){ this.NameArtist = NameArtist;}
    public String getNameArtistr(){ return NameArtist;}
*/

}