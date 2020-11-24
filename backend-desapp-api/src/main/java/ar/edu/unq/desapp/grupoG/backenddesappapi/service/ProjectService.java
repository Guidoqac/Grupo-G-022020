package ar.edu.unq.desapp.grupoG.backenddesappapi.service;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.exceptions.MissingDataException;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.DonationRepository;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.ProjectRepository;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSender emailSender;

    @Transactional
    public Project save(Project model) throws MissingDataException {
        if(model.getLocation() == null ||
           model.getFactor() < 0 ||
           model.getMinPercentProjectClosure() == null ||
           model.getProjectFantasyName() == null ||
           model.getCloseProjectDate() == null
           ){
            throw new MissingDataException("Faltan datos del proyecto.");
        }else{
            return this.projectRepository.save(model);
        }
    }

    @Transactional
    public Project findById(Integer id) throws InvalidIdException {
        this.validateId(id);
        return this.projectRepository.findById(id).get();
    }

    @Transactional
    public Page<Project> findAll(Pageable page){
        return this.projectRepository.findAll(page);
    }

    @Transactional
    public void deleteById(Integer id) throws InvalidIdException {
        this.validateId(id);
        this.projectRepository.deleteById(id);
    }

    @Transactional
    public Page<Project> findProjectsCloseToFinish(Pageable page){
        return this.projectRepository.findProjectsCloseToFinish(page, LocalDate.now().getMonth().getValue(), LocalDate.now().getYear());
    }

    @Transactional
    public Page<Project> findOpenProjects(Pageable page){
        return this.projectRepository.findOpenProyects(page);
    }

    @Transactional
    public void closeProject(int id) throws MessagingException, InvalidIdException {
        this.validateId(id);
        Project project = this.findById(id);
        project.closeProject();

        List<Integer> userIds = donationRepository.findByIdProject(id).stream().map(d -> d.getIdUser()).collect(Collectors.toList());
        HashSet<Integer> sinDuplicados = new HashSet<>(userIds);
        List<Integer> lsUserIds = new ArrayList<>(sinDuplicados);
        String[] mails = lsUserIds.stream().map(uId -> userRepository.findById(uId).get().getEmail()).collect(Collectors.toList()).toArray(new String[0]);

        if(mails.length > 0){
            emailSender.sendMessageToFinishedProject(project.getProjectFantasyName(), mails);
        }
    }

    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }
}
