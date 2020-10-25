package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.ProjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Project save(Project model) {
        return this.projectRepository.save(model);
    }

    @Transactional
    public Project findById(Integer id){
        return this.projectRepository.findById(id).get();
    }
    
    @Transactional
    public List<Project> findAll(){
        return this.projectRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id){
        this.projectRepository.deleteById(id);
    }

}
