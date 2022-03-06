package co.crisi.adapter.jparepository;


import co.crisi.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import co.crisi.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountByAccountType(AccountType accountType);
    Optional<Account> findAccountByName(String name);
    List<Account> findAccountsByUserName(String userName);

}
