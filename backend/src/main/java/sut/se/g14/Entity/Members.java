package sut.se.g14.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Members {
    @Id
    @Column(name = "MEMBERS_USER")
    private @NonNull String memUser;
    private @NonNull String memPass;

    public Members(String memUser, String memPass ) {
        this.memUser = memUser;
        this.memPass = memPass;
    }
}
