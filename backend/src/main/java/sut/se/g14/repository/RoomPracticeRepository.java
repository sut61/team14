package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.g14.entity.RoomPractice;

@RepositoryRestResource
public interface RoomPracticeRepository extends JpaRepository<RoomPractice,Long> {
    RoomPractice findById(long id);
}
