package sut.se.g14.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Status {
    @Id
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq")
    @Column(name="Status_ID")
    private @NonNull Long statusId;
    private @NonNull String statusQuere;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusQuere() {
        return statusQuere;
    }

    public void setStatusQuere(String statusQuere) {
        this.statusQuere = statusQuere;
    }


}
