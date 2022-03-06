package co.crisi.persistence.application.service;

import co.crisi.persistence.domain.Account;
import co.crisi.persistence.service.AddAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AddAccountService addAccountService;

    public boolean addAccount(Account account) {
        return addAccountService.add(account);
    }
}
