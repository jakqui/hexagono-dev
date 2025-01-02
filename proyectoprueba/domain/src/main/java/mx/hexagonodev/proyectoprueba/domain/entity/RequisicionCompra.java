package mx.hexagonodev.proyectoprueba.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mx.hexagonodev.proyectoprueba.domain.vo.RequisicionId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RequisicionCompra {
    RequisicionId id;
}
