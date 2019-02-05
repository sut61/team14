package sut.se.g14.entity;
import lombok.*;
import javax.persistence.*;

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
    private @NonNull String name;
    private @NonNull String username;
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
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
