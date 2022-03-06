package co.crisi.persistence.service;

import co.crisi.persistence.domain.Account;
import co.crisi.persistence.exception.DomainException;
import co.crisi.persistence.port.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAccountService {
    private final AccountRepository accountRepository;
    private static final String NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE = "The account with id %s does not exists!";

    public boolean run(Account account) {
        validateExistingAccount(account);
        return accountRepository.delete(account);
    }

    private void validateExistingAccount(@NonNull Account account) {
        if (accountRepository.getById(account.getId()).isEmpty()) {
            throw new DomainException(String.format(NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE, account.getId() + ""));
        }
    }
}
