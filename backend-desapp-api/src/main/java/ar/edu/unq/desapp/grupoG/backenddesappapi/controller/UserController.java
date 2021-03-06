package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.aspects.AuditLogger;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

	@AuditLogger
	@GetMapping(path = "/user/{id}")
	@ResponseBody
	public User getUserById(@PathVariable Integer id) {
		try{
			return userService.findById(id);
		}catch(NoSuchElementException | InvalidIdException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@AuditLogger
	@PostMapping(path = "/user")
	public void postUser(@RequestBody User user) {
		try{
			userService.save(user);
		}catch (MissingDataException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@AuditLogger
	@DeleteMapping("/user/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		try{
			userService.deleteById(id);
		}catch (NoSuchElementException | InvalidIdException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@AuditLogger
	@PostMapping(path = "/login")
	@ResponseBody
	public User getUserByEmail(@RequestBody User user) {
		try {
			return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		}catch (MissingDataException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

}