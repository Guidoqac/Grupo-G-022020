package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.aspects.AuditLogger;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("donations")
@CrossOrigin
public class DonationController {

    @Autowired
    private DonationService donationService;

    @AuditLogger
    @GetMapping(path = "/topTenDonations")
    public List<Donation> topTenDonations(){
        return donationService.getTopTenDonations();
    }

    @AuditLogger
    @PostMapping(path = "/donate")
    public void donate(@RequestBody Donation donation) {
        try{
            donationService.donate(donation);
        }catch (MissingDataException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }catch (NoSuchElementException | InvalidIdException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @AuditLogger
    @GetMapping(path = "/donationByUser/{id}")
    @ResponseBody
    public List<Donation> donatiosByUser(@PathVariable Integer id) {
        try{
            return donationService.findByIdUser(id);
        }catch (NoSuchElementException | InvalidIdException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    
    

}
