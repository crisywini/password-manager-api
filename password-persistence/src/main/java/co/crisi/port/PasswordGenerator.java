package co.crisi.port;

import org.springframework.stereotype.Component;

@Component
public interface PasswordGenerator {
    String generatePassword();
}
