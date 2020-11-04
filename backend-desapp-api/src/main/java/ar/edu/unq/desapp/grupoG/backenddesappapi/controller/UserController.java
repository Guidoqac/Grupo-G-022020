package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Mensaje;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

	@GetMapping(path = "/user/{id}")
	@ResponseBody
	public User getUserById(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
	@PostMapping(path = "/user")
	public void postUser(@RequestBody User user) {
        userService.save(user);
	}

	@DeleteMapping("/user/{id}")
	void deleteEmployee(@PathVariable Integer id) {
		userService.deleteById(id);
	}

	@PostMapping(path = "/login")
	@ResponseBody
	public User getUserByEmail(@RequestBody User user) {
		return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

}