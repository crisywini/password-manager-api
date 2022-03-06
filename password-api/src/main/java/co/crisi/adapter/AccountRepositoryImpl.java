package co.crisi.adapter;

import co.crisi.adapter.jparepository.AccountJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import co.crisi.domain.Account;
import co.crisi.port.AccountRepository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public boolean save(Account account) {
        return false;
    }

    @Override
    public boolean delete(Account account) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<Account> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> getByUser(String user) {
        return Optional.empty();
    }
}
