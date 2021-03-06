package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.unq.desapp.grupoG.backenddesappapi.aspects.AuditLogger;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationsByUserRepository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationsByUserService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("donationByUser")
@EnableAutoConfiguration
@CrossOrigin
public class DonationsByUserController {

    @Autowired
    private DonationsByUserService donationsByUserService;

	@AuditLogger
	@GetMapping(path = "/donations/{id}")
	@ResponseBody
	public List<DonationsByUser> getDonationsByUserServiceByIdUser(@PathVariable Integer id) {
		try{
			return donationsByUserService.findByIdUser(id);
		}catch (NoSuchElementException | InvalidIdException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
	
}
