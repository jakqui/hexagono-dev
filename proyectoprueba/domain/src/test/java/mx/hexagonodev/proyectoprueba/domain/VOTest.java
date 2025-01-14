package mx.hexagonodev.proyectoprueba.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;
import mx.hexagonodev.proyectoprueba.domain.vo.Personal;
import mx.hexagonodev.proyectoprueba.domain.vo.RequisicionId;

public class VOTest {
    static Set<String> deptosActivos;

    @BeforeAll
    static void setUp(){
        System.out.println("Iniciando pruebas unitarias para Value Objects");
        deptosActivos = Set.of("AM", "CE", "RH");
    }

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

    @Test
    void crearDescripcionGeneral_CuandoDescripcionValida_EntoncesCreaDescripcionGeneral(){
        String descripcion = "Descripcion de prueba";
        DescripcionGeneral descripcionGeneral = DescripcionGeneral.of(descripcion);
        System.out.println("crearDescripcionGeneral_CuandoDescripcionValida_EntoncesCreaDescripcionGeneral: [" + descripcionGeneral.getDescripcion() + "]");
        assertEquals(descripcion, descripcionGeneral.getDescripcion());
    }

    @Test
    void crearDescripcionGeneral_CuandoDescripcionNula_EntoncesLanzaExcepcion(){
        String descripcion = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DescripcionGeneral.of(null);
        });
        System.out.println("crearDescripcionGeneral_CuandoDescripcionNula_EntoncesLanzaExcepcion: [" + descripcion + "] " + exception.getMessage());
        assertTrue(exception.getMessage().contains("nula"));
    }

    @Test
    void crearDescripcionGeneral_CuandoDescripcionDe1000Caracteres_EntoncesCreaExitosamente() {
        // GENERA UNA DESCRIPCION DE 1000 CARACTERES
        String descripcion = "a".repeat(1000);
        DescripcionGeneral descripcionGeneral = DescripcionGeneral.of(descripcion);
        System.out.println("crearDescripcionGeneral_CuandoDescripcionValida_EntoncesCreaDescripcionGeneral: [" + descripcionGeneral.getDescripcion() + "]");
        assertEquals(descripcion, descripcionGeneral.getDescripcion());
    }

    @Test
    void crearDescripcionGeneral_CuandoDescripcionMayorA1000Caracteres_EntoncesLanzaExcepcion() {
        // GENERA UNA DESCRIPCION DE 1001 CARACTERES
        String descripcion = "a".repeat(1001);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DescripcionGeneral.of(descripcion);
        });
        System.out.println("crearDescripcionGeneral_CuandoDescripcionMayorA1000Caracteres_EntoncesLanzaExcepcion: [" + descripcion + "] " + exception.getMessage());
        assertTrue(exception.getMessage().contains("1000"));
    }

    @Test
    void crearPersonal_CuandoDepartamentoValido_EntoncesCreaPersonal(){
        String nombre = "Francisco Galván";
        String departamento = "AM";
        int numeroEmpleado = 430;
        
        Personal personal = Personal.of(nombre, departamento, numeroEmpleado, deptosActivos);

        System.out.println("crearPersonal_CuandoDepartamentoValido_EntoncesCreaPersonal: [" + personal.getNombre() +" " +personal.getDepartamento() + " " +personal.getNumeroEmpleado()+ "]");
        assertEquals(nombre, personal.getNombre());
        assertEquals(departamento, personal.getDepartamento());
        assertEquals(numeroEmpleado, personal.getNumeroEmpleado());
    }

    @Test
    void crearPersonal_CuandoDepartamentoInvalido_EntoncesLanzaExcepcion(){
        String nombre = "Francisco Galván";
        String departamento = "TI";
        int numeroEmpleado = 430;
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Personal.of(nombre, departamento, numeroEmpleado, deptosActivos);
        });

        System.out.println("crearPersonal_CuandoDepartamentoInvalido_EntoncesLanzaExcepcion: [" + nombre +" " +departamento + " " +numeroEmpleado+ "] " + exception.getMessage());
        assertTrue(exception.getMessage().contains("departamento"));
    }

}
