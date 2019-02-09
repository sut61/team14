package sut.se.g14.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
public class PrivilegeVIP {
    @Id
    @SequenceGenerator(name = "vip_seq",sequenceName = "vip_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vip_seq")

    @Column(name = "VIP_ID")
    private @NonNull Long idVIP;

    @NotNull(message = "numCredit must not be null to be valid")
    @Size(max=16, min=16)
    @Pattern(regexp = "[0-9]*")
    private @NonNull String numCredit;

    @NotNull(message = "numCvv must not be null to be valid")
    @Size(max=3, min=3)
    @Pattern(regexp = "[0-9]*")
    private @NonNull String numCvv;

    @NotNull(message = "email must not be null to be valid")
    @Email(message = "Email should be valid")
    private @NonNull String email;

    @NotNull(message = "dateExpMonth must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "DateExpMonth_ID")
    private DateExpMonth dateExpMonth;

    @NotNull(message = "dateExpYear must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "DateExpYear_ID")
    private DateExpYear dateExpYear;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    @NotNull(message = "typePrivilege must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "TYPEPRIVILEGE_ID")
    private TypePrivilege typePrivilege;

    @NotNull(message = "band must not be null to be valid")
    @ManyToOne
    @JoinColumn(name = "BAND_ID")
    private Band band;

    public PrivilegeVIP(String numCredit, String numCvv, String email,
                        DateExpMonth dateExpMonth, DateExpYear dateExpYear,
                        Profile profile, TypePrivilege typePrivilege, Band band) {
        this.numCredit = numCredit;
        this.numCvv = numCvv;
        this.email = email;
        this.dateExpMonth = dateExpMonth;
        this.dateExpYear = dateExpYear;
        this.profile = profile;
        this.typePrivilege = typePrivilege;
        this.band = band;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PrivilegeVIP(){  }

    public String getNumCredit() {
        return numCredit;
    }

    public void setNumCredit(String numCredit) {
        this.numCredit = numCredit;
    }

    public String getNumCvv() {
        return numCvv;
    }

    public void setNumCvv(String numCvv) {
        this.numCvv = numCvv;
    }

    public DateExpMonth getDateExpMonth() {
        return dateExpMonth;
    }

    public void setDateExpMonth(DateExpMonth dateExpMonth) {
        this.dateExpMonth = dateExpMonth;
    }

    public DateExpYear getDateExpYear() {
        return dateExpYear;
    }

    public void setDateExpYear(DateExpYear dateExpYear) {
        this.dateExpYear = dateExpYear;
    }

    public TypePrivilege getTypePrivilege() {
        return typePrivilege;
    }

    public void setTypePrivilege(TypePrivilege typePrivilege) {
        this.typePrivilege = typePrivilege;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Long getIdVIP() {
        return idVIP;
    }

    public void setIdVIP(Long idVIP) {
        this.idVIP = idVIP;
    }


}
