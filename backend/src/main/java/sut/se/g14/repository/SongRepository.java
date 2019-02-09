package sut.se.g14.repository;
import sut.se.g14.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface SongRepository extends JpaRepository <Song,Long>{
    Song findById (long songID);
    Song findByName (String name);
}
