package sut.se.g14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.g14.entity.*;

@RepositoryRestResource
public interface PrivilegeVIPRepository extends JpaRepository<PrivilegeVIP,Long> {
    PrivilegeVIP findByProfile(Profile profile);
}
