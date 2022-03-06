package co.crisi.model;

import co.crisi.domain.AccountType;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountDto implements Serializable {
    private Long id;
    private String name;
    private String userName;
    private AccountType accountType;
}
