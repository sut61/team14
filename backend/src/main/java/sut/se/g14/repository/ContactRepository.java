package sut.se.g14.repository;
import sut.se.g14.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
