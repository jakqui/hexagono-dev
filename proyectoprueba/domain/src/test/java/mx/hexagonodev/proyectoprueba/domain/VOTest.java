package mx.hexagonodev.proyectoprueba.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import mx.hexagonodev.proyectoprueba.domain.vo.RequisicionId;

public class VOTest {

    @Test
    void generarUUIDValido(){
        assertDoesNotThrow(() -> RequisicionId.withoutId());
    }

}
