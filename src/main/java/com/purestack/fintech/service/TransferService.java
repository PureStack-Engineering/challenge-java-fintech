package com.purestack.fintech.service;

import com.purestack.fintech.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountRepository repository;

    public TransferService(AccountRepository repository) {
        this.repository = repository;
    }

    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        // TODO: Candidate must implement ACID transaction logic here
        // 1. Validate amount > 0
        // 2. Fetch accounts
        // 3. Check balance
        // 4. Update balances
        // 5. Save
        
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
