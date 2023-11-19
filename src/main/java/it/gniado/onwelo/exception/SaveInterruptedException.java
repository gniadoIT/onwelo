package it.gniado.onwelo.exception;

public class SaveInterruptedException extends RuntimeException {

    private final String message;
    private final Sort sort;
    public SaveInterruptedException(String s, Sort sort) {
        super(s);
        this.message = s;
        this.sort = sort;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Sort getSort() {
        return sort;
    }

    public enum Sort {
        VOTER, CANDIDATE;
    }
}
