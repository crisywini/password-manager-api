package co.crisi.persistence.application.service;

import co.crisi.persistence.domain.Account;
import co.crisi.persistence.service.AddAccountService;
import co.crisi.persistence.service.DeleteAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AddAccountService addAccountService;
    private final DeleteAccountService deleteAccountService;

    public boolean add(Account account) {
        return addAccountService.run(account);
    }

    public boolean delete(Account account){
        return deleteAccountService.run(account);
    }

}
