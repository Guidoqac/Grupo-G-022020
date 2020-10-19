package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Reward;
import ar.edu.unq.desapp.grupoG.backenddesappapi.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    @Transactional
    public Reward save(Reward model) {
        return this.rewardRepository.save(model);
    }

    @Transactional
    public Reward findById(Integer id){
        return this.rewardRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id){
        this.rewardRepository.deleteById(id);
    }

}
