package sut.se.g14.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@Getter@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = " ContractArtist ")
public class ContractArtistEntity{
    @Id
    @SequenceGenerator(name="contractartist_seq",sequenceName="contractartist_seq_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="contractartist_seq_seq")  

    private @NonNull long id;

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z ]*")
    @Column( unique = true)
    @Size(min=2 , max = 10)
    private @NonNull String nameArtist;

    @NotNull(message = "Value must not be null to be valid")
    @Pattern(regexp="[a-zA-Z0-9 ,]*")
    @Size(min=4 , max = 15)
    
    private @NonNull String hiremoney;
   
    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z &]*")
    @Size(min= 2 , max = 10)
    private @NonNull String typecontract;

    @NotNull(message = "name must not be null to be valid")
    @Pattern(regexp="[a-zA-Z ]*")
    @Size(min=1 , max=10)
    private @NonNull String nameManager;




    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeContractEntity.class)
    @JoinColumn(name = "typecontract_id",insertable = true)
    private TypeContractEntity  idType;
   

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HireMoneyEntity.class)
    @JoinColumn(name = "hire_id",insertable = true)
    private HireMoneyEntity  idHire;
    

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Artists.class)
    @JoinColumn(name = "artist_id",insertable = true)
    private Artists idArtist;
    
    
    @NotNull(message = "manager must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "Manager_ID")
    private Manager manager;
   
    

    
    public void setnameArtist(String nameAString){this.nameArtist = nameAString;}
    public String getnameArtist() {return nameArtist;}

    public void setnameManager(String nameAString){this.nameManager = nameAString;}
    public String getnameManager() {return nameManager;}





    public void setIdArtist(Artists id){this.idArtist = id;}
    public Artists getIdArtist(){return  this.idArtist;}

    public void setManager(Manager id){this.manager = id;}
    public Manager getManager(){return  this.manager;}

   
    public void setIdType(TypeContractEntity id){this.idType = id;}
    public TypeContractEntity getIdType(){return  this.idType;}

    public void setIdHire(HireMoneyEntity id){this.idHire = id;}
    public HireMoneyEntity getIdHire(){return  this.idHire;}

    public void setHiremoney(String x){this.hiremoney=x;}
    public String getHiremoney(){return hiremoney;}

    public void setTypecontract(String x){this.typecontract=x;}
    public String getTypecontract(){return typecontract;}


    


   
}