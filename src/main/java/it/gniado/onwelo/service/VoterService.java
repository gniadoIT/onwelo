package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.CandidateRepository;
import it.gniado.onwelo.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VoterService(VoterRepository voterRepository, CandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    public List<Voter> getAllVoters(){
        return voterRepository.getAll();
    }

    public void addVoter(Voter voter){
        voterRepository.addVoter(voter);
    }

    public void addVote(int id){
        Candidate candidate = candidateRepository.getCandidateById(id);
        candidateRepository.vote(candidate);
    }

}
