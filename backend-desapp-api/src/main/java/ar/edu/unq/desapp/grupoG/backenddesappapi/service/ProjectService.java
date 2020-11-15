package ar.edu.unq.desapp.grupoG.backenddesappapi.service;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.ProjectRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Project> findAll(Pageable page){
        return this.projectRepository.findAll(page);
    }

    @Transactional
    public void deleteById(Integer id){
        this.projectRepository.deleteById(id);
    }

    @Transactional
    public Page<Project> findProjectsCloseToFinish(Pageable page){
        return this.projectRepository.findProjectsCloseToFinish(page, LocalDate.now().getMonth().getValue());
    }

    @Transactional
    public Page<Project> findOpenProjects(Pageable page){
        return this.projectRepository.findOpenProyects(page);
    }
}
