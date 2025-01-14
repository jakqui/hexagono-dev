package mx.hexagonodev.proyectoprueba.domain.vo;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.hexagonodev.proyectoprueba.domain.specification.DeptoValidodelPersonalSpec;
import mx.hexagonodev.proyectoprueba.domain.specification.Specification;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    String nombre;
    String departamento;
    int numeroEmpleado;

    public static Personal of(String nombre, String departamento, int numeroEmpleado,
                                Set<String> deptosActivos) {        
        Specification<Personal> spec = new DeptoValidodelPersonalSpec(deptosActivos);
        Personal personal = new Personal(nombre, departamento, numeroEmpleado);
        if(!spec.isSatisfiedBy(personal)){
            throw new IllegalArgumentException("El departamento no es válido");
        }
        return personal;
    }

}
