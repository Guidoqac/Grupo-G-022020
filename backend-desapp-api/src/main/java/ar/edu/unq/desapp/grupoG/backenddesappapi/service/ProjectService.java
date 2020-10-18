package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Transactional
    public Project save(Project model) {
        return this.repository.save(model);
    }

    @Transactional
    public Project findById(Integer id){
        return this.repository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.repository.deleteById(id);
    }

}
