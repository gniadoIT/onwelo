package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {

    private List<Candidate> candidates = new ArrayList<>();

    public List<Candidate> getAll(){
        return candidates;
    }

    public void addCandidate(Candidate candidate){
        if (candidates.contains(candidate)){
            throw new IllegalArgumentException("Candidates must be unique");
        }
        candidates.add(candidate);
    }

    public void addCandidates(List<Candidate> candidates){
        this.candidates.addAll(candidates);
    }

    public void vote(Candidate candidate) {
        candidates.stream().filter(candidate::equals).findFirst().ifPresent(Candidate::addVote);
    }

    public Candidate getCandidateById(int id) {
        return candidates.get(id);
    }
}
