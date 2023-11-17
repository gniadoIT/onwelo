package it.gniado.onwelo.service;

import it.gniado.onwelo.model.Candidate;
import it.gniado.onwelo.model.Figure;
import it.gniado.onwelo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate addCandidate(String candidateName){
        Candidate candidate = new Candidate(new Figure(candidateName));
        candidateRepository.addCandidate(candidate);
        return candidate;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.getAll();
    }

}
