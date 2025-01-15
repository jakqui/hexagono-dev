package mx.hexagonodev.proyectoprueba.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mx.hexagonodev.proyectoprueba.domain.vo.Cantidad;
import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;
import mx.hexagonodev.proyectoprueba.domain.vo.Id;

@Getter
@AllArgsConstructor
public class DetalleRequisicion {
    private final Id id;
    private final Cantidad cantidad;
    private final DescripcionGeneral descripcion;

    public static DetalleRequisicion of(Id id, Cantidad cantidad, DescripcionGeneral descripcion) {
        return new DetalleRequisicion(id, cantidad, descripcion);
    }
}
