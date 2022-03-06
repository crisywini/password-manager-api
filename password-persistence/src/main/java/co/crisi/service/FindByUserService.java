package co.crisi.service;

import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FindByUserService {
    private final AccountRepository accountRepository;

    public Optional<Account> run(String userName) {
        return accountRepository.findByUser(userName);
    }
}
