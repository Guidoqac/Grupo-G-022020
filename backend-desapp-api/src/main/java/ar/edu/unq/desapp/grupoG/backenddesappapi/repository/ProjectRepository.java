package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{

    Optional<Project> findById(Integer id);

    List<Project> findAll();

    @Query(value = "SELECT * FROM PROJECT p LIMIT :fromRow, :toRow", nativeQuery = true)
    List<Project> findProjectsFromTo(@Param("fromRow") Integer from, @Param("toRow") Integer to);

    @Query(value = "SELECT * FROM PROJECT p WHERE MONTH(p.CLOSE_PROJECT_DATE) = :month", nativeQuery = true)
    List<Project> findProjectsCloseToFinish(@Param("month") Integer mon);

}