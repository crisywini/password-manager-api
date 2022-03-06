package co.crisi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.crisi.application.service.AccountApplicationService;
import co.crisi.domain.Account;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/accounts"})
public class AccountController {

    private final AccountApplicationService accountApplicationService;

    @PostMapping
    public ResponseEntity<Boolean> addAccount(Account account) {
        boolean isAdded = accountApplicationService.add(account);
        return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
    }

}
