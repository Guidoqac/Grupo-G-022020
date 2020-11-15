package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.jwt.JwtDto;
import ar.edu.unq.desapp.grupoG.backenddesappapi.jwt.JwtProvider;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Mensaje;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JwtProvider jwtProvider;

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

//	@PostMapping(path = "/loginnnnnnNNNNNNNN")
//	@ResponseBody
//	public User getUserByEmail(@RequestBody User user) {
//		return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
//	}
//	
	@PostMapping(path = "/nada")
	@ResponseBody
	public ResponseEntity<?> getUserByEmail(@RequestBody User user) {
        return new ResponseEntity(new Mensaje("nadaaa"), HttpStatus.CREATED);
//		return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
    	System.out.println("registerUser");
        userService.save(user);
    	System.out.println("registerUser");

        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}
	
    @PostMapping(path = "/login")
    public ResponseEntity<JwtDto> login(@RequestBody User user){
    	
    	System.out.println(user.getName());
    	System.out.println(user.getPassword());
    	System.out.println("holaaaaa");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
    	System.out.println("holaaaaa");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
//        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

}