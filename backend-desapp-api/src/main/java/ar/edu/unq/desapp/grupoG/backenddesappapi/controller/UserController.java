package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
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

}