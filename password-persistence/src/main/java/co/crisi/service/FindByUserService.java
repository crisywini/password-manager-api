package co.crisi.service;

import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByUserService {
    private final AccountRepository accountRepository;

    public List<Account> run(String userName) {
        return accountRepository.findByUser(userName);
    }
}
