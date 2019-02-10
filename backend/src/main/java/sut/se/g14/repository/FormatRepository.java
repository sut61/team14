package sut.se.g14.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g14.entity.Format;

import java.util.Optional;

@RepositoryRestResource
public interface FormatRepository extends JpaRepository<Format, Long> {
    Format findByFormatId(Long formatId);

}
