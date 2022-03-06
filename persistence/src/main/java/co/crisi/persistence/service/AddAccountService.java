package co.crisi.persistence.service;

import co.crisi.persistence.domain.Account;
import co.crisi.persistence.exception.DomainException;
import co.crisi.persistence.port.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddAccountService {
    private final AccountRepository accountRepository;
    private static final String EXISTING_ACCOUNT_MESSAGE_TEMPLATE = "The account with name %s already exists";

    public boolean add(Account account) {
        validateNonExistenceAccount(account);
        return accountRepository.add(account);
    }

    private void validateNonExistenceAccount(@NonNull Account account) {
        if (accountRepository.getByName(account.getName())
                .isPresent()) {
            throw new DomainException(String.format(EXISTING_ACCOUNT_MESSAGE_TEMPLATE, account.getName()));
        }
    }

}
