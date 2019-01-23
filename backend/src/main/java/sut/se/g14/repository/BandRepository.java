package com.example.demo.Repository;

import com.example.demo.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BandRepository extends JpaRepository <Band,Long>{
    Band findById(long BandID);
    Band findByBandname(String bandname);
}
