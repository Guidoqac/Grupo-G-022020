package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationRepository;

import java.util.List;

@Service
public class DonationService {
	
    @Autowired
    private DonationRepository repository;

    @Transactional
    public Donation save(Donation model) {
        return this.repository.save(model);
    }

    @Transactional
    public Donation findById(Integer id){
        return this.repository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.repository.deleteById(id);
    }

    @Transactional
    public List<Donation> getTopTenDonations(){
        return this.repository.findTopTenDonations();
    }

}
