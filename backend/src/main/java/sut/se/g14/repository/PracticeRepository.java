package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.g14.entity.Practice;

@RepositoryRestResource
public interface PracticeRepository extends JpaRepository<Practice,Long> {
}
