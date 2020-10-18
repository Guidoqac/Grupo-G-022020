package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Reward;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface RewardRepository extends CrudRepository<Reward, Integer>{

    Optional<Reward> findById(Integer id);

    List<Reward> findAll();

}
