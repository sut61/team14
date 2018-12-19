package com.okta.developer.demo.entity;

import  javax.persistence.*;
import com.okta.developer.demo.entity.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Data
@Getter@Setter
//@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = "Income")
public class IncomeEntity{
    @Id
    @SequenceGenerator(name="income_seq",sequenceName="income_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="income_seq")  
    @Column(name = "INCOME_ID", unique = true, nullable = true)
    private @NonNull int idIncome;
    private  @NonNull String nameIncome;
/*
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ArtistEntity.class)
    @JoinColumn(name = "artist_id", insertable = true)
    private ArtistEntity idArtist;
*/

    private @NonNull String dataArtist;
    private @NonNull String nameArtist;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StockEntity.class)
    @JoinColumn(name = "stock_id", insertable = true)
    private StockEntity idStock;
    private @NonNull String nameStock;
    
    


    private @NonNull int incomePrice;
    
   
    public IncomeEntity() {}

    public IncomeEntity(int idIncome,String nameIncome,int incomePrice) {
        this.idIncome=idIncome;
        this.nameIncome=nameIncome;
        this.incomePrice=incomePrice;
        
    }
    public int getIdIncome(){ return idIncome;}
    public void setnameIncome(String nameIncome){ this.nameIncome = nameIncome;}
    public String getnameIncome(){ return nameIncome; }
    public void setIncomePrice(int incomePrice){ this.incomePrice = incomePrice;}
    public int getIncomePrice() {     return incomePrice; }


   
    //public void setIdArtist(ArtistEntity idArtist){ this.idArtist = idArtist;}
    //public ArtistEntity getIdArtist(){return idArtist;}
    public void setdataArtist(String dataArtist){ this.dataArtist = dataArtist;}
    public String getdataArtist(){ return dataArtist; }
    public void setnameArtist(String nameArtist){ this.nameArtist = nameArtist;}
    public String getnameArtist() {return nameArtist;}

    //public void setIdStock(StockEntity number){this.idStock = number;}
    public StockEntity getIdStock(){ return idStock;} 
    public void setNameStock(String name){ this.nameStock = name; }
    public String getNameStock(){ return nameStock; }


    

}