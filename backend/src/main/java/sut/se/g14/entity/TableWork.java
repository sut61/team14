package sut.se.g14.entity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableWork {

        @Id
        @SequenceGenerator(name = "tableWork_seq", sequenceName = "tableWork_seq")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tableWork_seq")
        @Column(name = "tableWork_ID")
        private @NonNull long tableWorkId;

        @NotNull
        @Pattern(regexp = "[a-zA-Z!%&]*")
        @Size(min=10)
        private @NonNull String invite;

        @Positive
        private  @NonNull Long price;

        @NotNull
        private @NonNull String tag;

        @OneToOne
        private Quere tableWorkQuere;

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Manager.class)
        @JoinColumn(name = "MV_ID", insertable = true)
        private Manager managerWork;

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Old.class)
        @JoinColumn(name = "OLD_ID", insertable = true)
        private Old oldWork;

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Format.class)
        @JoinColumn(name = "FM_ID", insertable = true)
        private Format  formatWork;

        public long getTableWorkId() {
                return tableWorkId;
        }

        public String getInvite() {
                return invite;
        }

        public void setInvite(String invite) {
                this.invite = invite;
        }


        public String getTag() {
                return tag;
        }

        public void setTag(String tag) {
                this.tag = tag;
        }


        public Quere getTableWorkQuere() {
                return tableWorkQuere;
        }

        public void setTableWorkQuere(Quere tableWorkQuere) {
                this.tableWorkQuere = tableWorkQuere;
        }

        public Manager getManagerWork() {
                return managerWork;
        }

        public void setManagerWork(Manager managerWork) {
                this.managerWork = managerWork;
        }

        public Long getPrice() {
                return price;
        }

        public void setPrice(Long price) {
                this.price = price;
        }

        public Old getOldWork() {
                return oldWork;
        }

        public void setOldWork(Old oldWork) {
                this.oldWork = oldWork;
        }


        public Format getFormatWork() {
                return formatWork;
        }

        public void setFormatWork(Format formatWork) {
                this.formatWork = formatWork;
        }




}
