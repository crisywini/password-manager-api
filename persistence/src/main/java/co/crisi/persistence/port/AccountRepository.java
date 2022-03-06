package co.crisi.persistence.port;

import co.crisi.persistence.domain.Account;
import co.crisi.persistence.domain.AccountType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository {
    boolean add(Account account);

    boolean remove(Account account);

    boolean removeById(Long id);

    List<Account> getAll();

    List<Account> getAllByType(AccountType accountType);

    Optional<Account> getByName(String name);

    Optional<Account> getByUser(String user);

    Optional<Account> getById(Long user);

}
