package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/project/{id}")
    @ResponseBody
    public Project getProjectById(@PathVariable Integer id) {
        return projectService.findById(id);
    }

    @PostMapping(path = "/project")
    public void postUser(@RequestBody Project project) {
        projectService.save(project);
    }

    @DeleteMapping("/project/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        projectService.deleteById(id);
    }

}