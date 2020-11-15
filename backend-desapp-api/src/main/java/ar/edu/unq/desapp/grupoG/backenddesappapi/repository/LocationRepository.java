package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    Optional<Location> findById(Integer id);

    List<Location> findAll();

}