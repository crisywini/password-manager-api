package co.crisi.application.service;

import co.crisi.service.GeneratePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordGeneratorApplicationService {
    private final GeneratePasswordService generatePasswordService;

    public String generatePassword(){
        return generatePasswordService.run();
    }

}
