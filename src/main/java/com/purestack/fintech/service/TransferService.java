package com.purestack.fintech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
public class TransferService {

    // TODO: Inject AccountRepository here

    /**
     * Transfers money from one account to another.
     * This operation MUST be atomic.
     */
    @Transactional
    public void transfer(Long sourceId, Long targetId, BigDecimal amount) {
        // TODO: 1. Fetch source and target accounts
        // TODO: 2. Validate sufficient funds in source account
        // TODO: 3. Debit source
        // TODO: 4. Credit target
        // TODO: 5. Handle exceptions to trigger rollback
        
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
