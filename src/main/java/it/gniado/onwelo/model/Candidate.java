package it.gniado.onwelo.model;

import java.util.Objects;

public class Candidate {

    private final Figure figure;

    private int votes;
    public Candidate(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote(){
        votes++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(figure, candidate.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figure);
    }
}
