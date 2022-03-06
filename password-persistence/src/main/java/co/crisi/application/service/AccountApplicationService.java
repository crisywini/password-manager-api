package co.crisi.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import co.crisi.domain.Account;
import co.crisi.service.AddAccountService;
import co.crisi.service.DeleteAccountByIdService;
import co.crisi.service.DeleteAccountService;

@Component
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AddAccountService addAccountService;
    private final DeleteAccountService deleteAccountService;
    private final DeleteAccountByIdService deleteAccountByIdService;

    public boolean add(Account account) {
        return addAccountService.run(account);
    }

    public boolean delete(Account account) {
        return deleteAccountService.run(account);
    }

    public boolean deleteById(Long id) {
        return deleteAccountByIdService.run(id);
    }
}
