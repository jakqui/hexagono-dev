package mx.hexagonodev.proyectoprueba.domain.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;
import mx.hexagonodev.proyectoprueba.domain.vo.Personal;
import mx.hexagonodev.proyectoprueba.domain.vo.Id;
import mx.hexagonodev.proyectoprueba.domain.vo.TipoRequisicion;

@Data
@SuperBuilder
public abstract  sealed class RequisicionCompra 
permits RequisicionInsumos, RequisicionServicios{
    private final Id id;
    private final DescripcionGeneral descripcionGeneral;
    private final Personal solicitante;
    private final Personal autorizador;
    private final Personal receptor;
    private final TipoRequisicion tipoRequisicion;
}
