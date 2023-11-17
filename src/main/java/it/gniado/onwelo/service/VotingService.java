package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Voter;
import it.gniado.onwelo.repository.CandidateRepository;
import it.gniado.onwelo.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    public final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VotingService(VoterRepository voterRepository, CandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    public void addVote(int voterId, int candidateId){
        Candidate candidate = candidateRepository.getCandidateById(candidateId);
        candidateRepository.vote(candidate);

        voterRepository.vote(voterId);
    }

}
