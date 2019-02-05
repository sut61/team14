package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g14.entity.Country;

@RepositoryRestResource

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String s);
}
