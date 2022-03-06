package co.crisi.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AccountType {
    BANK("bank"),
    ACADEMIC("academic"),
    PERSONAL("personal"),
    N("none");

    private String name;

    AccountType(String name){
        this.name = name;
    }

    public AccountType of(String name){
        List<String> types = Arrays.stream(AccountType.values())
                .map(AccountType::name)
                .collect(Collectors.toList());
        if(!types.contains(name)){
            return N;
        }
        return AccountType.valueOf(name);
    }
}
