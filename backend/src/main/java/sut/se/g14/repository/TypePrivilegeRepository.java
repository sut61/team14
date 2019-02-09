package sut.se.g14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.g14.entity.TypePrivilege;

@RepositoryRestResource
public interface TypePrivilegeRepository extends JpaRepository<TypePrivilege, Long> {
    TypePrivilege findById(long idPrivilege);
}
