package co.crisi.persistence.service;

import co.crisi.persistence.exception.DomainException;
import co.crisi.persistence.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAccountByIdService {
    private final AccountRepository accountRepository;
    private static final String NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE = "The account with id %s does not exists!";

    public boolean run(Long id) {
        validateExistingAccount(id);
        return accountRepository.deleteById(id);
    }

    private void validateExistingAccount(Long id) {
        if (accountRepository.getById(id).isEmpty()) {
            throw new DomainException(String.format(NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE, id));
        }
    }
}
