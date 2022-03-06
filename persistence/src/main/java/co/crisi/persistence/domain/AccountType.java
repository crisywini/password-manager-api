package co.crisi.persistence.domain;

public enum AccountType {
    BANK("bank"),
    ACADEMIC("academic"),
    PERSONAL("personal");

    private String name;

    AccountType(String name){
        this.name = name;
    }
}
