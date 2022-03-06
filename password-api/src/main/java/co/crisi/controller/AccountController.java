package co.crisi.controller;

import co.crisi.domain.AccountType;
import co.crisi.mapper.AccountMapper;
import co.crisi.model.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.crisi.application.service.AccountApplicationService;
import co.crisi.domain.Account;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/accounts"})
@Slf4j
public class AccountController {

    private final AccountApplicationService accountApplicationService;
    private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @PostMapping
    public ResponseEntity<Boolean> addAccount(@RequestBody Account account) {
        boolean isAdded = accountApplicationService.add(account);
        return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAccount(@RequestBody Account account) {
        boolean idDeleted = accountApplicationService.delete(account);
        return new ResponseEntity<>(idDeleted, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(name = "id") Long id) {
        boolean isDeleted = accountApplicationService.deleteById(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }


    @DeleteMapping(path = "/{ids}")
    public ResponseEntity<HttpStatus> deleteAllById(@PathVariable List<Long> ids) {
        accountApplicationService.deleteAllById(ids);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = accountApplicationService.existsById(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAll() {
        List<AccountDto> accounts = accountApplicationService.findAll().stream()
                .map(accountMapper::accountToAccountDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(path = "/byUser/{userName}")
    public ResponseEntity<List<AccountDto>> findByUserName(@PathVariable String userName) {
        List<AccountDto> accounts = accountApplicationService.findByUserName(userName).stream()
                .map(accountMapper::accountToAccountDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(path = "/byType/{type}")
    public ResponseEntity<List<AccountDto>> findByType(@PathVariable(name = "type") String accountType) {
        List<AccountDto> accounts = accountApplicationService.findByType(AccountType.of(accountType)).stream()
                .map(accountMapper::accountToAccountDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
