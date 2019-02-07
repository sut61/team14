package sut.se.g14.repository;
import sut.se.g14.entity.Gender;
import sut.se.g14.entity.HireMoneyEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;

@RepositoryRestResource
public interface HireMoneyRepository extends JpaRepository<HireMoneyEntity,Long> {
    HireMoneyEntity findById(long id);
   
}
