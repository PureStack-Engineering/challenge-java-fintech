package com.purestack.fintech;

import com.purestack.fintech.service.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransferIntegrationTest {

    @Autowired
    private TransferService transferService;

    @Test
    void testTransferExecution() {
        Long sourceId = 1L;
        Long targetId = 2L;
        BigDecimal amount = new BigDecimal("100.00");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transferService.transfer(sourceId, targetId, amount);
        });

        // Este mensaje aparecerá en el log de GitHub Actions
        String expectedMessage = "Logic not implemented yet";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Unexpected error message");
        
        // Cuando el candidato implemente la lógica, DEBE actualizar este test 
        // o crear nuevos tests que verifiquen el éxito. 
        // Inicialmente, queremos que falle si quitamos el assertThrows, 
        // pero para el Gold Master, dejaremos que falle EXPLÍCITAMENTE la lógica funcional 
        // (es decir, el test de abajo es el que realmente queremos que vean fallar).
    }
    
    @Test
    void testRealTransferLogic() {
        // Este test es el que queremos ver ROJO inicialmente.
        // Simulamos que debería funcionar, pero como el servicio lanza Excepción, fallará.
        try {
             transferService.transfer(1L, 2L, new BigDecimal("50.00"));
        } catch (UnsupportedOperationException e) {
             fail("❌ FAILED: The transfer logic is not implemented.");
        }
    }
}
