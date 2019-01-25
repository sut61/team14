package sut.se.g14.repository;

import sut.se.g14.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public 
interface DressRepository extends  JpaRepository<Dress, Long>{    
    Dress findById(long idDress);
    
}
