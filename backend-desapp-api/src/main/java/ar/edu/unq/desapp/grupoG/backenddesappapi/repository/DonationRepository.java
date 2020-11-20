package ar.edu.unq.desapp.grupoG.backenddesappapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;

@Configuration
@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer> {

    Optional<Donation> findById(Integer id);

    List<Donation> findAll();

    @Query(value = "SELECT * FROM DONATIONS d ORDER BY d.AMOUNT DESC LIMIT 0, 10", nativeQuery = true)
    List<Donation> findTopTenDonations();
	
}
