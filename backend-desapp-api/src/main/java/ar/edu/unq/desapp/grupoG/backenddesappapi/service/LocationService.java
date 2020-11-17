package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    
    @Transactional
    public Location save(Location model) {
        return this.locationRepository.save(model);
    }

    @Transactional
    public Location findById(Integer id){
        return this.locationRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.locationRepository.deleteById(id);
    }

    @Transactional
    public List<Location> findTopTenProjects() {
        return locationRepository.findTopTenLocations();
    }

}
