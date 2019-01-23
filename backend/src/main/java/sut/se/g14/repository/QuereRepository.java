package sut.se.g14.repository;
import sut.se.g14.entity.Quere;
import sut.se.g14.entity.Members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuereRepository extends JpaRepository <Quere, Long> {
        Quere findById(long quereId);
        //Quere findByMembersQuere(Members membersQuere);
        }
