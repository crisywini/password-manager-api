package co.crisi.mapper;

import co.crisi.domain.Account;
import co.crisi.model.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    AccountDto accountToAccountDto(Account account);

    Account accountDtoToAccount(AccountDto accountDto);
}
