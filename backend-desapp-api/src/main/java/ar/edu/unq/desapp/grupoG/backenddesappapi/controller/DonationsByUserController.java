package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.DonationsByUser;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationsByUserRepository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationsByUserService;

@RestController
@RequestMapping("donationByUser")
@EnableAutoConfiguration
@CrossOrigin
public class DonationsByUserController {

    @Autowired
    private DonationsByUserService donationsByUserService;
    
	@GetMapping(path = "/donationByUser/{id}")
	@ResponseBody
	public List<DonationsByUser> getDonationsByUserServiceByIdUser(@PathVariable Integer id) {
		System.out.println("holaaaa");
		return donationsByUserService.findByIdUser(id);
	}
	
}
