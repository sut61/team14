package sut.se.g14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g14.entity.IDCard;
import sut.se.g14.entity.Profile;

@RepositoryRestResource
public interface IDCardRepository extends JpaRepository<IDCard, Long>{
    IDCard findByProfile(Profile profile);
}

