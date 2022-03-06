package co.crisi.application.service;


import co.crisi.domain.AccountType;
import co.crisi.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import co.crisi.domain.Account;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AddAccountService addAccountService;
    private final DeleteAccountService deleteAccountService;
    private final DeleteAccountByIdService deleteAccountByIdService;
    private final DeleteAllByIdService deleteAllByIdService;
    private final FindAllService findAllService;
    private final FindByTypeService findByTypeService;
    private final ExistsByIdService existsByIdService;
    private final FindByUserService findByUserService;

    public boolean add(Account account) {
        return addAccountService.run(account);
    }

    public boolean delete(Account account) {
        return deleteAccountService.run(account);
    }

    public boolean deleteById(Long id) {
        return deleteAccountByIdService.run(id);
    }

    public void deleteAllById(List<Long> ids) {
        deleteAllByIdService.run(ids);
    }

    public List<Account> findAll() {
        return findAllService.run();
    }

    public List<Account> findByType(AccountType accountType) {
        return findByTypeService.run(accountType);
    }

    public boolean existsById(Long id) {
        return existsByIdService.run(id);
    }

    public Optional<Account> findByUserName(String userName) {
        return findByUserService.run(userName);
    }
}
