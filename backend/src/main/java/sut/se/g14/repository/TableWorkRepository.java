package sut.se.g14.repository;
import sut.se.g14.entity.TableWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TableWorkRepository extends JpaRepository<TableWork, Long>{
    TableWork findByTableWorkId(Long tableWorkId);
}
