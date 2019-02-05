package sut.se.g14.repository;
import sut.se.g14.entity.Place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByPlaceId(Long placeId);
}
