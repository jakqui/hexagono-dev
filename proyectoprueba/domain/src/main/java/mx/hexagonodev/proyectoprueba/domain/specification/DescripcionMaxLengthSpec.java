package mx.hexagonodev.proyectoprueba.domain.specification;

import mx.hexagonodev.proyectoprueba.domain.vo.DescripcionGeneral;

public class DescripcionMaxLengthSpec implements Specification<DescripcionGeneral> {
  
  private static final int MAX_LENGTH = 1000;

  @Override
  public boolean isSatisfiedBy(DescripcionGeneral descripcionGeneral) {
    return descripcionGeneral.getDescripcion().length() <= MAX_LENGTH;
  }

}
