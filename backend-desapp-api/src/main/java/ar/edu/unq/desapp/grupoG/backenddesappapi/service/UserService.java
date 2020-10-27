package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User model) {
        return this.userRepository.save(model);
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
