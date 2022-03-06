package co.crisi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.crisi.domain.Account;
import co.crisi.exception.DomainException;
import co.crisi.port.AccountRepository;

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
        if (accountRepository.existsById(account.getId())) {
            throw new DomainException(String.format(NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE, account.getId() + ""));
        }
    }
}
