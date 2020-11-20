package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locations")
@CrossOrigin
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/topTenLocations")
    @ResponseBody
    public List<Location> getTopTenLocations(@PathVariable Integer id) {
        return locationService.findTopTenProjects();
    }
    
    @GetMapping(path = "/allLocations")
    @ResponseBody
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

}
