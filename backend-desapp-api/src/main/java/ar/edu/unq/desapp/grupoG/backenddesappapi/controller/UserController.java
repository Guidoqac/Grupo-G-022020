package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping(path = "/user")
	@ResponseBody
	public User getAnyUser() {
		return new User(0, "Roque", "Pistone", "Rocky", "a1a2a3", "roco2020@gmail.com");
	}

	
	@GetMapping(path = "/user2")
	@ResponseBody
	public User getAnyUser2() {
		return new User(0, "Maven", "Pistone", "Rocky", "a1a2a3", "roco2020@gmail.com");
	}

}
