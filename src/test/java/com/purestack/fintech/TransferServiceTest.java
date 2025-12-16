package com.purestack.fintech;

import com.purestack.fintech.model.Account;
import com.purestack.fintech.repository.AccountRepository;
import com.purestack.fintech.service.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransferServiceTest {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testTransferMoneySuccess() {
        // GIVEN: Two accounts with money
        Account alice = accountRepository.save(new Account("Alice", new BigDecimal("1000.00")));
        Account bob = accountRepository.save(new Account("Bob", new BigDecimal("500.00")));

        // WHEN: Transfer 100 from Alice to Bob
        transferService.transfer(alice.getId(), bob.getId(), new BigDecimal("100.00"));

        // THEN: Balances should be updated
        // Reload from DB to verify persistence
        Account updatedAlice = accountRepository.findById(alice.getId()).orElseThrow();
        Account updatedBob = accountRepository.findById(bob.getId()).orElseThrow();

        // 🚨 THIS WILL FAIL UNTIL IMPLEMENTED
        assertEquals(new BigDecimal("900.00"), updatedAlice.getBalance(), "Alice's balance incorrect");
        assertEquals(new BigDecimal("600.00"), updatedBob.getBalance(), "Bob's balance incorrect");
    }
}
