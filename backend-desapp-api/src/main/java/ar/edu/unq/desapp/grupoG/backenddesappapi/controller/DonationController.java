package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@RestController
@RequestMapping("donations")
@CrossOrigin
public class DonationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/donate")
    public void donate(@RequestBody Donation donation){
        User userFound = userService.findById(donation.getIdUser());
        Project projectFound = projectService.findById(donation.getIdProject());

        int pointsUser = this.calculatePoints(userFound, donation, projectFound);

        projectFound.addDonation(donation);
        projectFound.setLastDonationDate(LocalDate.now());
        userFound.setPoints(pointsUser);

        userService.save(userFound);
        projectService.save(projectFound);
    }

    private int calculatePoints(User userFound, Donation donation, Project projectFound){
        int pointsUser = userFound.getPoints();

        // Si colabora en 1 proyecto con más de 1000 pesos, obtendrá la misma cantidad de puntos que pesos invertidos.
        if (donation.getAmount() >= 1000.0 && (projectFound.getLocation().getPopulation() >= 2000) && projectFound.alreadyDonate(donation.getIdUser()) ) {
            pointsUser = (int) (pointsUser + donation.getAmount()) + 500;
        } else if (donation.getAmount() >= 1000.0 && (projectFound.getLocation().getPopulation() >= 2000)) {
            pointsUser = (int) (pointsUser + donation.getAmount());
        }

        //Si colabora en 1 proyecto de una localidad de menos de 2000 habitantes, la cantidad de puntos será el doble de los pesos invertidos.
        if ((projectFound.getLocation().getPopulation() < 2000) && projectFound.alreadyDonate(donation.getIdUser())) {
            pointsUser = (int) ((pointsUser + donation.getAmount()) * 2 + 500);

        } else if (projectFound.getLocation().getPopulation() < 2000) {
            pointsUser = (int) ((pointsUser + donation.getAmount()) * 2);
        }

        if ((projectFound.getLocation().getPopulation() >= 2000) && donation.getAmount() < 1000.0 && projectFound.alreadyDonate(donation.getIdUser())) {
            pointsUser = 100 + 500;

        } else if ((projectFound.getLocation().getPopulation() >= 2000) && donation.getAmount() < 1000.0) {
            pointsUser = 100;
        }

        return pointsUser;
    }

}
