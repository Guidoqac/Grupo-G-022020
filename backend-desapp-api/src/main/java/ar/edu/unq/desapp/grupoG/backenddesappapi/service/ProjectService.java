package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
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
    public Project save(Project model) throws Exception {
        if(model.getLocation() != null){
            return this.projectRepository.save(model);
        }else{
            throw new MissingDataException("Faltan datos del proyecto.");
        }
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

    @Transactional
    public List<Project> findProjectsFromTo(Integer from, Integer to){
        return this.projectRepository.findProjectsFromTo(from, to);
    }

    @Transactional
    public List<Project> findProjectsCloseToFinish(Integer month){
        return this.projectRepository.findProjectsCloseToFinish(month);
    }

}
