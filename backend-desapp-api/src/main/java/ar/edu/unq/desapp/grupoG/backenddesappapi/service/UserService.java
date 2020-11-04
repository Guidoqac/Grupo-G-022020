package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.UserRepository;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
        return this.userRepository.save(user);
    }

    @Transactional
    public User findById(Integer id){
        return this.userRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.userRepository.deleteById(id);
    }

    @Transactional
    public User findByEmailAndPassword(String email, String password){
        return this.userRepository.findByEmailAndPassword(email, password).get();
    }

}
