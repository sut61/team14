package sut.se.g14.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Members {
    @Id
    @Column(name = "MEMBERS_USER")
    private @NonNull String memUser;
    private @NonNull String memPassword;

    public Collection<Quere> getQuereSet() {
        return quereSet;
    }

    public void setQuereSet(Collection<Quere> quereSet) {
        this.quereSet = quereSet;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OrderBy("id Desc")
    private Collection<Quere> quereSet;

    public Members(){}

    public Members(String memUser, String memPassword ) {
        this.memUser = memUser;
        this.memPassword = memPassword;
    }

    public String getMemUser() {
        return memUser;
    }

    public void setMemUser(String memUser) {
        this.memUser = memUser;
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword;
    }
}

