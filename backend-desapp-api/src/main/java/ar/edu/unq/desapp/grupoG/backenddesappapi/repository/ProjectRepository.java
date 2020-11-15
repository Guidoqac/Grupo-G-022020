package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Configuration
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Optional<Project> findById(Integer id);


    @Query(value = "SELECT * FROM PROJECT p WHERE NOT p.IS_CLOSED", nativeQuery = true)
    Page<Project> findOpenProyects(Pageable page);


    @Query(value = "SELECT * FROM PROJECT p WHERE MONTH(p.CLOSE_PROJECT_DATE) = :month", nativeQuery = true)
    Page<Project> findProjectsCloseToFinish(Pageable page, @Param("month") Integer mon);
}