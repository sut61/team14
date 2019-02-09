package sut.se.g14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g14.entity.Country;
import sut.se.g14.entity.DateExpYear;

@RepositoryRestResource
public interface DateExpYearRepository extends JpaRepository<DateExpYear, Long> {
    DateExpYear findById(long dateExpY);
}
