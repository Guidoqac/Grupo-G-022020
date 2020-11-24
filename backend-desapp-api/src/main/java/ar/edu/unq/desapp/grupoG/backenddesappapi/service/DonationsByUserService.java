package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationsByUserRepository;

import javax.persistence.Column;

@Service
public class DonationsByUserService {

    @Autowired
    private DonationsByUserRepository donationByUserRepository;
    
    @Transactional
    public List<DonationsByUser> findByIdUser(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.donationByUserRepository.findByIdUser(id);
    }
    
    @Transactional
    public DonationsByUser save(DonationsByUser model) throws MissingDataException {
        this.validateDonationByUse(model);
        return this.donationByUserRepository.save(model);
    }

    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }

    private void validateDonationByUse(DonationsByUser donations) throws MissingDataException {
        if(donations.getIdUser() == null ||
           donations.getNameProject() == null ||
           donations.getAmount() < 0 ||
           donations.getDonationDate() == null ||
           donations.getPoints() < 0){
            throw new MissingDataException("Faltan datos de la donacion del usuario.");
        }
    }
    @Column
    private Integer idUser;

    @Column
    private String nameProject;

    @Column
    private double amount;

    @Column
    private LocalDate donationDate;

    @Column
    private int points;

}
