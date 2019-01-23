package com.example.demo.Repository;
import com.example.demo.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TypeMusicRepository extends JpaRepository <TypeMusic,Long>{
    TypeMusic findById(long TypeMusicID);
    TypeMusic findByTypemusics(String typemusics);
}
