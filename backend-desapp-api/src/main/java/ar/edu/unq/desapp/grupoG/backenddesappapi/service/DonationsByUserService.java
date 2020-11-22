package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationsByUserRepository;

@Service
public class DonationsByUserService {

    @Autowired
    private DonationsByUserRepository donationByUserRepository;
    
    @Transactional
    public List<DonationsByUser> findByIdUser(Integer id){
        return this.donationByUserRepository.findByIdUser(id);
    }
    
    @Transactional
    public DonationsByUser save(DonationsByUser model) {
        return this.donationByUserRepository.save(model);
    }
	
}
