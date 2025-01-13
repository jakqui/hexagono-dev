package mx.hexagonodev.proyectoprueba.domain.specification;

import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;

public class DescripcionNotNullorEmptySpec implements Specification<DescripcionGeneral> {

  @Override
  public boolean isSatisfiedBy(DescripcionGeneral descripcionGeneral) {
    return descripcionGeneral.getDescripcion() != null && !descripcionGeneral.getDescripcion().isEmpty();
  }

}
