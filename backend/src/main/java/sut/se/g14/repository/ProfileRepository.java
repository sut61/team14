package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g14.entity.Members;
import sut.se.g14.entity.Profile;

@RepositoryRestResource
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByMembers(Members members);

}

