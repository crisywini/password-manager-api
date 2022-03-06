package co.crisi.port;

import java.util.List;
import java.util.Optional;

import co.crisi.domain.Account;
import co.crisi.domain.AccountType;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    boolean save(Account account);

    boolean delete(Account account);

    boolean deleteById(Long id);

    void deleteAllById(List<Long> ids);

    List<Account> findByType(AccountType accountType);

    List<Account> findAll();

    boolean existsById(Long id);

    Optional<Account> findByName(String name);

    Optional<Account> findByUser(String user);

}
