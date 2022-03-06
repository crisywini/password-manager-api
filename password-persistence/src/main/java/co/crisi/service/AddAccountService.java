package co.crisi.service;

import co.crisi.exception.DomainException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;


@Service
@RequiredArgsConstructor
public class AddAccountService {
    private final AccountRepository accountRepository;
    private static final String EXISTING_ACCOUNT_MESSAGE_TEMPLATE = "The account with name %s already exists";

    public boolean run(Account account) {
        validateNonExistenceAccount(account);
        return accountRepository.save(account);
    }

    private void validateNonExistenceAccount(@NonNull Account account) {
        if (accountRepository.findByName(account.getName())
                .isPresent()) {
            throw new DomainException(String.format(EXISTING_ACCOUNT_MESSAGE_TEMPLATE, account.getName()));
        }
    }

}
