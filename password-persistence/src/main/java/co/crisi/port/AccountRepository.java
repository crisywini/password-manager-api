package co.crisi.port;

import java.util.Optional;

import co.crisi.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    boolean save(Account account);

    boolean delete(Account account);

    boolean deleteById(Long id);

    boolean existsById(Long id);

    Optional<Account> findByName(String name);


    Optional<Account> getByUser(String user);

}
