package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User model) throws MissingDataException {
        this.validateUser(model);
        return this.userRepository.save(model);
    }

    @Transactional
    public User findById(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.userRepository.findById(id).get();
    }

    @Transactional
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) throws InvalidIdException {
        this.validateId(id);
        this.userRepository.deleteById(id);
    }

    @Transactional
    public User findByEmailAndPassword(String email, String password) throws MissingDataException {
        this.validateEmailAndPassword(email, password);
        return this.userRepository.findByEmailAndPassword(email, password).get();
    }

    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }

    private void validateUser(User user) throws MissingDataException {
        if(user.getName() == null ||
           user.getSurname() == null ||
           user.getNick() == null ||
           user.getPassword() == null ||
           user.getEmail() == null){
            throw new MissingDataException("Faltan datos del usuario");
        }
    }

    private void validateEmailAndPassword(String email, String password) throws MissingDataException {
        if(email == null || password == null){
            throw new MissingDataException("Faltan datos del usuario");
        }
    }

}
