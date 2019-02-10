package sut.se.g14.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Format {
    @Id
    @SequenceGenerator(name="format_seq",sequenceName="format_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="format_seq")
    @Column(name="Format_ID")
    private @NonNull Long formatId;


    @NotNull
    private @NonNull String format;


    public Long getFormatId() {
        return formatId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
