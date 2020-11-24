package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
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
    public Location save(Location model) throws MissingDataException {
        this.validateLocation(model);
        return this.locationRepository.save(model);
    }

    @Transactional
    public Location findById(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.locationRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id) throws InvalidIdException {
        this.validateId(id);
        this.locationRepository.deleteById(id);
    }

    @Transactional
    public List<Location> findTopTenLocations() {
        return locationRepository.findTopTenLocations();
    }

    @Transactional
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }

    private void validateLocation(Location location) throws MissingDataException {
        if(location.getName() == null ||
           location.getProvince() == null ||
           location.getPopulation() < 0 ||
           location.getStatus() == null
        ){
            throw new MissingDataException("Faltan datos de la localidad.");
        }
    }

}
