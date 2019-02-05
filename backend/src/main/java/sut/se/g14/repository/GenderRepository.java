package sut.se.g14.repository;
import sut.se.g14.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;

@RepositoryRestResource
public interface GenderRepository extends JpaRepository<Gender,Long> {
    Gender findById(long id);
    Gender findByGender(String id);
}
