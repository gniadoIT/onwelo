package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Voter;

import java.util.List;

public class VoterRepository {

    private List<Voter> voters = List.of();

    public List<Voter> getAll(){
        return voters;
    }

    public void addVoter(Voter voter){
        voters.add(voter);
    }

    public void addVoters(List<Voter> voters){
        this.voters.addAll(voters);
    }

    public void vote(int id) {
        voters.get(id);
    }
}
