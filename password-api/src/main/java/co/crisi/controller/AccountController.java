package co.crisi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.crisi.application.service.AccountApplicationService;
import co.crisi.domain.Account;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/accounts"})
@Slf4j
public class AccountController {

    private final AccountApplicationService accountApplicationService;

    @PostMapping
    public ResponseEntity<Boolean> addAccount(@RequestBody Account account) {
        boolean isAdded = accountApplicationService.add(account);
        return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAccount(@RequestBody Account account){
        boolean idDeleted = accountApplicationService.delete(account);
        return new ResponseEntity<>(idDeleted, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteById(@RequestParam(name = "id") Long id){
        boolean isDeleted = accountApplicationService.deleteById(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }


    @DeleteMapping(path = "/{ids}")
    public ResponseEntity<HttpStatus> deleteAllById(@PathVariable List<Long> ids){
        accountApplicationService.deleteAllById(ids);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id){
        boolean exists = accountApplicationService.existsById(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }


}
