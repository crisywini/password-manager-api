package co.crisi.adapter;

import co.crisi.adapter.jparepository.AccountJpaRepository;

import java.util.List;
import java.util.Optional;

import co.crisi.domain.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountJpaRepository accountJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account saved = accountJpaRepository.save(account);
        return saved != null;
    }

    @Override
    public boolean delete(Account account) {
        boolean isDeleted = false;
        accountJpaRepository.delete(account);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean isDeleted = false;
        accountJpaRepository.deleteById(id);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        accountJpaRepository.deleteAllById(ids);
    }

    @Override
    public List<Account> findByType(AccountType accountType) {
        return accountJpaRepository.findAccountByAccountType(accountType);
    }

    @Override
    public List<Account> findAll() {
        return accountJpaRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return accountJpaRepository.existsById(id);
    }

    @Override
    public Optional<Account> findByName(String name) {
        return accountJpaRepository.findAccountByName(name);
    }

    @Override
    public List<Account> findByUser(String user) {
        return accountJpaRepository.findAccountsByUserName(user);
    }

}
