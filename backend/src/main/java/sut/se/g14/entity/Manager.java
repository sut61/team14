package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Manager {
    @Id
    @SequenceGenerator(name="manager_seq",sequenceName="manager_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="manager_seq")
    @Column(name="Manager_ID")
    private @NonNull Long id;

    @Pattern(regexp="[a-zA-Z ]*")
    @NotNull(message = "name must not be null to be valid")
    private @NonNull String name;

    @NotNull(message = "username must not be null to be valid")
    @Pattern(regexp="[a-zA-Z0-9_.]*")
    @Column(unique = true)
    private @NonNull String username;

    @NotNull(message = "password must not be null to be valid")
    @Pattern(regexp="[a-zA-Z0-9]*")
    @Size(min=8)
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @NotNull(message = "gender must not be null to be valid")
    @JoinColumn(name = "Gender_ID", insertable = true)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value=FetchMode.SUBSELECT)
    @OrderBy("type ASC")
    private Collection<Contact> contactSet;

    public Long getId() {
        return id;
     }

	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
     }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
     }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setContactSet(Collection<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Collection<Contact> getContactSet() {
        return contactSet;
    }
}
