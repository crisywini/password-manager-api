package co.crisi.adapter.jparepository;


import org.springframework.data.jpa.repository.JpaRepository;
import co.crisi.domain.Account;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
