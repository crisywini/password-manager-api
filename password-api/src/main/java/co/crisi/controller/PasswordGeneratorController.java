package co.crisi.controller;

import co.crisi.application.service.PasswordGeneratorApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/passwords")
@RequiredArgsConstructor
public class PasswordGeneratorController {
    private final PasswordGeneratorApplicationService passwordGeneratorApplicationService;

    @GetMapping
    public ResponseEntity<String> generatePassword(){
        return new ResponseEntity<>(passwordGeneratorApplicationService.generatePassword(), HttpStatus.OK);
    }
}
