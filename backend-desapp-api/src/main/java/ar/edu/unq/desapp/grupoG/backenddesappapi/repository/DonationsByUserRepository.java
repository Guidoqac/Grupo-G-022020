package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;

@Configuration
@Repository
public interface DonationsByUserRepository extends CrudRepository<DonationsByUser, Integer> {
	
	List<DonationsByUser> findByIdUser(Integer id);

}
