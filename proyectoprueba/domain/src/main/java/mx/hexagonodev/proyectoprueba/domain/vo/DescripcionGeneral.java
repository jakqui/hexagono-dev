package mx.hexagonodev.proyectoprueba.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.hexagonodev.proyectoprueba.domain.specification.DescripcionNotNullorEmptySpec;
import mx.hexagonodev.proyectoprueba.domain.specification.DescripcionMaxLengthSpec;
import mx.hexagonodev.proyectoprueba.domain.specification.Specification;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DescripcionGeneral {
    String descripcion;

    public static DescripcionGeneral of(String descripcion) {
        Specification<DescripcionGeneral> notNullspec = new DescripcionNotNullorEmptySpec();
        Specification<DescripcionGeneral> lenghtSpec = new DescripcionMaxLengthSpec();
        DescripcionGeneral descripcionGeneral = new DescripcionGeneral(descripcion);

        // Combina ambas especificaciones con `and`
        //Specification<DescripcionGeneral> specifications = notNullspec.and(lenghtSpec);

        if (!notNullspec.isSatisfiedBy(descripcionGeneral)) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }

        if (!lenghtSpec.isSatisfiedBy(descripcionGeneral)) {
            throw new IllegalArgumentException("La descripción no puede tener un tamaño mayor a 1000 caracteres");
        }
        return new DescripcionGeneral(descripcion);
    }
}
