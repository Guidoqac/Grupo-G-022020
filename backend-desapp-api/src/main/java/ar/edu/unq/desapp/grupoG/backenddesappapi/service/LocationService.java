package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;
    
    @Transactional
    public Location save(Location model) {
        return this.repository.save(model);
    }

    @Transactional
    public Location findById(Integer id){
        return this.repository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.repository.deleteById(id);
    }

}
