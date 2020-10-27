package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/project/{id}")
    @ResponseBody
    public Project getProjectById(@PathVariable Integer id) {
        return projectService.findById(id);
    }
    
    @GetMapping(path = "/allProjects/")
    @ResponseBody
    public List<Project> getProjectById() {
        return projectService.findAll();
    }

    @PostMapping(path = "/project")
    public void postUser(@RequestBody Project project) {
        projectService.save(project);
    }

    @DeleteMapping("/project/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        projectService.deleteById(id);
    }

}