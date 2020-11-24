package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationRepository;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LocationService locationService;
    
    @Autowired
    private DonationsByUserService donationsByUserService;

    @Transactional
    public Donation save(Donation model) {
        return this.repository.save(model);
    }

    @Transactional
    public Donation findById(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.repository.findById(id).get();
    }

    @Transactional
    public List<Donation> findByIdUser(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.repository.findByIdUser(id);
    }

    
    @Transactional
    public void deleteById(Integer id) throws InvalidIdException {
        this.validateId(id);
        this.repository.deleteById(id);
    }

    @Transactional
    public List<Donation> getTopTenDonations(){
        return this.repository.findTopTenDonations();
    }

    @Transactional
    public void donate(Donation donation) throws MissingDataException, InvalidIdException {
        this.validateDonation(donation);

        User userFound = userService.findById(donation.getIdUser());
        Project projectFound = projectService.findById(donation.getIdProject());
        Location locationByProjectFound = locationService.findById(projectFound.getLocation().getId());

        projectFound.addDonation(donation);
        locationByProjectFound.setLastDonationDate((LocalDate.now()));

        int pointsUser = this.calculatePoints(userFound, donation, projectFound);

        userFound.setPoints(pointsUser);

        userService.save(userFound);
        projectService.save(projectFound);
        locationService.save((locationByProjectFound));
        
        DonationsByUser donationByUser = new DonationsByUser(userFound.getIdUser(), projectFound.getProjectFantasyName(), donation.getAmount() ,LocalDate.now(), pointsUser );
        donationsByUserService.save(donationByUser);
    }

    private int calculatePoints(User userFound, Donation donation, Project projectFound){
        int pointsUser = userFound.getPoints();

        // Si colabora en 1 proyecto con más de 1000 pesos, obtendrá la misma cantidad de puntos que pesos invertidos.
        if (donation.getAmount() >= 1000.0 && (projectFound.getLocation().getPopulation() >= 2000) && projectFound.alreadyDonateInAnyMonth(donation.getIdUser()) ) {
            pointsUser = (int) (pointsUser + donation.getAmount()) + 500;
        } else if (donation.getAmount() >= 1000.0 && (projectFound.getLocation().getPopulation() >= 2000)) {
            pointsUser = (int) (pointsUser + donation.getAmount());
        }

        //Si colabora en 1 proyecto de una localidad de menos de 2000 habitantes, la cantidad de puntos será el doble de los pesos invertidos.
        if ((projectFound.getLocation().getPopulation() < 2000) && projectFound.alreadyDonateInAnyMonth(donation.getIdUser())) {
            pointsUser = (int) ((pointsUser + donation.getAmount()) * 2 + 500);

        } else if (projectFound.getLocation().getPopulation() < 2000) {
            pointsUser = (int) ((pointsUser + donation.getAmount()) * 2);
        }

        if ((projectFound.getLocation().getPopulation() >= 2000) && donation.getAmount() < 1000.0 && projectFound.alreadyDonateInAnyMonth(donation.getIdUser())) {
            pointsUser = 100 + 500;

        } else if ((projectFound.getLocation().getPopulation() >= 2000) && donation.getAmount() < 1000.0) {
            pointsUser = 100;
        }

        return pointsUser;
    }

    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }

    private void validateDonation(Donation donation) throws MissingDataException {
        if(donation.getIdUser() == null ||
           donation.getIdProject() == null ||
           donation.getAmount() < 0 ||
           donation.getComment() == null){
            throw new MissingDataException("Faltan datos de la donacion.");
        }
    }

}

