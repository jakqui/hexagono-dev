package mx.hexagonodev.proyectoprueba.domain.specification;

import java.util.Set;

import mx.hexagonodev.proyectoprueba.domain.vo.Personal;

public class DeptoValidodelPersonalSpec implements Specification<Personal> {

    private final Set<String> deptosActivos;

    public DeptoValidodelPersonalSpec(Set<String> deptosActivos) {
        this.deptosActivos = deptosActivos;
    }

    @Override
    public boolean isSatisfiedBy(Personal personal) {
        return deptosActivos.contains(personal.getDepartamento());
    }

}
