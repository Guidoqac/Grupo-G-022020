package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{

    Optional<Project> findById(Integer id);

    List<Project> findAll();

}