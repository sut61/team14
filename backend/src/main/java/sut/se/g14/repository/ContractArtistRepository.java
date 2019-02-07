package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import sut.se.g14.entity.ContractArtistEntity;
import sut.se.g14.entity.Country;

@RepositoryRestResource

public interface ContractArtistRepository extends JpaRepository<ContractArtistEntity, Long> {
    ContractArtistEntity findById(long s);
}
