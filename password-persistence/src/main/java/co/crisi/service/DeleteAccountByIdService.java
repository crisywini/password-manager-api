package co.crisi.service;

import co.crisi.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.crisi.port.AccountRepository;

@Service
@RequiredArgsConstructor
public class DeleteAccountByIdService {
    private final AccountRepository accountRepository;
    private static final String NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE = "The account with id %s does not exists!";

    public boolean run(Long id) {
        validateExistingAccount(id);
        accountRepository.deleteById(id);
        return true;
    }

    private void validateExistingAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new DomainException(String.format(NON_EXISTING_ACCOUNT_MESSAGE_TEMPLATE, id));
        }
    }
}
