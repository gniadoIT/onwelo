package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Voter;

import java.util.ArrayList;
import java.util.List;

public class VoterRepository {

    private List<Voter> voters = new ArrayList<>();

    public List<Voter> getAll(){
        return voters;
    }

    public void addVoter(Voter voter){
        if (voters.contains(voter)) {
            throw new IllegalArgumentException("Voters must be unique");
        }
        voters.add(voter);
    }

    public void addVoters(List<Voter> voters){
        this.voters.addAll(voters);
    }

    public Voter getById(int id){
        return voters.get(id);
    }

    public void vote(int id) {
        voters.get(id).setHasVoted(true);
    }
}
