package it.gniado.onwelo.model;

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
}
