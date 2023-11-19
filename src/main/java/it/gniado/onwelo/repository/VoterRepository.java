package it.gniado.onwelo.repository;

import it.gniado.onwelo.model.Voter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VoterRepository {

    private List<Voter> voters = new ArrayList<>();

    public List<Voter> getAll(){
        return voters;
    }

    public void addVoter(Voter voter){
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

    public List<Voter> getAvailable() {
        return voters.stream().filter(v->!v.isHasVoted()).collect(Collectors.toList());
    }
}
