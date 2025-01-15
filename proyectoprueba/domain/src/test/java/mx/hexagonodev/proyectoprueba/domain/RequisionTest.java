package mx.hexagonodev.proyectoprueba.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import mx.hexagonodev.proyectoprueba.domain.entity.DetalleRequisicion;
import mx.hexagonodev.proyectoprueba.domain.entity.RequisicionInsumos;
import mx.hexagonodev.proyectoprueba.domain.vo.Cantidad;
import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;
import mx.hexagonodev.proyectoprueba.domain.vo.Personal;
import mx.hexagonodev.proyectoprueba.domain.vo.Id;
import mx.hexagonodev.proyectoprueba.domain.vo.TipoRequisicion;

public class RequisionTest {

    @Test
    void buildRequisicionInsumosConstruction() {
        DescripcionGeneral descripcionGeneral = DescripcionGeneral.of("Requicision para Stock");
        Personal solicitante = new Personal("Damian Vazquez", "AM", 1000);
        Personal autorizador = new Personal("Francisco Galvan", "AM", 430);
        Personal receptor = new Personal("Francisco Galvan", "AM", 430);
        TipoRequisicion tipoRequisicion = TipoRequisicion.INSUMOS;

        // Act
        RequisicionInsumos requisicion = RequisicionInsumos.builder()
                .id(Id.withoutId())
                .descripcionGeneral(descripcionGeneral)
                .solicitante(solicitante)
                .autorizador(autorizador)
                .receptor(receptor)
                .tipoRequisicion(tipoRequisicion)
                .build();

        System.out.println("Build RequisicionInsumos: " + requisicion);

        // Assert
        assertNotNull(requisicion);
        assertEquals(descripcionGeneral, requisicion.getDescripcionGeneral());
        assertEquals(solicitante, requisicion.getSolicitante());
        assertEquals(autorizador, requisicion.getAutorizador());
        assertEquals(receptor, requisicion.getReceptor());
        assertEquals(tipoRequisicion, requisicion.getTipoRequisicion());
    }

    @Test
    void agregarDetalle_CuandoSeAgregaDetalle_EntoncesNoEstaVacio() {
        DescripcionGeneral descripcionGeneral = DescripcionGeneral.of("Requicision para Stock");
        Personal solicitante = new Personal("Damian Vazquez", "AM", 1000);
        Personal autorizador = new Personal("Francisco Galvan", "AM", 430);
        Personal receptor = new Personal("Francisco Galvan", "AM", 430);
        TipoRequisicion tipoRequisicion = TipoRequisicion.INSUMOS;

        RequisicionInsumos requisicion = RequisicionInsumos.builder()
                .id(Id.withoutId())
                .descripcionGeneral(descripcionGeneral)
                .solicitante(solicitante)
                .autorizador(autorizador)
                .receptor(receptor)
                .tipoRequisicion(tipoRequisicion)
                .build();

        // Act
        requisicion.agregarDetalle(DetalleRequisicion.of(Id.withoutId(), Cantidad.of(10), DescripcionGeneral.of("Detalle de la requisicion")));
        requisicion.agregarDetalle(DetalleRequisicion.of(Id.withoutId(), Cantidad.of(10), DescripcionGeneral.of("Detalle de la requisicion")));
        // Assert
        assertEquals(false, requisicion.estaVacia());
    }
}
