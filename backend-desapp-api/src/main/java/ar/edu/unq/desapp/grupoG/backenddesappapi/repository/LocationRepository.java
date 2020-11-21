package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    Optional<Location> findById(Integer id);

    List<Location> findAll();

    @Query(value = "SELECT * FROM LOCATION l WHERE l.LAST_DONATION_DATE IS NOT NULL ORDER BY l.LAST_DONATION_DATE ASC LIMIT 0, 10", nativeQuery = true)
    List<Location> findTopTenLocations();
}