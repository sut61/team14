package sut.se.g14.repository;
import sut.se.g14.entity.TypeWork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeWorkRepository extends JpaRepository<TypeWork, Long> {
    TypeWork findByTypeworkId(Long typeworkId);
}
