package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("donations")
@CrossOrigin
public class DonationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DonationService donationService;

    @GetMapping(path = "/topTenDonations")
    public List<Donation> topTenDonations(){
        return donationService.getTopTenDonations();
    }

    @PostMapping(path = "/donate")
    public void donate(@RequestBody Donation donation) throws Exception {
        donationService.donate(donation);
    }

}
