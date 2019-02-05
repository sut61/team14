package sut.se.g14.repository;
import sut.se.g14.entity.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StatusRepository extends JpaRepository<Status, Long> {
        Status findByStatusId(Long statusId);
        }
