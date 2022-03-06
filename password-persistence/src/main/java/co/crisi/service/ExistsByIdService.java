package co.crisi.service;

import co.crisi.port.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExistsByIdService {
    private final AccountRepository accountRepository;

    public boolean run(Long id) {
        return accountRepository.existsById(id);
    }
}
