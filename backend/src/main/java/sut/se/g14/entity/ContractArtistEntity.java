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

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @Column( unique = true)
    private @NonNull String nameArtist;

    @Min(500)@Max(1000000)
    private @NonNull int hiremoney;
   
    @NotNull(message = "name must not be null to be valid")
    private @NonNull String typecontract;

    @NotNull(message = "name must not be null to be valid")
    private @NonNull String nameManager;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeContractEntity.class)
    @JoinColumn(name = "typecontract_id",insertable = true)
    private TypeContractEntity  idType;


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


    public void setHiremoney(int x){this.hiremoney=x;}
    public int getHiremoney(){return hiremoney;}

    public void setTypecontract(String x){this.typecontract=x;}
    public String getTypecontract(){return typecontract;}


    


   
}