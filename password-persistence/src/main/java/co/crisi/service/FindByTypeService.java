package co.crisi.service;

import co.crisi.domain.Account;
import co.crisi.domain.AccountType;
import co.crisi.exception.DomainException;
import co.crisi.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByTypeService {
    private final AccountRepository accountRepository;
    private static final String NO_VALID_ACCOUNT_TYPE_MESSAGE_TEMPLATE = "No valid account type!";

    public List<Account> run(AccountType accountType){
        validateExistingType(accountType);
        return accountRepository.findByType(accountType);
    }

    private void validateExistingType(AccountType accountType){
        if(accountType.equals(AccountType.N)){
            throw new DomainException(NO_VALID_ACCOUNT_TYPE_MESSAGE_TEMPLATE);
        }
    }
}
