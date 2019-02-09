package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.g14.entity.TypePractice;

@RepositoryRestResource
public interface TypePracticeRepository extends JpaRepository<TypePractice,Long> {
    TypePractice findById(long id);
}
