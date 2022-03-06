package co.crisi.persistence.exception;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
}
