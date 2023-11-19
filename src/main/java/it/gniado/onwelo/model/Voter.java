package it.gniado.onwelo.model;

import java.util.Objects;

public class Voter {

    private final Figure figure;

    private boolean hasVoted;

    public Voter(Figure figure) {
        this.figure = figure;
    }
    public Figure getFigure() {
        return figure;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return Objects.equals(figure, voter.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figure);
    }
}
