package mx.hexagonodev.proyectoprueba.domain.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.experimental.SuperBuilder;
import mx.hexagonodev.proyectoprueba.domain.vo.Id;

@SuperBuilder
public final class RequisicionInsumos extends RequisicionCompra {
    private final Map<Id, DetalleRequisicion> detalles = new HashMap<>();

    public void agregarDetalle(DetalleRequisicion detalle) {
        detalles.put(detalle.getId(), detalle);
    }

    public void eliminarDetalle(Id id) {
        detalles.remove(id);
    }

    public boolean estaVacia() {
        return detalles.isEmpty();
    }
}
