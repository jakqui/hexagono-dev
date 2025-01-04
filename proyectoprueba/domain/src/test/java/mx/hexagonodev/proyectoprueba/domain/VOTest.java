package mx.hexagonodev.proyectoprueba.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import mx.hexagonodev.proyectoprueba.domain.vo.RequisicionId;

public class VOTest {

    @Test
    void withId_CuandoUUIDValido_EntoncesCreaRequisicionId(){
        /*String validUUID = "01942d29-2802-7a91-87cd-35186ea0522c";
        RequisicionId requisicionId = RequisicionId.withId(validUUID);
        System.out.println("withId_CuandoUUIDValido_EntoncesCreaRequisicionId: "+requisicionId.getId().toString());
        assertEquals(UUID.fromString(validUUID), requisicionId.getId());*/

        RequisicionId requisicionId = RequisicionId.withoutId();
        RequisicionId nuevoRequisicionId = RequisicionId.withId(requisicionId.getId().toString());
        System.out.println("withId_CuandoUUIDValido_EntoncesCreaRequisicionId: ["+requisicionId.getId().toString() + "]");
        assertEquals(requisicionId.getId(), nuevoRequisicionId.getId());

        //VERSION 4
        /*String validUUID = "25c989a1-6d54-4b27-a250-16f92365e729";
        RequisicionId requisicionId = RequisicionId.withId(validUUID);
        System.out.println("withId_CuandoUUIDValido_EntoncesCreaRequisicionId: "+requisicionId.getId().toString());
        assertEquals(UUID.fromString(validUUID), requisicionId.getId());*/
    }

    @Test
    void withId_CuandoUUIDInvalido_EntoncesLanzaExcepcion(){
        String invalidUUID = "25c989a1-6d54-4b27-a250-16f92365e729";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                RequisicionId.withId(invalidUUID);
            });
        System.out.println("withId_CuandoUUIDInvalido_EntoncesLanzaExcepcion: [" + invalidUUID+"] " +exception.getMessage());
        assertTrue(exception.getMessage().contains("Version"));
    }

    @Test
    void withId_CuandoSeGeneraAutomaticamente_EntoncesCreaUUIDValido(){
        RequisicionId requisicionId = RequisicionId.withoutId();
        UUID uuid = requisicionId.getId();
        System.out.println("withId_CuandoSeGeneraAutomaticamente_EntoncesCreaUUIDValido: [" +
                            requisicionId.getId()+"]" +
                            " version: " + uuid.version() + 
                            " variante: " + uuid.variant());
        assertEquals(7, uuid.version());
        assertEquals(2, uuid.variant());
    }

    @Test
    void validUUIDv7_CuandoUUIDInvalidoPorVariante_EntoncesRetornaFalse() {
        UUID invalidVariantUUID = new UUID(0x7012345612345678L, 0x1234567890abcdefL);
        // Variante incorrecta
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new RequisicionId(invalidVariantUUID);
        });
        System.out.println("validUUIDv7_CuandoUUIDInvalidoPorVariante_EntoncesRetornaFalse: " +
                invalidVariantUUID + " " + exception.getMessage());
        System.out.println("Variante" + invalidVariantUUID.variant());
                assertTrue(exception.getMessage().contains("Variante"));
    }

}
