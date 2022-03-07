package co.crisi.service;

import co.crisi.port.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratePasswordService {
    private final PasswordGenerator passwordGenerator;

    public String run(){
        return passwordGenerator.generatePassword();
    }
}
