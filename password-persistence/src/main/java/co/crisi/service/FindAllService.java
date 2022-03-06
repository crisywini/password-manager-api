package co.crisi.service;

import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllService {
    private final AccountRepository accountRepository;

    public List<Account> run(){
        return accountRepository.findAll();
    }

}
