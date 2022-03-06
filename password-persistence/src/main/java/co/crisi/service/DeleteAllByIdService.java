package co.crisi.service;

import co.crisi.domain.Account;
import co.crisi.exception.DomainException;
import co.crisi.port.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteAllByIdService {
    private final AccountRepository accountRepository;
    private static final String ID_NON_EXISTING_MESSAGE_TEMPLATE = "Some ids does not exists!";

    public void run(List<Long> ids) {
        validateAllExistingIds(ids);
        accountRepository.deleteAllById(ids);
    }

    private void validateAllExistingIds(@NonNull List<Long> ids) {
        boolean allContains = accountRepository.findAll().stream()
                .map(Account::getId)
                .allMatch(ids::contains);
        if (!allContains) {
            throw new DomainException(ID_NON_EXISTING_MESSAGE_TEMPLATE);
        }
    }
}
