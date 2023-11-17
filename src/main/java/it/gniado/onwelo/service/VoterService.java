package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter addVoter(String voterName){
        return null;
    }

    public List<Voter> getAllVoters(){
        return voterRepository.getAll();
    }
}