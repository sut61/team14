package sut.se.g14.repository;

import sut.se.g14.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BandRepository extends JpaRepository <Band,Long>{
    Band findById(long BandID);
    Band findByBandname(String bandname);
}
