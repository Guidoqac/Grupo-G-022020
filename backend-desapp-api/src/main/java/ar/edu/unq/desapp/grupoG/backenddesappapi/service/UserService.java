package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User model) {
        return this.repository.save(model);
    }

    @Transactional
    public User findById(Integer id){
        return this.repository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.repository.deleteById(id);
    }

}
